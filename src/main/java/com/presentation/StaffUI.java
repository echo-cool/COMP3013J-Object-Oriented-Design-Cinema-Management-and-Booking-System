package com.presentation;

import com.application.domain.ManagementSystem;
import com.application.domain.ScreeningObserver;
import com.application.models.Movie;
import com.application.models.Screen;
import com.application.models.Screening;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Pair;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StaffUI implements ScreeningObserver {
    //The UI controls of this application
    final static int LEFT_MARGIN = 70;
    final static int TOP_MARGIN = 50;
    final static int BOTTOM_MARGIN = 50;
    final static int ROW_HEIGHT = 60;
    final static int COL_WIDTH = 75;
    final static int SLOTS = 12;                    // Number of booking slots shown
    public LocalDate currentDate = LocalDate.now();
    public Screening[] currentScreenings = new Screening[0];
    @FXML
    public Canvas canvas1;
    ManagementSystem managementSystem;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Canvas canvas;
    private double start_x = 0;
    private double start_y = 0;
    private boolean is_dragging = false;
    private double dragged_x = 0;
    private double dragged_y = 0;

    public StaffUI() {

    }


    /**
     * Initialization completes system and UI startup
     */
    public void initialize() {
        // utilize singleton design
        managementSystem = ManagementSystem.getInstance();
        managementSystem.addObserver(this);
        datePicker.setValue(LocalDate.now());
        managementSystem.setDate(LocalDate.now());
        datePicker.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
                managementSystem.setDate(newValue);
            }
        });
        this.draw();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    GraphicsContext gc1 = canvas1.getGraphicsContext2D();
                    gc1.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    canvas1.setHeight(TOP_MARGIN + 6 * ROW_HEIGHT + 100);
                    canvas1.setWidth(LEFT_MARGIN + (SLOTS * COL_WIDTH) + 50);
                    gc1.setLineWidth(2.0);
                    gc1.setFill(Color.BLACK);
                    gc1.setStroke(Color.YELLOW);
                    gc1.setFont(new Font(12));
                    gc1.fillText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), timeToX(LocalTime.now()) - 25, 44);
                    gc1.strokeLine(timeToX(LocalTime.now()), TOP_MARGIN, timeToX(LocalTime.now()), canvas.getHeight());
                    gc1.setStroke(Color.BLACK);
                    gc1.setFont(new Font(15));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


    /**
     * Refresh the interface
     */
    @Override
    public void update() {
        currentScreenings = managementSystem.getScreenings();
        draw();
    }


    /**
     * Pop-up message box
     * @param message The message content
     * @param isConfirmation Whether user confirmation is required
     * @return Confirm or cancel
     */
    @Override
    public boolean message(String message, boolean isConfirmation) {
        if (isConfirmation) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(message);
//        alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                update();
                return true;
            } else {
                update();
                return false;
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(message);
//            alert.setContentText("I have a great message for you!");

            alert.showAndWait();
            update();
            return true;
        }
    }

    /**
     * Returns a mapping of time to screen coordinates
     * @param time time in day
     * @return location on screen
     */
    private int timeToX(LocalTime time) {
        return (int) ((time.getHour() * 60 + time.getMinute()) / (60 * 24f) * (SLOTS * COL_WIDTH) + LEFT_MARGIN);
    }

    /**
     * Returns a mapping of screen coordinates to time
     * @param x location on screen
     * @return time in day
     */
    private LocalTime xToTime(int x) {
        return LocalTime.ofSecondOfDay(Math.min(3600 * 24 - 1, Math.max((long) (60 * ((24 * 60f * (x - LEFT_MARGIN) / (SLOTS * COL_WIDTH)))), 0)));
    }

    /**
     * Returns a mapping of screen coordinates to Screen
     * @param screen the screen name
     * @return location on screen
     */
    private int screenToY(String screen) {
//        System.out.println(">>>>>>"+screen);
        return TOP_MARGIN + managementSystem.findScreenIndex(screen) * ROW_HEIGHT;
    }

    /**
     * Returns Screen to screen coordinate mapping
     * @param y location on screen
     * @return the screen name
     */
    private String yToScreen(int y) {
        return managementSystem.getScreens()[Math.min(Math.max((y - TOP_MARGIN) / ROW_HEIGHT, 0), 5)].getName();
    }


    /**
     * pops up set ticket dialog
     */
    public void sellTicket() {
        List<String> choices = new ArrayList<>();
        choices.add("1");
        choices.add("2");
        choices.add("3");
        choices.add("4");
        choices.add("5");
        choices.add("6");
        choices.add("7");
        choices.add("8");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("1", choices);
        dialog.setTitle("Sell Dialog");
        dialog.setHeaderText("Choose Number");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            managementSystem.sellTicket(Integer.parseInt(result.get()));
        }
    }


    /**
     * pops up schedule dialog
     */
    public void showScheduleScreeningDialog() {
        ScheduleDialog addRes = new ScheduleDialog(managementSystem.getAllMovies());
        Optional<ScheduleInfo> result = addRes.showAndWait();

        if (result.isPresent()) {
            ScheduleInfo c = result.get();
            if (!managementSystem.scheduleScreening(currentDate, c.getTime(), c.getScreen(), c.getName())) {
                showScheduleScreeningDialog();
            }
        }
        update();
    }

    /**
     * draw on the screen
     */
    public void draw() {
        ArrayList<Screen> screens = new ArrayList();
        for (Screen s : managementSystem.getScreens()) {
            screens.add(s);
        }
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        canvas.setHeight(TOP_MARGIN + screens.size() * ROW_HEIGHT + 2);
        canvas.setWidth(LEFT_MARGIN + (SLOTS * COL_WIDTH) + 50);
        gc.setLineWidth(2.0);
        gc.setFill(Color.BLACK);
        //
        // // Draw screen outlines
        //
        gc.strokeLine(LEFT_MARGIN, TOP_MARGIN, LEFT_MARGIN, canvas.getHeight());
        gc.strokeLine(0, TOP_MARGIN, canvas.getWidth(), TOP_MARGIN);
        //
        for (int i = 0; i < screens.size(); i++) {
            int y = TOP_MARGIN + (i + 1) * ROW_HEIGHT;
            gc.setFont(new Font(15));
            if (managementSystem.getSelectedScreening() != null)
                if (screens.get(i).equals(managementSystem.getSelectedScreening().getScreen())) {
                    gc.setFill(Color.RED);
                } else {
                    gc.setFill(Color.BLACK);
                }
            gc.fillText(screens.get(i).getName(), 5, y - ROW_HEIGHT / 3 - 7);
            gc.setFill(Color.BLACK);
            gc.setFont(new Font(10));
            gc.fillText("Capacity: " + screens.get(i).getCapacity(), 5, y - ROW_HEIGHT / 3 + 10);
            gc.strokeLine(0, y, canvas.getWidth(), y);
        }
        gc.setFont(new Font(15));
        LocalTime start = LocalTime.of(0, 0);
        for (int i = 0; i < SLOTS + 1; i++) {
            LocalTime show = start.plusMinutes(i * 120);
            String tmp = show.getHour() + ":" + (show.getMinute() > 9 ? show.getMinute() : "0" + show.getMinute());
            int x = LEFT_MARGIN + i * COL_WIDTH;
            gc.fillText(tmp, x - 15, 30);
            gc.strokeLine(x, TOP_MARGIN, x, canvas.getHeight());
        }

        for (Screening screening : currentScreenings) {
            if (screening.getTicketSold() > 0)
                gc.setFill(Color.LIGHTGREEN);
            else
                gc.setFill(Color.LIGHTPINK);
//            gc.setFill(Color.rgb((int) (255 * (screening.getTicketSold() / (float) screening.getScreen().getCapacity())), 255 - (int) (255 * (screening.getTicketSold() / (float) screening.getScreen().getCapacity())), 0, 0.7));
            gc.fillRect(
                    timeToX(screening.getStartTime()),
                    screenToY(screening.getScreen().getName()),
                    COL_WIDTH * SLOTS * ((screening.getMovie().getDuration()) / (3600f * 24f)),
                    ROW_HEIGHT);
            gc.setFill(Color.BLACK);
            gc.setFont(new Font(10));
            String movie_name = screening.getMovie().getName();
            Integer scale_factor = 8 * 60;
            if (movie_name.length() >= screening.getMovie().getDuration() / scale_factor) {
                movie_name = movie_name.substring(0, screening.getMovie().getDuration() / scale_factor) + "...";
            }
            gc.fillText(movie_name + "\nsell: " + screening.getTicketSold(), timeToX(screening.getStartTime()) + 5,
                    screenToY(screening.getScreen().getName()) + ROW_HEIGHT * 0.4);
            gc.strokeRect(timeToX(screening.getStartTime()),
                    screenToY(screening.getScreen().getName()),
                    COL_WIDTH * SLOTS * ((screening.getMovie().getDuration()) / (3600f * 24f)),
                    ROW_HEIGHT);
            if (screening.equals(managementSystem.getSelectedScreening())) {
                gc.strokeRect(timeToX(screening.getStartTime()) + 2,
                        screenToY(screening.getScreen().getName()) + 2,
                        COL_WIDTH * SLOTS * ((screening.getMovie().getDuration()) / (3600f * 24f)) - 4,
                        ROW_HEIGHT - 4);
            }
        }

        if (managementSystem.getSelectedScreening() != null && is_dragging) {
            if (managementSystem.getSelectedScreening().getTicketSold() > 0) {
                gc.setFill(Color.rgb(0, 255, 0, 0.7));
            } else {
                gc.setFill(Color.rgb(255, 182, 193, 0.7));
            }
            float x = Math.min(timeToX(xToTime((int) (timeToX(managementSystem.getSelectedScreening().getStartTime()) - start_x + dragged_x))), -1 + LEFT_MARGIN + COL_WIDTH * SLOTS - COL_WIDTH * SLOTS * ((managementSystem.getSelectedScreening().getMovie().getDuration()) / (3600f * 24f)));
            float y = screenToY(yToScreen((int) dragged_y));
            gc.fillRect(
                    x,
                    y,
                    COL_WIDTH * SLOTS * ((managementSystem.getSelectedScreening().getMovie().getDuration()) / (3600f * 24f)),
                    ROW_HEIGHT);

            gc.setStroke(Color.RED);
            gc.strokeLine(x, TOP_MARGIN, x, canvas.getHeight());
            gc.setStroke(Color.BLACK);
            gc.fillText(xToTime((int) x).format(DateTimeFormatter.ISO_TIME), x - 15, 40);
            gc.fillText(xToTime((int) x).format(DateTimeFormatter.ISO_TIME), x - 45, y + ROW_HEIGHT * 0.5);
        }
    }


    /**
     * go to the next day
     */
    public void nextDay() {
        currentDate = datePicker.getValue();
        currentDate = currentDate.plusDays(1);
        datePicker.setValue(currentDate);
        managementSystem.setDate(currentDate);
    }

    /**
     * go to the prev day
     */
    public void prevDay() {
        currentDate = datePicker.getValue();
        currentDate = currentDate.minusDays(1);
        datePicker.setValue(currentDate);
        managementSystem.setDate(currentDate);
    }

    /**
     * pop up add movie dialog
     */
    public void showAddMovieView() {
        Dialog<Pair<String, Integer>> dialog = new Dialog<>();
        dialog.setTitle("Add Movie Dialog");
        dialog.setHeaderText("Add a Movie");

// Set the button types.
        ButtonType loginButtonType = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

// Create the movie_name and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField movie_name = new TextField();
        movie_name.setPromptText("Movie Name");

        TextField duration = new TextField();

        duration.setPromptText("Duration (minutes)");

        grid.add(new Label("Movie Name:"), 0, 0);
        grid.add(movie_name, 1, 0);
        grid.add(new Label("Duration(minutes):"), 0, 1);
        grid.add(duration, 1, 1);

// Enable/Disable login button depending on whether a movie_name was entered.
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

// Do some validation (using the Java 8 lambda syntax).
        movie_name.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

// Request focus on the movie_name field by default.
        Platform.runLater(() -> movie_name.requestFocus());

// Convert the result to a movie_name-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(movie_name.getText(), Integer.parseInt(duration.getText()));
            }
            return null;
        });

        Optional<Pair<String, Integer>> result = dialog.showAndWait();

        result.ifPresent(input -> {
//            System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
            Movie moviePersistent = new Movie(
                    input.getKey(),
                    input.getValue() * 60
            );
            managementSystem.addMovie(moviePersistent);
        });
    }

    public void showDate(ActionEvent actionEvent) {

    }

    /**
     * awake system to cancel schedule
     * @param actionEvent
     */
    public void cancelSchedule(ActionEvent actionEvent) {
        managementSystem.cancelSelected();
    }

    /**
     * awake system to update date
     * @param actionEvent
     */
    public void test(ActionEvent actionEvent) {
        managementSystem.setDate(currentDate);
    }

    public void onMouseClicked(MouseEvent mouseEvent) {

    }

    public void onMouseDragEntered(MouseEvent mouseEvent) {

    }

    public void onMouseDragExited(MouseEvent mouseEvent) {

    }

    /**
     * record mouse drag event
     * @param mouseEvent
     */
    public void onMouseDragged(MouseEvent mouseEvent) {
        is_dragging = true;
        dragged_x = mouseEvent.getX();
        dragged_y = mouseEvent.getY();
        update();
    }

    /**
     * handle mouse released event
     * @param mouseEvent
     */
    public void onMouseReleased(MouseEvent mouseEvent) {
        if (managementSystem.getSelectedScreening() != null && is_dragging) {
            is_dragging = false;
            System.out.println(managementSystem.updateSelected(xToTime((int) (Math.min(timeToX(xToTime((int) (timeToX(managementSystem.getSelectedScreening().getStartTime()) - start_x + dragged_x))), -1 + LEFT_MARGIN + COL_WIDTH * SLOTS - COL_WIDTH * SLOTS * ((managementSystem.getSelectedScreening().getMovie().getDuration()) / (3600f * 24f))))), yToScreen((int) dragged_y)));
        }
    }

    /**
     * handle mouse pressed event
     * @param mouseEvent
     */
    public void onMousePressed(MouseEvent mouseEvent) {
        start_x = mouseEvent.getX();
        start_y = mouseEvent.getY();
        LocalTime time = xToTime((int) mouseEvent.getX());
        System.out.printf("%s,%s\n", time, mouseEvent.getY());
        String screen = yToScreen((int) mouseEvent.getY());
        managementSystem.changeSelected(time, screen);
    }

}

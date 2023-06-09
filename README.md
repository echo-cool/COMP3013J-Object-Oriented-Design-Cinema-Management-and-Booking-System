# COMP3013J_Assignment

[![Java CI with Maven](https://github.com/echo-cool/COMP3013J-Object-Oriented-Design-Cinema-Management-and-Booking-System/actions/workflows/maven-publish.yml/badge.svg)](https://github.com/echo-cool/COMP3013J-Object-Oriented-Design-Cinema-Management-and-Booking-System/actions/workflows/maven-publish.yml)

## Video Explanation Link
Weiyun link: https://share.weiyun.com/M9geoGak

## Project Preview
![](assets/demo.gif)

## Build

To build this project, it would be easier if you have maven installed. Please run the following command in the terminal:

```shell
mvn clean
mvn compile
```

## Package

```shell
mvn package -Dmaven.test.skip=true
```

## Run

You can either use IDEA to start the project or use the following command in the terminal after the package stage:

```shell
java -jar target/COMP3013J-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Functionality
##### Add new movie
1. Click the "Add Movie" button
2. Enter the "movie name" and "duration" of this movie
3. Click ok to store the newly added movie into the database

##### Schedule new movie screening
1. Click the "Schedule" button
2. Enter the "movie name", "start time", and "screen" number of this movie
3. Click ok to store the newly added movie screening into the database
1. Constraint: Cannot schedule movie screening spanning different days
2. Constraint: Cannot schedule movie screening that overlaps the existing ones

##### Reschedule movie screening
1. Select a movie screening
2. Drag the selected movie screening to the expected area
3. Constraint: Cannot drag/reschedule movie screening that overlaps the existing ones
4. Constraint: Cannot drag/reschedule movie screening out of the screen bounds
5. Constraint: Cannot drag/reschedule movie screening with tickets sold

##### Cancel movie screening
1. Select a movie screening
2. Click the "Cancel" button
3. Click ok
4. Constraint: Cannot cancel movie screening with tickets sold

##### Sell tickets
1. Select a movie screening
2. Click "Sell" button
3. Select the number of tickets to sell
4. Constraint: Cannot sell tickets out of the screen's capacity

## Use Case

##### Use Case 1:

Display Screening Tickets Sold Capacity

##### Use Case 2:

Schedule Movie Screening

##### Use Case 3:

Reschedule Movie Screening

##### Use Case 4:

Cancel Movie Screening

##### Use Case 5:

Sell Tickets


## Assumptions

Assumption 1:
The cinema only allows customers to buy tickets offline (in the cinema).

Assumption 2:
One person can buy multiple tickets. The cinema staff needs to specify how many
tickets will be sold to a customer when performing the "Sell Tickets" use case.

Assumption 3:
Refunds are not allowed.

Assumption 4:
The cinema staff should only be able to sell tickets up to the capacity of the screen. If the cinema staff attempts to sell any more tickets than the screen capacity, there should be an error.

Assumption 5:
Consider each seat as the same, so that the system does not allocate the seat number for each ticket sold.

Assumption 6:
Cinema staff can only reschedule a movie screening (timeslot and screen) to another
available timeslot and screen on the **same** day.

Assumption 7:
The cinema staff can display the scheduled times for movie screening in one day at a time and which screen they are being shown on as well as the number of tickets sold for each and the capacity of the screens for any day (past days, today and future days).

Assumption 8:
The cinema staff can schedule, reschedule, cancel movie screenings for the current day and the next coming days as long as there are no tickets sold for that movie screening.

Assumption 9:
The cinema staff cannot reschedule an existing movie screening to a different start time if there are already tickets sold for that screening.

## Project Screenshots

![](assets/Screen%20Shot%202021-12-10%20at%2015.04.45.png)
![](assets/Screen%20Shot%202021-12-10%20at%2015.04.58.png)
![](assets/Screen%20Shot%202021-12-10%20at%2015.05.30.png)
![](assets/Screen%20Shot%202021-12-10%20at%2015.05.39.png)
![](assets/Screen%20Shot%202021-12-10%20at%2015.05.44.png)

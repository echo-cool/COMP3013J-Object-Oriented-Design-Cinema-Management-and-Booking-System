package com.application.domain;

public interface ScreeningObserver {
    // Observe data change and update the display
    void update();
    boolean message(String message, boolean isConfirmation);
}

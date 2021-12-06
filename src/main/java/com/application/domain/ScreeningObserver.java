package com.application.domain;

public interface ScreeningObserver {
    void update();

    boolean message(String message,boolean isConfirmation);
}

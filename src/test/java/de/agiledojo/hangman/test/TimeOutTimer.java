package de.agiledojo.hangman.test;

import java.util.Timer;
import java.util.TimerTask;

class TimeOutTimer {
    boolean isRunning = true;

    void start(int timeout) {
        Timer timer = new Timer("timeout");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                isRunning = false;
            }
        }, timeout);
    }

    void waitFor(Object lock, int timeout) {
        this.start(timeout);
        synchronized (lock) {
            try {
                lock.wait(timeout);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

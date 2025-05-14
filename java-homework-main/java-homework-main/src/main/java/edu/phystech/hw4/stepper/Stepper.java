package edu.phystech.hw4.stepper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kzlv4natoly
 */

public class Stepper {

    public enum Side {
        LEFT, RIGHT
    }

    private final List<Side> history = new ArrayList<>();
    private final Object lock = new Object();
    private boolean isLeftTurn = true;

    public void leftStep() throws InterruptedException {
        synchronized (lock) {
            while (!isLeftTurn || history.size() % 2 != 0) {
                lock.wait();
            }
            history.add(Side.LEFT);
            isLeftTurn = false;
            lock.notifyAll();
        }
    }

    public void rightStep() throws InterruptedException {
        synchronized (lock) {
            while (isLeftTurn || history.size() % 2 == 0) {
                lock.wait();
            }
            history.add(Side.RIGHT);
            isLeftTurn = true;
            lock.notifyAll();
        }
    }

    public List<Side> getHistory() {
        synchronized (lock) {
            return new ArrayList<>(history);
        }
    }
}
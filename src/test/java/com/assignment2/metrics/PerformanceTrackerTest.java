package com.assignment2.metrics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerformanceTrackerTest {

    private PerformanceTracker tracker;

    @BeforeEach
    void setUp() {
        tracker = new PerformanceTracker();
        tracker.reset();
    }

    @Test
    void testInitialValues() {
        assertEquals(0, tracker.getComparisons());
        assertEquals(0, tracker.getSwaps());
        assertEquals(0, tracker.getArrayAccesses());
        assertEquals(0, tracker.getExecutionTime());
    }

    @Test
    void testIncrementOperations() {
        tracker.incrementComparisons();
        tracker.incrementComparisons();
        tracker.incrementSwaps();
        tracker.incrementArrayAccesses();
        tracker.incrementArrayAccesses();
        tracker.incrementArrayAccesses();

        assertEquals(2, tracker.getComparisons());
        assertEquals(1, tracker.getSwaps());
        assertEquals(3, tracker.getArrayAccesses());
    }

    @Test
    void testExecutionTime() throws InterruptedException {
        tracker.startTimer();
        Thread.sleep(10); // имитация работы алгоритма
        tracker.stopTimer();

        assertTrue(tracker.getExecutionTime() > 0, "Execution time should be positive");
    }

    @Test
    void testReset() {
        tracker.incrementComparisons();
        tracker.incrementSwaps();
        tracker.incrementArrayAccesses();
        tracker.startTimer();
        tracker.stopTimer();

        tracker.reset();

        assertEquals(0, tracker.getComparisons());
        assertEquals(0, tracker.getSwaps());
        assertEquals(0, tracker.getArrayAccesses());
        assertEquals(0, tracker.getExecutionTime());
    }
}

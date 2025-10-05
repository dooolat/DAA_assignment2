package com.assignment2.metrics;

import java.io.FileWriter;
import java.io.IOException;

public class PerformanceTracker {
    private long comparisons;
    private long swaps;
    private long arrayAccesses;
    private long startTime;
    private long endTime;

    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        startTime = 0;
        endTime = 0;
    }

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        endTime = System.nanoTime();
    }

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementSwaps() {
        swaps++;
    }

    public void incrementArrayAccesses() {
        arrayAccesses++;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public long getArrayAccesses() {
        return arrayAccesses;
    }

    public long getExecutionTime() {
        return (endTime - startTime);
    }

    public void exportToCSV(String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.append(comparisons + "," + swaps + "," + arrayAccesses + "," + getExecutionTime() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

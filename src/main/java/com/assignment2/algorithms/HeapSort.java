package com.assignment2.algorithms;

import com.assignment2.metrics.PerformanceTracker;

public class HeapSort {

    private final PerformanceTracker tracker;

    public HeapSort(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    public void sort(int[] arr) {
        int n = arr.length;

        // Build heap (bottom-up)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    // Optimized bottom-up in-place heapify
    private void heapify(int[] arr, int n, int i) {
        int temp = arr[i];
        int child;
        while (2 * i + 1 < n) {
            child = 2 * i + 1;  // left child
            tracker.incrementComparisons();
            if (child + 1 < n) { // right child exists?
                tracker.incrementComparisons();
                if (arr[child + 1] > arr[child]) {
                    child++; // take the larger child
                }
            }
            tracker.incrementComparisons();
            if (temp >= arr[child]) break;
            arr[i] = arr[child];
            tracker.incrementSwaps();
            i = child;
        }
        arr[i] = temp;
    }

    private void swap(int[] arr, int i, int j) {
        tracker.incrementSwaps();
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

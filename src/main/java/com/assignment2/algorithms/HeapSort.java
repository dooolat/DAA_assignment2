package com.assignment2.algorithms;

import com.assignment2.metrics.PerformanceTracker;

public class HeapSort {

    private final PerformanceTracker tracker;

    public HeapSort(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    public void sort(int[] arr) {
        int n = arr.length;

        // Build heap (rearrange array from bottom-up)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;  // root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Left child
        if (left < n) {
            tracker.incrementComparisons();
            if (arr[left] > arr[largest]) {
                largest = left;
            }
        }

        // Right child
        if (right < n) {
            tracker.incrementComparisons();
            if (arr[right] > arr[largest]) {
                largest = right;
            }
        }

        // If root is not the largest, swap and continue heapify
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    private void swap(int[] arr, int i, int j) {
        tracker.incrementSwaps();
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

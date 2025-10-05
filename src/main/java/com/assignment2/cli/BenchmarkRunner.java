package com.assignment2.cli;

import com.assignment2.algorithms.HeapSort;
import com.assignment2.metrics.PerformanceTracker;

import java.util.Arrays;
import java.util.Random;

public class BenchmarkRunner {
    private static final String[] TYPES = {"Random", "Sorted", "Reversed", "NearlySorted"};

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000}; // default sizes

        if (args.length > 0) {
            sizes = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                sizes[i] = Integer.parseInt(args[i]);
            }
        }

        for (int size : sizes) {
            for (String type : TYPES) {
                runBenchmark(size, type);
            }
        }
    }

    private static void runBenchmark(int n, String type) {
        int[] array = generateArray(n, type);
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort heapSort = new HeapSort(tracker);

        long start = System.nanoTime();
        heapSort.sort(array);
        long end = System.nanoTime();

        System.out.println(
                "Size: " + n +
                        ", Type: " + type +
                        ", Time: " + (end - start) / 1_000_000 + " ms" +
                        ", Comparisons: " + tracker.getComparisons() +
                        ", Swaps: " + tracker.getSwaps()
        );
    }

    private static int[] generateArray(int n, String type) {
        Random rand = new Random();
        int[] array = new int[n];

        // Random
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(n * 10);
        }

        switch (type) {
            case "Sorted":
                Arrays.sort(array);
                break;
            case "Reversed":
                Arrays.sort(array);
                reverse(array);
                break;
            case "NearlySorted":
                Arrays.sort(array);
                // 10% random swaps
                for (int i = 0; i < n / 10; i++) {
                    int idx1 = rand.nextInt(n);
                    int idx2 = rand.nextInt(n);
                    int tmp = array[idx1];
                    array[idx1] = array[idx2];
                    array[idx2] = tmp;
                }
                break;
            default: // Random
                break;
        }

        return array;
    }

    private static void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}

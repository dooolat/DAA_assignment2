package com.assignment2.cli;

import com.assignment2.algorithms.HeapSort;
import com.assignment2.metrics.PerformanceTracker;

import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000}; // default sizes

        if (args.length > 0) {
            sizes = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                sizes[i] = Integer.parseInt(args[i]);
            }
        }

        for (int size : sizes) {
            runBenchmark(size);
        }
    }

    private static void runBenchmark(int n) {
        int[] array = generateRandomArray(n);
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort heapSort = new HeapSort(tracker);

        long start = System.nanoTime();
        heapSort.sort(array);
        long end = System.nanoTime();

        System.out.println("Size: " + n + ", Time: " + (end - start)/1_000_000 + " ms, " +
                "Comparisons: " + tracker.getComparisons() +
                ", Swaps: " + tracker.getSwaps());
    }

    private static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(n * 10);
        }
        return array;
    }
}

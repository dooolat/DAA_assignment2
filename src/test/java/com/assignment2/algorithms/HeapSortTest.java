package com.assignment2.algorithms;

import com.assignment2.metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HeapSortTest {

    @Test
    void testEmptyArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort heapSort = new HeapSort(tracker);

        int[] arr = {};
        heapSort.sort(arr);

        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort heapSort = new HeapSort(tracker);

        int[] arr = {42};
        heapSort.sort(arr);

        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    void testSortedArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort heapSort = new HeapSort(tracker);

        int[] arr = {1, 2, 3, 4, 5};
        heapSort.sort(arr);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort heapSort = new HeapSort(tracker);

        int[] arr = {5, 4, 3, 2, 1};
        heapSort.sort(arr);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testRandomArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort heapSort = new HeapSort(tracker);

        int[] arr = {12, 4, 19, 8, 7, 3};
        heapSort.sort(arr);

        assertArrayEquals(new int[]{3, 4, 7, 8, 12, 19}, arr);
    }
}

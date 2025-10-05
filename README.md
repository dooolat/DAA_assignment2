# HeapSort Benchmark

## Overview
This project implements **HeapSort** in Java with built-in performance tracking.  
It records **comparisons**, **swaps**, and **execution time** for arrays of different sizes.

## Time Complexity

- **Best case:** O(n log n) — heap construction + extraction
- **Worst case:** O(n log n) — every element may require log n swaps
- **Average case:** O(n log n)

## Benchmarking

All algorithms are benchmarked using the CLI `BenchmarkRunner`.  
The runner measures:
- Execution time (ms)
- Comparisons
- Swaps

Input sizes tested: 100, 1000, 10000, 100000.  
This approach validates theoretical complexity against empirical results.

## How to Run
Build and run with Maven:
```bash
mvn clean compile exec:java "-Dexec.args=100 1000 10000 100000"
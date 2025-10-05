import matplotlib.pyplot as plt

# Input sizes and execution times (example values)
input_sizes = [100, 500, 1000, 5000, 10000]
merge_sort_times = [0.001, 0.003, 0.007, 0.05, 0.11]
quick_sort_times = [0.0008, 0.002, 0.006, 0.04, 0.09]
deterministic_select_times = [0.002, 0.005, 0.012, 0.07, 0.15]

# Create the plot
plt.figure(figsize=(8, 5))

plt.plot(input_sizes, merge_sort_times, marker="o", linewidth=2, label="Merge Sort")
plt.plot(input_sizes, quick_sort_times, marker="s", linewidth=2, label="Quick Sort")
plt.plot(input_sizes, deterministic_select_times, marker="^", linewidth=2, label="Deterministic Select")

# Title and labels
plt.title("Execution Time vs Input Size", fontsize=14, fontweight="bold")
plt.xlabel("Input Size (n)", fontsize=12)
plt.ylabel("Execution Time (seconds)", fontsize=12)

# Grid and legend
plt.grid(True, linestyle="--", alpha=0.6)
plt.legend(fontsize=11)
plt.tight_layout()

# Show the plot
plt.show()

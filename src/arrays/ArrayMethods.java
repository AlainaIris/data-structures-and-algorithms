/**
 * Purpose	Collection of methods for arrays
 * Status	In Progress
 *
 * @author	Alaina Iris
 * @version	01.14.2025
 */

import java.util.Random;

public final class ArrayMethods {
	// Prevent Instantiation
	private ArrayMethods() {}

	/**
	 * Get index of first occurrance of an integer
	 *
	 * @param  arr Array of integers
	 * @param  number Number to find
	 * @return Location of number
	 */
	public static int findFirst(int[] arr, int number) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == number) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Get number of times an integer appears in array
	 *
	 * @param  arr Array of integers
	 * @param  number Number to find
	 * @return Number of occurrences
	 */
	public static int findOccurrences(int[] arr, int number) {
		int count = 0;
		for (int i : arr) {
			if (i == number) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Get maximum value of array
	 *
	 * @param  arr Array of integers
	 * @return Maximum value
	 */
	public static int getMax(int[] arr) {
		int max = arr[0];
		for (int i : arr) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

	/**
	 * Get minimum value of array
	 *
	 * @param  arr Array of integers
	 * @return Maximum value
	 */
	public static int getMin(int[] arr) {
		int min = arr[0];
		for (int i : arr) {
			if (i < min) {
				min = i;
			}
		}
		return min;
	}

	/**
	 * Binary search for a number in a sorted array
	 *
	 * @param  arr Array of integers
	 * @param  number Number to find
	 * @return Location of number
	 */
	public static int binarySearch(int[] arr, int number) {
		int high = arr.length - 1;
		int low = 0;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (arr[mid] == number) {
				return mid;
			} else if (arr[mid] > number) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * Bubble sort algorithm
	 *
	 * @param  arr Array to sort
	 */
	public static void bubbleSort(int[] arr) {
		int swap;
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = swap;
				}
			}
		}
	}

	/**
	 * Selection sort algorithm
	 *
	 * @param  arr Array to sort
	 */
	public static void selectionSort(int[] arr) {
		int swap;
		int min;
		for (int i = 0; i < arr.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			swap = arr[min];
			arr[min] = arr[i];
			arr[i] = swap;
		}
	}

	/**
	 * Insertion sort algorithm
	 *
	 * @param  arr Array to sort
	 */
	public static void insertionSort(int[] arr) {
		int swap;
		for (int i = 1; i < arr.length; i++) {
			int insertion = arr[i];
			int location = i - 1;
			while (location >= 0 && arr[location] > insertion) {
				arr[location + 1] = arr[location];
				location--;
			}
			arr[location + 1] = insertion;
		}
	}

	/**
	 * Merge two subarrays together by index
	 *
	 * @param  arr Array base
	 * @param  low Low index bound
	 * @param  mid Midpoint split
	 * @param  high High index bound
	 */
	private static void merge(int[] arr, int low, int mid, int high) {
		int lowLen = mid - low + 1;
		int highLen = high - mid;
		int[] partOne = new int[lowLen];
		int[] partTwo = new int[highLen];
		int i;
		for (i = 0; i < lowLen; i++) {
			partOne[i] = arr[low + i];
		}
		for (i = 0; i < highLen; i++) {
			partTwo[i] = arr[mid + 1 + i];
		}
		int partOneIndex = 0;
		int partTwoIndex = 0;
		int location = low;
		while (partOneIndex < lowLen && partTwoIndex < highLen) {
			if (partTwo[partTwoIndex] < partOne[partOneIndex]) {
				arr[location] = partTwo[partTwoIndex];
				partTwoIndex++;
			} else {
				arr[location] = partOne[partOneIndex];
				partOneIndex++;
			}
			location++;
		}
		while (partOneIndex < lowLen) {
			arr[location] = partOne[partOneIndex];
			partOneIndex++;
			location++;
		}
		while (partTwoIndex < highLen) {
			arr[location] = partTwo[partTwoIndex];
			partTwoIndex++;
			location++;
		}
	}

	/**
	 * Apply merge sort to part of array
	 *
	 * @param  arr Array to sort
	 * @param  low Low bound of portion
	 * @param  high High bound of portion
	 */
	private static void mergePart(int[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergePart(arr, low, mid);
			mergePart(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	/**
	 * Merge sort algorithm call
	 *
	 * @param  arr Array to sort
	 */
	public static void mergeSort(int[] arr) {
		mergePart(arr, 0, arr.length - 1);
	}

	/**
	 * Quick sort partition
	 *
	 * @param  arr Array to sort
	 * @param  low Low index
	 * @param  high High index
	 */
	public static int quickSortPartition(int[] arr, int low, int high) {
		int swapLocation = arr[low];
		int i = low - 1;
		int j = high + 1;
		int swap;
		while (i < j) {
			do {
				i++;
			} while (arr[i] < swapLocation);
			do {
				j--;
			} while (arr[j] > swapLocation);
			if (i >= j) {
				return j;
			}
			swap = arr[i];
			arr[i] = arr[j];
			arr[j] = swap;
		}
		return -1;
	}

	/**
	 * Apply quick sort to a part
	 *
	 * @param  arr Array to sort
	 * @param  low Low index
	 * @param  high High index
	 */
	public static void quickSortPart(int[] arr, int low, int high) {
		if (low >= 0 && high >= 0 && low < high) {
			int part = quickSortPartition(arr, low, high);
			quickSortPart(arr, low, part);
			quickSortPart(arr, part + 1, high);
		}
	}

	/**
	 * Quick sort algorithm call
	 *
	 * @param  arr Array to sort
	 */
	public static void quickSort(int[] arr) {
		quickSortPart(arr, 0, arr.length - 1);
	}

	/**
	 * Heap sort algorithm
	 *
	 * @param  arr Array to sort
	 */
	public static void heapSort(int[] arr) {
		int front = arr.length / 2;
		int end = arr.length;
		int swap;
		int root;
		int child;
		while (end > 1) {
			if (front > 0) {
				front--;
			} else {
				end--;
				swap = arr[end];
				arr[end] = arr[front];
				arr[front] = swap;
			}

			root = front;
			while (root * 2 + 1 < end) {
				child = root * 2 + 1;
				if (child + 1 < end && arr[child + 1] > arr[child]) {
					child++;
				}

				if (arr[root] < arr[child]) {
					swap = arr[root];
					arr[root] = arr[child];
					arr[child] = swap;
					root = child;
				} else {
					break;
				}
			}
		}
	}

	/**
	 * Sort by digit
	 *
	 * @param  arr Array to sort
	 * @param  exponent Exponent divisor for digit
	 * @param  base Base for digit (i.e. base-10)
	 */
	public static void radixSortDigit(int[] arr, int exponent, int base) {
		int[] result = new int[arr.length];
		int[] bucketCounts = new int[base];
		for (int i : arr) {
			bucketCounts[(i / exponent) % base]++;
		}
		for (int i = 1; i < base; i++) {
			bucketCounts[i] += bucketCounts[i - 1];
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			result[bucketCounts[(arr[i] / exponent) % base] - 1] = arr[i];
			bucketCounts[(arr[i] / exponent) % base]--;
		}
		for (int i = 0; i < result.length; i++) {
			arr[i] = result[i];
		}
	}

	/**
	 * Radix sort
	 *
	 * @param  arr Array to sort
	 * @param  base Base of digit (i.e. base-10)
	 */
	public static void radixSort(int[] arr, int base) {
		int max = getMax(arr);
		for (int i = 1; max / i > 0; i *= base) {
			radixSortDigit(arr, i, base);
		}
	}

	/**
         * Return if array is sorted (in ascending order)
         *
         * @param  array Array to check
         * @return Is array sorted
         */
        public static boolean isSorted(int[] arr) {
                for (int i = 1; i < arr.length; i++) {
                        if (arr[i] < arr[i - 1]) {
                                return false;
                        }
                }
                return true;
        }

        /**
         * Generate a random array
         *
         * @param  length Array length
         * @param  min Minimum value
         * @param  max Maximum value (exclusive)
         * @return Randomized array
         */
        public static int[] randomArray(int length, int min, int max) {
                int[] array = new int[length];
                Random rand = new Random();
                for (int i = 0; i < length; i++) {
                        array[i] = rand.nextInt(max - min) + min;
                }
                return array;
        }
	
	/**
	 * Generate a random sorted array
	 *
	 * @param  length Array length
	 * @param  min Minimum value
	 * @param  max Maximum value (exclusive)
	 * @return Randomized array
	 */
	public static int[] randomSortedArray(int length, int min, int max) {
		int[] array = new int[length];
		Random rand = new Random();
		int last = min;
		for (int i = 0; i < length; i++) {
			last = rand.nextInt((max - min) / length) + (max - min) / length * i + min;
			array[i] = last;
		}
		return array;
	}

	/**
	 * Print out array
	 *
	 * @param  arr Array to print
	 */
	public static void print(int[] arr) {
		String str = "";
		for (int i : arr) {
			str = str + i + " ";
		}
		System.out.println(str);
	}
}

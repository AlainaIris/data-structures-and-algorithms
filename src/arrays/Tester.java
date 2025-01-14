/**
 * Purpose	General testing for array methods
 * Status	In Progress
 *
 * @author	Alaina Iris
 * @version	01.14.2025
 */

public class Tester {
	public static void main(String[] args) {
		System.out.println("Bubble Sort Example: ");
		int[] arr = ArrayMethods.randomArray(10, -100, 101);
		ArrayMethods.print(arr);
		ArrayMethods.bubbleSort(arr);
		ArrayMethods.print(arr);
		System.out.println(
			ArrayMethods.isSorted(arr) ?
			"Sorted SUCCESSFULLY" :
			"Unsuccessful Sort"
		);

		System.out.println("Quick Sort Example: ");
		arr = ArrayMethods.randomArray(10, -100, 101);
		ArrayMethods.print(arr);
                ArrayMethods.quickSort(arr);
                ArrayMethods.print(arr);
                System.out.println(
                        ArrayMethods.isSorted(arr) ?
                        "Sorted SUCCESSFULLY" :
                        "Unsuccessful Sort"
                );

		System.out.println("Insertion Sort Example: ");
                arr = ArrayMethods.randomArray(10, -100, 101);
		ArrayMethods.print(arr);
		ArrayMethods.insertionSort(arr);
                ArrayMethods.print(arr);
                System.out.println(
                        ArrayMethods.isSorted(arr) ?
                        "Sorted SUCCESSFULLY" :
                        "Unsuccessful Sort"
                );

		System.out.println("Merge Sort Example: ");
                arr = ArrayMethods.randomArray(10, -100, 101);
                ArrayMethods.print(arr);
		ArrayMethods.mergeSort(arr);
                ArrayMethods.print(arr);
                System.out.println(
                        ArrayMethods.isSorted(arr) ?
                        "Sorted SUCCESSFULLY" :
                        "Unsuccessful Sort"
                );

		System.out.println("Binary Heap Sort Example: ");
                arr = ArrayMethods.randomArray(10, -100, 101);
                ArrayMethods.print(arr);
		ArrayMethods.heapSort(arr);
                ArrayMethods.print(arr);
                System.out.println(
                        ArrayMethods.isSorted(arr) ?
                        "Sorted SUCCESSFULLY" :
                        "Unsuccessful Sort"
                );
		
		System.out.println("Radix Sort Example: ");
		arr = ArrayMethods.randomArray(10, 0, 101);
                ArrayMethods.print(arr);
                ArrayMethods.radixSort(arr, 10);
                ArrayMethods.print(arr);
                System.out.println(
                        ArrayMethods.isSorted(arr) ?
                        "Sorted SUCCESSFULLY" :
                        "Unsuccessful Sort"
                );

		arr = new int[] {4, 10, -2, 14, 7, -5, -9, 1, -3};
		System.out.println("Linear Search for array: ");
		ArrayMethods.print(arr);
		System.out.println("Found -5 at index: " + ArrayMethods.findFirst(arr, -5));
                System.out.println("Found 10 at index: " + ArrayMethods.findFirst(arr, 10));

		arr = new int[] {-10, -8, -3, 1, 4, 9, 14};
		System.out.println("Binary Search for array: ");
		ArrayMethods.print(arr);
		System.out.println("Found 9 at index: " + ArrayMethods.binarySearch(arr, 9));
                System.out.println("Found -3 at index: " + ArrayMethods.binarySearch(arr, -3));
	}

}

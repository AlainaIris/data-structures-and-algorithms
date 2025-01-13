/**
 *
 */
public class Driver {
	public static void main(String[] args) {
		int[] arr = new int[] {0, 4, 2, 1, 10, 18, 3};
		ArrayMethods.bubbleSort(arr);
		ArrayMethods.print(arr);
		arr = new int[] {0, 4, 2, 1, 10, 18, 3};
                ArrayMethods.quickSort(arr);
                ArrayMethods.print(arr);
                arr = new int[] {0, 4, 2, 1, 10, 18, 3};
                ArrayMethods.insertionSort(arr);
                ArrayMethods.print(arr);
                arr = new int[] {0, 4, 2, 1, 10, 18, 3};
                ArrayMethods.mergeSort(arr);
                ArrayMethods.print(arr);
                arr = new int[] {0, 4, 2, 1, 10, 18, 3};
                ArrayMethods.heapSort(arr);
                ArrayMethods.print(arr);
                arr = new int[] {0, 4, 2, 1, 10, 18, 3};
                ArrayMethods.radixSort(arr, 10);
                ArrayMethods.print(arr);
		System.out.println("Found 4 at index: " + ArrayMethods.findFirst(arr, 4));
		System.out.println("Found 10 at index: " + ArrayMethods.findFirst(arr, 10));
	}
}

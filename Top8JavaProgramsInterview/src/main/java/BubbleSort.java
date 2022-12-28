import java.util.Arrays;
import java.util.stream.IntStream;

public class BubbleSort {
	// perform the bubble sort

	static void bubbleSort(int array[]) {

		int size = array.length;

		// loop to access each array element

		for (int i = 0; i < size; i++) {

			// loop to compare array elements

			for (int j = 0; j < size - i - 1; j++) {

				// compare two adjacent elements

				// change > to < to sort in descending order

				if (array[j] > array[j + 1]) {

					// swapping occurs if elements

					// are not in the intended order

					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	static void bubbleSort(Integer[] arr) {
		int n = arr.length;
		IntStream.range(0, n - 1).flatMap(i -> IntStream.range(0, n - 1 - i)).forEach(j -> {
			if (arr[j] > arr[j + 1]) {
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		});
	}

	public static void main(String args[]) {

		int[] data = { -2, 45, 0, 11, -9 };
		Integer[] array = { 2, 1, 4, 6, 3, 5 };
		// call method using class name
		bubbleSort(array);
		bubbleSort(data);

		System.out.println("Sorted Array in Ascending Order:");

		System.out.println(Arrays.toString(data));

		System.out.println(Arrays.toString(array));

	}
}

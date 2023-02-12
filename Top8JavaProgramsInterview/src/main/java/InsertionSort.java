
public class InsertionSort {
	private void sort(int arr[]) {
		// TODO Auto-generated method stub
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	static void printArray(int arr[]) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = { 1, 41, 5, 9, 15, 37 };
		InsertionSort ob = new InsertionSort();
		ob.sort(arr);
		printArray(arr);
	}
}

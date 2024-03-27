package quick_sort;

import java.util.Arrays;

public class QuickSortPractice {
    public static void quickSort(int[] array, int left, int right) {
		if (left < right) {
			int pivot = pivot(array, left, right);
			
			quickSort(array, left, pivot - 1);
			quickSort(array, pivot + 1, right);
		}
	}

	private static int pivot(int[] array, int pivotIndex, int endIndex) {
		int swapIndex = pivotIndex;
		
		for(int i = pivotIndex + 1; i <= endIndex; i++) {
			if (array[i] < array[pivotIndex]) {
				swapIndex++;
				swap(array, swapIndex, i);
			}
		}
		
		swap(array, swapIndex, pivotIndex);
		
		return swapIndex;
	}
	
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {7,8,6,9,4,5,1,3,2,0};
		quickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
	}
}

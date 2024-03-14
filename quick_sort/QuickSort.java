package quick_sort;

import java.util.Arrays;

public class QuickSort {

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left < right) {
            int pivot = pivot(array, left, right);

            quickSortHelper(array, left, pivot - 1);
            quickSortHelper(array, pivot + 1, right);
        }
    }

    private static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length);
    }

    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;

        for (int i = pivotIndex + 1; i < endIndex; i++) {
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
        int[] array = new int[] { 9, 3, 7, 5, 4, 6, 8, 1 };

        quickSort(array);

        System.out.println(Arrays.toString(array));

    }
}

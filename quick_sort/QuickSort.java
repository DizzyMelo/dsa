package quick_sort;

import java.util.Arrays;

public class QuickSort {

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right)
            return;

        int pivot = pivot(array, left, right);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
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
        int[] unsortedArray = new int[] { 4, 6, 1, 7, 3, 2, 5 };

        quickSort(unsortedArray, 0, unsortedArray.length);
        System.out.println(Arrays.toString(unsortedArray));
    }
}

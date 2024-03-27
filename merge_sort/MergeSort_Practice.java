package merge_sort;

import java.util.Arrays;

public class MergeSort_Practice {

    private static int[] merge(int[] array1, int[] array2) {
        int index = 0, i = 0, j = 0;
        int[] combination = new int[array1.length + array2.length];

        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                combination[index] = array1[i];
                i++;
            } else {
                combination[index] = array2[j];
                j++;
            }

            index++;
        }

        while (i < array1.length) {
            combination[index] = array1[i];
            i++;
            index++;
        }

        while (j < array2.length) {
            combination[index] = array2[j];
            j++;
            index++;
        }

        return combination;
    }

    public static int[] mergeSort(int[] array) {
        if (array.length <= 1)
            return array;
        int mid = array.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(array, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(array, mid, array.length));

        return merge(left, right);
    }

    public static void main(String[] args) {
        int[] array = new int[] { 9, 2, 7, 8, 1, 5, 6, 3, 4, 0 };
        int[] result = mergeSort(array);

        System.out.println(Arrays.toString(result));
    }
}

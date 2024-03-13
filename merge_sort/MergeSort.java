package merge_sort;

import java.util.Arrays;

public class MergeSort {
    
    public int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int index = 0, i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                result[index] = nums1[i];
                i++;
            } else {
                result[index] = nums2[j];
                j++;
            }

            index++;
        }

        while (i < nums1.length) {
            result[index] = nums1[i];
            i++;
            index++;
        }

        while (j < nums2.length) {
            result[index] = nums2[j];
            j++;
            index++;
        }


        return result;
    }

    public int[] mergeSort(int[] array) {
        if (array.length <= 1) return array;
        int midIndex = array.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(left, right);
    }
}

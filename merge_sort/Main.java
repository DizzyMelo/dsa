package merge_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] merged = mergeSort.mergeSort(new int[] { 8, 40, 20, 7, 4, 83, 2, 94, 75, 39, 29, 2, 52, 44 });

        System.out.println(Arrays.toString(merged));
    }
}

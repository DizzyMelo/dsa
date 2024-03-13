package merge_sort;

import java.util.Arrays;;

public class Main {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] result = mergeSort.mergeSort(new int[] {6,3,7,8,2,634,5,28,88});

        System.out.println(Arrays.toString(result));
    }
}

package hashtables;

import java.util.Set;
import java.util.HashSet;

public class HasElementInCommon {
    public static void main(String[] args) {
        int[] array1 = {2,3,5};
        int[] array2 = {1,4,5};

        boolean shareElement = hasElementInCommon(array1, array2);
        System.out.println(shareElement);
    }

    public static boolean hasElementInCommon(int[] array1, int[] array2) {

        Set<Integer> set1 = new HashSet<>();

        for (Integer value : array1) {
            set1.add(value);
        }


        for (Integer value : array2) {
            if (set1.contains(value))
                return true;
        }

        return false;
    }
}

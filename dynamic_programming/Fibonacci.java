package dynamic_programming;

import java.util.Arrays;

public class Fibonacci {
    public static int generateFibonacciOfN(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return generateFibonacciOfN(n - 1) + generateFibonacciOfN(n - 2); 
    }

    public static int[] generateFibonacciSequence(int n) {
        int[] sequence = new int[n + 1];
        sequence[1] = 1;

        for(int i = 2; i <= n; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }

        return sequence;
    }

    public static void main(String[] args) {
        System.out.println(generateFibonacciOfN(7));

        int[] s = generateFibonacciSequence(7);
        System.out.println(Arrays.toString(s));
    }
    
}

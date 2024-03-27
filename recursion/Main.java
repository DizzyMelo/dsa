package recursion;

public class Main {
    
    private static void count(int n) {
        if (n == 0) return;

        System.out.println(n);
        count(n - 1);
    }

    private static void countReverse(int n) {
        if (n == 0) return;

        countReverse(n - 1);
        
        System.out.println(n);
    }
    
    public static void main(String[] args) {
        count(3);
    }
}

/**
 * 
 * Stack
 * 1
 * 2
 * 3
 * 4
 * 5
 */

 /**
  * 
  */

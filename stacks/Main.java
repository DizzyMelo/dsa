package stacks;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(3);

        stack.push(2);
        stack.push(1);

        stack.printStack();
        stack.printStackDetails();

        System.out.println("popped: " + stack.pop().value);
        System.out.println("popped: " + stack.pop().value);
        System.out.println("popped: " + stack.pop().value);

        stack.printStack();
        stack.printStackDetails();
    }
}

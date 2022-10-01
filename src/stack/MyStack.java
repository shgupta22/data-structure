package stack;

import java.util.LinkedList;

public class MyStack<E> {

    LinkedList<E> stack = new LinkedList<>();

    public void push(E element) {
        stack.addFirst(element);
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return stack.removeFirst();
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return stack.getFirst();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }


    public static void main(String[] args) {
        MyStack<Integer> stack1 = new MyStack<>();
        System.out.println(stack1.isEmpty());
        stack1.push(1);
        System.out.println(stack1);
        stack1.push(2);
        System.out.println(stack1);
        System.out.println(stack1.peek());
        System.out.println(stack1);
        System.out.println(stack1.pop());
        System.out.println(stack1);
        System.out.println(stack1.isEmpty());
    }

    @Override
    public String toString() {
        return "stack.MyStack{" +
                "stack=" + stack +
                '}';
    }

    //push
    //pop
    //peek
    //isEmpty

    // LinkedList
    //
}

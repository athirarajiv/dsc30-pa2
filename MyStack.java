/*
    Name: Athira Rajiv
    PID:  A16317648
 */

import java.util.EmptyStackException;
import utilities.FullStackException;

/**
 * MyStack Implementation
 * @author Athira Rajiv
 * @since A16317648
 */
public class MyStack {

    /*
    * Constructor that initializes a stack with a given initial capacity.
    * Throws an illegalargumentexception if the capacity is out of valid
    * range.
    * */
    String[] stack;
    int capacity;
    int size;

    public MyStack(int capacity) throws IllegalArgumentException {
        capacity = this.capacity;
        size = 0;
        String[] stack = new String[capacity];
    }

    /*
     * Constructor that initializes a stack with default capacity set to 10.
     * */
    public MyStack() {
        capacity = 10;
        size = 0;
        String[] stack = new String[capacity];
    }

    /*
     * Checks if the stack is empty, and returns true if the stack is empty.
     * */
    public boolean isEmpty() {
        return size==0;
    }

    /*
     * Clears all the elements in the stack.
     * */
    public void clear() {
        size = 0;
        stack = new String[capacity];
    }

    /*
     * Returns the number of elements currently stored in the stack.
     * */
    public int size() {
        return size;
    }

    /*
     * Returns the maximum number of elements the stack can store.
     * */
    public int capacity() {
        return capacity;
    }

    /*
     * Returns the top element of the stack.
     * */
    public String peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[size - 1];
    }

    /*
     *
     * */
    public void push(String element) {
        if (element == null) {
            throw new IllegalArgumentException;
        }
        if (size == capacity) {
            throw new FullStackException("Your stack is full.");
        }
        stack[size] = element;
        size++;
    }

    /*
     * Returns and removes the top element of the stack.
     * */
    public String pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        String element = stack[size-1];
        size--;
        stack[size-1] = null;
        return element;
    }

    /*
     * Pushes all strings in the array elements to the stack.
     * */
    public void multiPush(String[] elements) {
        if (elements == null) {
            throw new IllegalArgumentException;
        }
        for (String element : elements) {
            if (size == capacity) {
                throw new FullStackException("Your stack is full.");
            }
        for(int i = 0; i < elements.length; i++) {
            stack[i] = elements[i];
        }

        size+= elements.length;
    }

    /*
     * Pops the given amount of elements from the stack.
     * If the stack does not have the given amount of elements, pop all elements from the stack.
     * Returns a String array that contains all popped elements.
     */
     */
     * */
    public String[] multiPop(int amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be a positive number");
            }
        }
        String[] newStack = new String[amount];
        for(int i = 0; i < amount; i++) {
            newStack[i] = stack[size-1-i];
            stack[size-1-i] = null;
        }
        return newStack;
    }


}
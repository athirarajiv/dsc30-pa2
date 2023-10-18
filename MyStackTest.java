import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;
import utilities.FullStackException;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    @Test
    public void testConstructorWithValidCapacity() {
        MyStack stack = new MyStack(5);
        Assertions.assertNotNull(stack);
    }

    @Test
    public void testConstructorWithInvalidCapacity() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new MyStack(0);
        });
    }

    @Test
    public void testDefaultConstructor() {
        MyStack stack = new MyStack();
        Assertions.assertNotNull(stack);
    }

    @Test
    public void testIsEmpty() {
        MyStack stack = new MyStack();
        Assertions.assertTrue(stack.isEmpty());
        stack.push("A");
        Assertions.assertFalse(stack.isEmpty());
    }

    @Test
    public void testClear() {
        MyStack stack = new MyStack();
        stack.push("A");
        stack.clear();
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    public void testSize() {
        MyStack stack = new MyStack();
        Assertions.assertEquals(0, stack.size());
        stack.push("A");
        stack.push("B");
        Assertions.assertEquals(2, stack.size());
    }

    @Test
    public void testCapacity() {
        MyStack stack = new MyStack(3);
        Assertions.assertEquals(3, stack.capacity());
    }

    @Test
    public void testPeek() {
        MyStack stack = new MyStack();
        stack.push("A");
        Assertions.assertEquals("A", stack.peek());
        stack.push("B");
        Assertions.assertEquals("B", stack.peek());
    }

    @Test
    public void testPeekEmptyStack() {
        MyStack stack = new MyStack();
        Assertions.assertThrows(EmptyStackException.class, stack::peek);
    }

    @Test
    public void testPush() {
        MyStack stack = new MyStack(2);
        stack.push("A");
        stack.push("B");
        Assertions.assertThrows(FullStackException.class, () -> stack.push("C"));
    }

    @Test
    public void testPushNullElement() {
        MyStack stack = new MyStack();
        Assertions.assertThrows(IllegalArgumentException.class, () -> stack.push(null));
    }

    @Test
    public void testPop() {
        MyStack stack = new MyStack();
        stack.push("A");
        stack.push("B");
        Assertions.assertEquals("B", stack.pop());
        Assertions.assertEquals("A", stack.pop());
        Assertions.assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    public void testMultiPush() {
        MyStack stack = new MyStack(3);
        String[] elements = {"A", "B", "C"};
        stack.multiPush(elements);
        Assertions.assertThrows(FullStackException.class, () -> stack.multiPush(new String[]{"X", "Y"}));
    }

    @Test
    public void testMultiPushWithNullElements() {
        MyStack stack = new MyStack();
        Assertions.assertThrows(IllegalArgumentException.class, () -> stack.multiPush(null));
    }

    @Test
    public void testMultiPop() {
        MyStack stack = new MyStack();
        stack.push("A");
        stack.push("B");
        String[] popped = stack.multiPop(2);
        Assertions.assertEquals("B", popped[0]);
        Assertions.assertEquals("A", popped[1]);
        Assertions.assertThrows(EmptyStackException.class, () -> stack.multiPop(1));
    }

    @Test
    public void testMultiPopWithInvalidAmount() {
        MyStack stack = new MyStack();
        stack.push("A");
        Assertions.assertThrows(IllegalArgumentException.class, () -> stack.multiPop(0));
    }
}

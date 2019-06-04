package at.campus.iit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class StringQueueTest {

    private StringQueue stringQueue;
    private StringQueue stringQueueDefault;


    /**
     * inits StringQueue with maxSize = 4
     */
    @Before
    public void setup() {

        //Setup Phase
        stringQueue = new StringQueue(3);
    }

    @Before
    public void setupDefault() {

        //Setup Phase
        stringQueueDefault = new StringQueue();
    }

    /**
     * test adding five elements to queue,
     * if queue is not full return value is true,
     * if queue is full return value is false
     */
    @Test
    public void testPeek() {
        assertNull(stringQueue.peek());
    }

    /**
     * test adding five elements to queue,
     * if queue is not full return value is true,
     * if queue is full return value is false
     */
    @Test
    public void testOffer1() {
        stringQueue.offer("first");
        stringQueue.offer("second");
        stringQueue.offer("third");
        assertFalse(stringQueue.offer("fourth"));
    }
    /**
     * test adding five elements to queue,
     * if queue is not full return value is true,
     * if queue is full return value is false
     */
    @Test
    public void testOffer2() {
        stringQueue.offer("first");
        stringQueue.offer("second");
        stringQueue.offer("third");
        stringQueue.offer("fourth");
        assertFalse(stringQueue.offer("fifth"));
    }
    /**
     * test adding one element with offer()
     * and get it with peek()
     */
    @Test
    public void testOfferAndPeek1() {
        stringQueue.offer("first");
        assertEquals("first", stringQueue.peek());
    }
    /**
     * test adding four elements, four successfully, with offer()
     * and get it with peek()
     */
    @Test
    public void testOfferAndPeek2() {
        stringQueue.offer("first");
        stringQueue.offer("second");
        stringQueue.offer("third");
        stringQueue.offer("fourth");
        assertEquals("first", stringQueue.peek());
    }

    /**
     * test adding one element with offer()
     * and remove&get it with poll()
     */
    @Test
    public void testOfferAndPoll1() {
        stringQueue.offer("first");
        assertEquals("first", stringQueue.poll());
    }

    /**
     * test adding four elements, three sucessfully,  with offer()
     * and remove/get it with poll()
     */
    @Test
    public void testOfferAndPoll2() {
        stringQueue.offer("first");
        stringQueue.offer("second");
        stringQueue.offer("third");
        assertFalse(stringQueue.offer("fourth"));

        assertEquals("first", stringQueue.poll());
        assertEquals("second", stringQueue.poll());
        assertEquals("third", stringQueue.poll());
        assertNull( stringQueue.poll());
    }

    /**
     * test adding one element with method offer()
     * and remove/get it with method remove().
     * With removing a second element, NoSuchElementException has to be thrown.
     */
    @Test (expected = NoSuchElementException.class)
    public void testOfferAndRemove1() {
        assertTrue(stringQueue.offer("first"));
        assertEquals("first", stringQueue.remove());
        stringQueue.remove();
    }
    /**
     * test adding four elements, three sucessfully, with method offer()
     * and remove/get it with method remove().
     * With removing a fourth element, NoSuchElementException has to be thrown.
     */
    @Test (expected = NoSuchElementException.class)
    public void testOfferAndRemove2() {
        stringQueue.offer("first");
        stringQueue.offer("second");
        stringQueue.offer("third");
        stringQueue.offer("fourth");

        assertEquals("first", stringQueue.remove());
        assertEquals("second", stringQueue.remove());
        assertEquals("third", stringQueue.remove());
        stringQueue.remove();
    }

    /**
     * test adding one element with method offer()
     * and get it with method element().
     */
    @Test
    public void testOfferAndElement1() {
        assertEquals(true, stringQueue.offer("first"));
        assertEquals("first", stringQueue.element());
    }

    /**
     * test adding four elements, three successfully, with method offer()
     * and get it twice with method element().
     */
    @Test
    public void testOfferAndElement2() {
        stringQueue.offer("first");
        stringQueue.offer("second");
        stringQueue.offer("third");
        stringQueue.offer("fourth");
        assertEquals("first", stringQueue.element());
        assertEquals("first", stringQueue.element());
    }

    /**
     * test getting element in empty queue with method element(),
     * NoSuchElementException has to be thrown.
     */
    @Test (expected = NoSuchElementException.class)
    public void testElement1() {
        stringQueue.element();
    }

    /**
     * test getting element in empty queue with method element(),
     * NoSuchElementException has to be thrown.
     */
    @Test
    public void testOfferAndElement() {
        stringQueue.offer("first");
        stringQueue.offer("second");
        stringQueue.offer("third");
        stringQueue.offer("fourth");
        assertEquals("first",stringQueue.element());
    }

    /**
     * test getting element in empty queue with method element(),
     * NoSuchElementException has to be thrown.
     */
    @Test
    public void testErrorMessageRemove() {
        try{
            stringQueue.remove();
        }
        catch (NoSuchElementException ex)
        {
            assertEquals("there's no element any more",ex.getMessage());
        }
    }

    /**
     * test getting element in empty queue with method element(),
     * NoSuchElementException has to be thrown.
     */
    @Test
    public void testErrorMessageElement() {
        try{
            stringQueue.element();
        }
        catch (NoSuchElementException ex)
        {
            assertEquals("there's no element any more",ex.getMessage());
        }
    }

    /**
     * test getting element in empty queue with method element(),
     * NoSuchElementException has to be thrown.
     */
    @Test(expected = NoSuchElementException.class)
    public void testOfferNull() {
        assertTrue(stringQueue.offer(null));
        stringQueue.element();
    }

}

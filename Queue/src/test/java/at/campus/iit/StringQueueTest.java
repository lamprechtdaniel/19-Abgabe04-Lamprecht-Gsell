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
     * tests method peak() without any element in queue.
     * @result is null
     */
    @Test
    public void testPeek() {
        assertNull(stringQueue.peek());
    }

    /**
     * test adding four elements to queue, three successfully,
     * return value is false.
     * @result false, too many elements added
     */
    @Test
    public void testOffer1() {
        stringQueue.offer("first");
        stringQueue.offer("second");
        stringQueue.offer("third");
        assertFalse(stringQueue.offer("fourth"));
    }
    /**
     * test adding five elements to queue, three successfully,
     * return value is false.
     * @result false, too many elements added
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
     * @result Is equals, only element what was offered.
     */
    @Test
    public void testOfferAndPeek1() {
        stringQueue.offer("first");
        assertEquals("first", stringQueue.peek());
    }
    /**
     * test adding four elements with offer(), three successfully,
     * and get it with peek()
     * @result Is equals, first element what was added to queue.
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
     * and remove/get it with poll().
     * @result Is equals, only element what was offered.
     */
    @Test
    public void testOfferAndPoll1() {
        stringQueue.offer("first");
        assertEquals("first", stringQueue.poll());
    }

    /**
     * test adding four elements with offer(), three successfully,
     * and remove/get four with poll().
     * @result null, all elements were removed before.
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
     * @result Is equal, only one element added.
     */
    @Test (expected = NoSuchElementException.class)
    public void testOfferAndRemove1() {
        stringQueue.offer("first");
        assertEquals("first", stringQueue.remove());
        stringQueue.remove();
    }

    /**
     * test adding one element with method offer()
     * and get it with method element().
     * @result Is equal, only one element added.
     */
    @Test
    public void testOfferAndElement1() {
        assertTrue( stringQueue.offer("first"));
        assertEquals("first", stringQueue.element());
    }

    /**
     * test adding four elements, three successfully, with method offer()
     * and get it twice with method element().
     * @result Is equal, first element what was added is "first".
     */
    @Test
    public void testOfferAndElement2() {
        stringQueue.offer("1");
        stringQueue.offer("3");
        stringQueue.offer("2");
        stringQueue.offer("4");
        assertEquals("1", stringQueue.element());
        assertEquals("1", stringQueue.element());
    }

    /**
     * test getting element in empty queue with method element(),
     * NoSuchElementException has to be thrown.
     * @result NoSuchElementException will be thrown.
     */
    @Test (expected = NoSuchElementException.class)
    public void testElement1() {
        stringQueue.element();
    }

    /**
     * test adding four elements and getting the first with method element().
     * @result NoSuchElementException will be thrown.
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
     * @result Is equal, same error message.
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
     * @result Is equal, same error message.
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
     * @result NoSuchElementException will be thrown.
     */
    @Test(expected = NoSuchElementException.class)
    public void testOfferNull() {
        assertTrue(stringQueue.offer(null));
        stringQueue.element();
    }

}

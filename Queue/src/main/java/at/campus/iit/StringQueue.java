package at.campus.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * The java class StringQueue, what implements the Interface Queue, should represent
 * a queue of String elements. A queue is a special data structure what works like a
 * real queue based on first-in-first-out-principal. With calling the default constructur
 * a maxSize of 5 is defined, but you can set another value per parameter of the constructor.
 * There can be added String elements, as long the amount of elements is not bigger
 * than maxSize.
 *
 * @author	Mathias Gsell
 * @author  Daniel Lamprecht
 * @version 1.0
 * @since	04.06.2019
 * @see		at.campus.iit.Queue
 * @see		java.util.ArrayList
 * @see		java.util.List
 * @see    	java.util.NoSuchElementException
 */

public class StringQueue implements Queue {

	private static final Logger logger = LogManager.getLogger(StringQueue.class);
	private List<String> elements = new ArrayList<String>();
	private int maxSize = 5;


	/**
	 * Default Constructor without parameter.
	 * @since 1.0
	 */
	public StringQueue() //Optimization: add empty Contructor to keep maxSize = 5
	{  logger.info("default constructor");
	}

	/**
	 * Constructor with the maxSize of the Queue as parameter.
	 * @param maxSize int
	 * @since 1.0
	 */
	public StringQueue(int maxSize){ //Error: maxsize --> maxSize
		this.maxSize = maxSize; //Optimization: maxSize --> this.maxSize
		logger.info("constructor with maxSize "+maxSize);
	}

	/**
	 * The method offer()returns true, when a element can be added. If the
	 * queue is full, it returns false.
	 * @param obj String is added to queue.
	 * @return boolean If size of Queue is less or same than maxSize its true, else it returns false.
	 * @since 1.0
	 */
	@Override
	public boolean offer(String obj) {
		logger.info("offer "+obj);
		if(elements.size()!= maxSize)
		{
			elements.add(obj);
			logger.info("element "+obj+" added");
		}
		else
		{
			logger.info("element "+obj+" can not be added, queue is full");
			return false;
		}
		
		return true;
	}
	/**
	 * The method poll() returns the first element of queue and deletes it, when the queue is empty
	 * it returns null.
	 * @return String element as string what is deleted.
	 * @since 1.0
	 */
	@Override
	public String poll() {
		logger.info("poll");

		String element = peek();
		logger.info("return peek "+element);
		
		if(elements.size() > 0){ //Error: elements.size() == 0 --> elements.size() > 0
			elements.remove(0);
			logger.info("element removed from queue");
		}
		
		return element;
	}

	/**
	 * 	The method remove() returns the first element of queue and deletes it,
	 * 	when the queue is empty it throws a NoSuchElementException.
	 *  @return String element what gets removed from Queue.
	 *  @exception NoSuchElementException if Queue is empty
	 * 	@since 1.0
	 */
	@Override
	public String remove() {
		String element = poll();
		//Error: element = "" --> deleted
		if(element == null)
		{
			logger.info("throw NoSuchElementException");
			throw new NoSuchElementException("there's no element any more");
		}
		return element;
	}

	/**
	 * The method peek() returns the first element of queue without removing,
	 * when the queue is empty it returns null.
	 * @return String first element in Queue.
	 * @since 1.0
	 */
	@Override
	public String peek() {
		String element;
		if(elements.size() > 0)
		{
			element = elements.get(0);
			logger.info("return peek "+element);
		}
		else
		{
			logger.info("queue is empty, return null");
			element = null;
		}
		
		return element;
	}
	/**
	 *  The method element() returns the first element of the queue without
	 *  removing it from the queue, when the queue is empty it throws a NoSuchElementException.
	 *  @return String first element in Queue.
	 * 	@exception NoSuchElementException if there is no element (element is null) in Queue.
	 *	@since 1.0
 	*/

	@Override
	public String element() {
		String element = peek();
		if(element == null)
		{
			logger.info("throw NoSuchElementException");
			throw new NoSuchElementException("there's no element any more");
		}
		
		return element;
	}

	/*
	public static void main(String[] args) {

		StringQueue queue = new StringQueue(4);
		queue.offer("first");
		queue.offer("second");
		queue.offer("third");
		System.out.println(queue.offer("fourth"));
		System.out.println(queue.offer("fifth"));
		System.out.println(queue.offer("sixth"));


		System.out.println(queue.peek());
		System.out.println(queue.maxSize);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		//System.out.println(queue.remove());
		//System.out.println(queue.element());




	} */

}
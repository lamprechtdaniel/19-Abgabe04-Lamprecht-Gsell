package at.campus.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// there's some Bugs included, try to debug the code and fix the Bugs
// there are different Bugs, wrong implementation, typos, ...
// write Test-Cases (read Queue Interface for understanding methods) and use Debugging possibilies of your IDE

public class StringQueue implements Queue {
	
	private List<String> elements = new ArrayList<String>();
	private int maxSize = 5;

	public StringQueue(int maxSize){ //Error: maxsize --> maxSize
		this.maxSize = maxSize; //Optimization: maxSize --> this.maxSize
	}

	@Override
	public boolean offer(String obj) {
		if(elements.size()!= maxSize)
			elements.add(obj);
		else
			return false;
		
		return true;
	}

	@Override
	public String poll() {
		String element = peek();
		
		if(elements.size() > 0){ //Error: elements.size() == 0 --> elements.size() > 0
			elements.remove(0);
		}
		
		return element;
	}

	@Override
	public String remove() {
		String element = poll();
		//Error: element = "" --> deleted
		if(element == null)
			throw new NoSuchElementException("there's no element any more");
		
		return element;
	}

	@Override
	public String peek() {
		String element;
		if(elements.size() > 0)
			element = elements.get(0);
		else
			element = null;
		
		return element;
	}

	@Override
	public String element() {
		String element = peek();
		if(element == null)
			throw new NoSuchElementException("there's no element any more");
		
		return element;
	}

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




	}

}
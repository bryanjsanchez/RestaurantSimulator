package queues;

import java.util.Iterator;

public class QueueIterator implements Iterator<Node> {
	
	private Node next;
	
	public QueueIterator(Node first) {
		this.next = first;
	}
	@Override
	public boolean hasNext() {
		return (next != null);
	}

	@Override
	public Node next() {
		Node current = next;
		next = current.getNext();
		return current;
	}
}

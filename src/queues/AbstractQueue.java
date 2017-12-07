package queues;

import java.util.ArrayList;
import java.util.Iterator;

import restaurant.Customer;

/** Represents a queue at Pat and Mat's restaurant. Abstract method enqueue(Customer customer) must be overridden by 
 * a subclass depending on the approach taken to attend customers.
 * @author Bryan J Sanchez
 */

public abstract class AbstractQueue implements Queue {
	protected ArrayList<Customer> customerInput;
	protected Node first;
	protected Node last;
	protected int size = 0;
	
	public AbstractQueue(ArrayList<Customer> customerInput) {
		this.customerInput = customerInput;
	}

	@Override
	public void enqueueAll(int turn) {
		Iterator<Customer> customerIterator = customerInput.iterator();
		while (customerIterator.hasNext()) {
			Customer newCustomer = customerIterator.next();
			if (newCustomer.getArrivalTime() == turn) {
				enqueue(newCustomer);
				customerIterator.remove();
			}
		}
	}
	
	protected abstract void enqueue(Customer customer);

	@Override
	public void customerLeaves(Customer customer) {
		if (size == 1) {
			first = last = null;
		} else if (first.getCustomer().equals(customer)) {
			Node nodeToRemove = first;
			first = first.getNext();
			nodeToRemove.clean();
		} else {
			for (Node node : this) {
				if (node.getNext().getCustomer().equals(customer)) {
					Node nodeToRemove = node.getNext();
					node.setNext(nodeToRemove.getNext());
					if (nodeToRemove == last) {
						last = node;
					}
					nodeToRemove.clean();
					break;
				}
			}
		}
		size--;
	}
	
	@Override
	public void customerServed() {
		Node nodeToRemove = first;
		first = first.getNext();
		nodeToRemove.clean();
		size--;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Customer getFirst() {
		return first.getCustomer();
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}
	
	@Override
	public Iterator<Node> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<Node> {
		
		private Node next;
		private Node current;
		
		public QueueIterator() {
			next = first;
		}
		@Override
		public boolean hasNext() {
			return (next != null);
		}

		@Override
		public Node next() {
			this.current = next;
			next = current.getNext();
			return current;
		}
	}
}

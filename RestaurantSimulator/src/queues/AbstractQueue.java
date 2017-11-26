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
		ArrayList<Customer> customersEnqueued = new ArrayList<>();
		for (Customer customer : customerInput) {
			if (customer.getArrivalTime() == turn) {
				enqueue(customer);
				customersEnqueued.add(customer);
			}
		}
		for (Customer customer : customersEnqueued) {
			customerInput.remove(customer);
		}
	}
	
	protected abstract void enqueue(Customer customer);

	@Override
	public void customerLeaves(Customer customer) {
		if (size == 1) {
			first = last = null;
		} else if (first.getCustomer() == customer) {
			Node nodeToRemove = first;
			first = first.getNext();
			nodeToRemove.clean();
		} else {
			for (Node node : this) {
				if (node.getNext().getCustomer() == customer) {
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
	public Node getFirst() {
		return first;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}
	
	@Override
	public Iterator<Node> iterator() {
		return new QueueIterator(first);
	}

}

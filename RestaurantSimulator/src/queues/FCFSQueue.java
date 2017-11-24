package queues;

import java.util.ArrayList;
import java.util.Iterator;

import restaurant.Customer;

/** Represents Pat's first-in-first-out approach to serve customers at the restaurant. 
 * @author Bryan J Sanchez
 * */

public class FCFSQueue implements Iterable<Node>, Queue {
	ArrayList<Customer> customerInput;
	Node first;
	Node last;
	int size = 0;

	public FCFSQueue(ArrayList<Customer> customerInput) {
		this.customerInput = customerInput;
	}

	/** Adds customers to the queue in the order that they will be served and removes customers from pending customerInput list.
	 */
	@Override
	public void enqueueAll(int turn) {
		ArrayList<Customer> customersEnqueued = new ArrayList<>();
		for (Customer customer : customerInput) {
			if (customer.getArrivalTime() == turn) {
				this.enqueue(customer);
				customersEnqueued.add(customer);
			}
		}
		for (Customer customer : customersEnqueued) {
			this.customerInput.remove(customer);
		}
	}

	private void enqueue(Customer customer) {
		customer.reset();
		if (customer.getPatienceTime() <= 0) {
			return;
		}
		Node newNode = new Node(customer);
		if (this.isEmpty()) {
			first = last = newNode;
		} else {
			last.setNext(newNode);
			this.last = newNode;
		}
		size++;
	}

	@Override
	public void customerLeaves(Customer customer) {
		if (this.size == 1) {
			this.first = this.last = null;
		} else {
			Node previous = first;
			Node current = first.getNext();
			while (current != null) {
				if (current.getCustomer() == customer) {
					previous.setNext(current.getNext());
					current.clean();
					break;
				} else {
					previous = current;
					current = current.getNext();
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
		return this.size;
	}

	@Override
	public Node getFirst() {
		return first;
	}

	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}

	@Override
	public Iterator<Node> iterator() {
		return new QueueIterator(first);
	}
}

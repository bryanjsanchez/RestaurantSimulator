package implementations;

import java.util.ArrayList;

import queues.AbstractQueue;
import queues.Node;
import restaurant.Customer;

/** Ordered list of customers representing Mat's last-come-first-serve approach to serve customers at the restaurant. 
 * @author Bryan J Sanchez
 * */

public class LCFSQueue extends AbstractQueue {
	ArrayList<Customer> customerInput;
	Node first;
	int size = 0;

	public LCFSQueue(ArrayList<Customer> customerInput) {
		super(customerInput);
	}

	@Override
	protected void enqueue(Customer customer) {
		customer.reset();
		if (customer.getPatienceTime() <= 0) {
			return;
		}
		Node newNode = new Node(customer);
		if (isEmpty()) {
			first = newNode;
		} else {
			newNode.setNext(first);
			first = newNode;
		}
		size++;
	}
}

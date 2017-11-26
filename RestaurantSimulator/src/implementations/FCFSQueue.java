package implementations;

import java.util.ArrayList;

import queues.AbstractQueue;
import queues.Node;
import restaurant.Customer;

/** Ordered list of customers representing Pat's first-in-first-out approach to serve customers at the restaurant. 
 * @author Bryan J Sanchez
 * */

public class FCFSQueue extends AbstractQueue {
	
	public FCFSQueue(ArrayList<Customer> customerInput) {
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
			first = last = newNode;
		} else {
			last.setNext(newNode);
			last = newNode;
		}
		size++;
	}
}

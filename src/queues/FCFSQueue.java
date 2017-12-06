package queues;

import java.util.ArrayList;

import restaurant.Customer;

/** Ordered list of customers representing Pat's first-in-first-out approach to serve customers at the restaurant. 
 * @author Bryan J Sanchez
 * */

public class FCFSQueue extends AbstractQueue {
	
	public FCFSQueue(ArrayList<Customer> customerInput) {
		super(customerInput);
	}

	@Override
	protected void enqueue(Customer newCustomer) {
		newCustomer.reset();
		if (newCustomer.getPatienceTime() <= 0) {
			return;
		}
		Node newNode = new Node(newCustomer);
		if (isEmpty()) {
			first = last = newNode;
		} else {
			last.setNext(newNode);
			last = newNode;
		}
		size++;
	}
}

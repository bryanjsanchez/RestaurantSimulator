package queues;

import java.util.ArrayList;

import restaurant.Customer;

/** Ordered list of customers representing Mat's last-come-first-serve approach to serve customers at the restaurant. 
 * @author Bryan J Sanchez
 * */

public class LCFSQueue extends AbstractQueue {
	
	public LCFSQueue(ArrayList<Customer> customerInput) {
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
			first = newNode;
		} else if (!first.getCustomer().isOrderTaken()) {
			newNode.setNext(first);
			first = newNode;
		} else {
			newNode.setNext(first.getNext());
			first.setNext(newNode);
		}
		size++;
	}
}

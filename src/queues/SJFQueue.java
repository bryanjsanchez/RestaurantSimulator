package queues;

import java.util.ArrayList;

import restaurant.Customer;

/** Ordered list of customers representing Pac's shortest-job-first approach to serve customers at the restaurant. 
 * @author Bryan J Sanchez
 * */

public class SJFQueue extends AbstractQueue {

	public SJFQueue(ArrayList<Customer> customerInput) {
		super(customerInput);
		// TODO Auto-generated constructor stub
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
		} else if (newCustomer.getOrderPrepTime() < first.getCustomer().getOrderPrepTime() 
				&& !first.getCustomer().isOrderTaken()) {
			newNode.setNext(first);
			first = newNode;
		} else {
			Node previous = null;
			for (Node current : this) {
				if (current.getNext() == null) {
					current.setNext(newNode);
					break;
				}
				if (current == first) {
					previous = current;
					continue;
				}
				if (newCustomer.getOrderPrepTime() < current.getCustomer().getOrderPrepTime()) {
					newNode.setNext(current);
					previous.setNext(newNode);
					break;
				}
				previous = current;
			}
		}
		size++;
	}
}

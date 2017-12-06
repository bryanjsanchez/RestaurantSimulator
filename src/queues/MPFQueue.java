package queues;

import java.util.ArrayList;

import restaurant.Customer;

/** Ordered list of customers representing Max's max-profit-first approach to serve customers at the restaurant. 
 * @author Bryan J Sanchez
 * */

public class MPFQueue extends AbstractQueue {

	public MPFQueue(ArrayList<Customer> customerInput) {
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
		} else if (newCustomer.getProfit() > first.getCustomer().getProfit() 
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
				if (newCustomer.getProfit() > current.getCustomer().getProfit()) {
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

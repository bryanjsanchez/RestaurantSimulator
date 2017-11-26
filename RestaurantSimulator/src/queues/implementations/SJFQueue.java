package queues.implementations;

import java.util.ArrayList;

import queues.AbstractQueue;
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
	protected void enqueue(Customer customer) {
		// TODO Auto-generated method stub
	}

}

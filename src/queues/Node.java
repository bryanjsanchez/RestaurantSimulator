package queues;

import restaurant.Customer;

/** Internal nodes used in Queue classes.
 * @author Bryan J Sanchez
 */

public class Node {
	Node next;
	Customer customer;
	
	/**
	 * @param customer Customer object that the node will contain.
	 */
	public Node(Customer customer) {
		this.customer = customer;
	}
	
	/**
	 * @return Customer object contained in the node.
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * @return Next node in the queue.
	 */
	public Node getNext() {
		return next;
	}
	
	/**
	 * @param next Node that will be set as the next node in the queue.
	 */
	public void setNext(Node next) {
		this.next = next;
	}
	
	/** Clears variables to aid garbage collection.
	 */
	public void clean() { 
		customer = null; 
		next = null; 
	}
}

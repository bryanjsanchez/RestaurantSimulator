package queues;

import restaurant.Customer;

/** Represents a queue of customers at Pat and Mat's restaurant. Customers are arranged in the order in which they will be served.
 * @author Bryan J Sanchez
 */

public interface Queue {
	
	/**	Adds customers that arrive at a given turn to the queue.
	 * @param turn Current simulator turn.
	 */
	public void enqueueAll(int turn);
	
	/** Removes a customer who's patience level has run out from the queue.
	 * @param customer Reference to customer who's patience level has run out.
	 */
	public void customerLeaves(Customer customer);
	
	/** Removes a customer who has just been served.
	 */
	public void customerServed();
	
	/**
	 * @return Number of customers in queue.
	 */
	public int size();
	
	/**
	 * @return Returns first node in queue.
	 */
	public Node getFirst();
	
	/**
	 * @return True if queue is empty.
	 */
	public boolean isEmpty();
}

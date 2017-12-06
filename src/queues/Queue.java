package queues;

import restaurant.Customer;

/** Represents a queue of customers at Pat and Mat's restaurant. Enqueued customers will be arranged in the order in which they will be served.
 * @author Bryan J Sanchez
 */

public interface Queue extends Iterable<Node> {
	
	/**	Adds customers that arrive at a given turn to the queue and removes them from pending customerInput list.
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
	 * @return Returns customer at the front of the queue which is to be served next.
	 */
	public Customer getFirst();
	
	/**
	 * @return True if queue is empty.
	 */
	public boolean isEmpty();
}

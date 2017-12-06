package simulators;

import java.util.ArrayList;

import queues.Node;
import queues.Queue;
import restaurant.Customer;

/** Turn-based simulation of Pat and Mat's restaurant.
 * @author Bryan J Sanchez
 */

public abstract class AbstractSimulator {
	
	private ArrayList<Customer> customerInput; // List of customers that will arrive at the restaurant.
	private int currentTurn;
	protected double profit;
	protected int disappointedCustomers;
	protected Queue queue;

	public AbstractSimulator(ArrayList<Customer> customerInput, Queue queue) {
		this.customerInput = customerInput;
		this.queue = queue;
		this.currentTurn = 0;
		this.profit = 0;
		this.disappointedCustomers = customerInput.size();
		this.run();
	}

	public void run() {
		while (!customerInput.isEmpty() || !queue.isEmpty()) {
			nextTurn();
			// 1) Decrement patience level for every customer in the queue.
			for (Node node : queue) {
				node.getCustomer().decrementPatienceTime();
				// 2) Remove customers who's patience ran out and their order hasn't been taken.
				if (node.getCustomer().getPatienceTime() <= 0 
						&& !node.getCustomer().isOrderTaken()) {
					queue.customerLeaves(node.getCustomer());
				} 
			}
			// 3) If the queue is not empty, an order should have been taken in a previous turn. 
			if (!queue.isEmpty()) {
				// 4) Decrement remaining order time for the customer in the front of the queue.
				queue.getFirst().decrementOrderPrepTime();	
				// 5) If order is complete, update result variables and serve customer.
				if (queue.getFirst().getOrderPrepTime() <= 0) {
					disappointedCustomers--;
					profit += queue.getFirst().getProfit();
					queue.customerServed();
				} 
			}
			// 6) Enqueue customers who arrive at this turn.
			queue.enqueueAll(currentTurn);
			// 7) Ensure first customer's order is taken.
			if (!queue.isEmpty()) {
				queue.getFirst().setOrderTaken(true);	
			}
		}
	}

	/** Proceeds to the next turn in the simulation.
	 */
	private void nextTurn() {
		currentTurn++;
	}
	
	/**
	 * @return Returns a summary String with the simulator's results.
	 */
	public abstract String toString();
}

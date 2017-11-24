package simulators;

import java.text.DecimalFormat;
import java.util.ArrayList;

import queues.FCFSQueue;
import queues.Node;
import restaurant.Customer;

/** Turn-based simulation of Pat's approach to serve customers based on their arrival time, (i.e., selecting the customer who arrives earliest). This approach is referred to as First-Come-First-Served (FCFS).
 * @author Bryan J Sanchez
 */

public class FCFSSimulator {

	private ArrayList<Customer> customerInput; // Customers that have not arrived at the restaurant.
	private FCFSQueue queue; //Customers queuing at the restaurant.
	private int currentTurn = 0;
	private double profit = 0;
	private int disappointedCustomers;

	public FCFSSimulator(ArrayList<Customer> customerInput) {
		this.customerInput = customerInput;
		this.queue = new FCFSQueue(this.customerInput);
		this.disappointedCustomers = customerInput.size();
		this.run();
	}

	private void run() {
		while (!customerInput.isEmpty() || !queue.isEmpty()) {
			this.nextTurn();
			for (Node node : queue) {
				node.getCustomer().decrementPatienceTime();
				if (node.getCustomer().getPatienceTime() <= 0 
						&& !node.getCustomer().isOrderTaken()) {
					queue.customerLeaves(node.getCustomer());
				} 
			}
			queue.enqueueAll(currentTurn);
			if (!queue.isEmpty()) {
				queue.getFirst().getCustomer().decrementOrderPrepTime();	
				if (queue.getFirst().getCustomer().getOrderPrepTime() <= 0) {
					this.disappointedCustomers--;
					this.profit += queue.getFirst().getCustomer().getCost();
					queue.customerServed();
					if (!queue.isEmpty()) {
						queue.getFirst().getCustomer().setOrderTaken(true);	
					}
				} 
			}
		}
	}

	/** Proceeds to the next turn in the simulation.
	 */
	private void nextTurn() {
		this.currentTurn++;
	}

	/**Returns a summary String with the simulator's results.
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#0.00");
		return "Pat’s approach profit: "+ df.format(this.profit) 
		+ "\nPat’s approach number of disappointed customers: " + this.disappointedCustomers + "\n";
	}
}

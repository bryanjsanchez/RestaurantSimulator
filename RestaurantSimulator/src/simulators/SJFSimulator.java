package simulators;

import java.text.DecimalFormat;
import java.util.ArrayList;

import queues.implementations.SJFQueue;
import restaurant.Customer;

/** Turn-based simulation of Pac's approach to serve customers based on who can be served in the shortest time. This approach is referred to as Shortest-Job-First (SJF). 
 * @author Bryan J Sanchez
 * */

public class SJFSimulator extends AbstractSimulator {
	
	public SJFSimulator(ArrayList<Customer> customerInput) {
		super(customerInput, new SJFQueue(customerInput));
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#0.00");
		return "Pac’s approach profit: "+ df.format(profit) 
		+ "\nPac’s approach number of disappointed customers: " + disappointedCustomers + "\n";
	}
}

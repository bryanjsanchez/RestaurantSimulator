package simulators;

import java.text.DecimalFormat;
import java.util.ArrayList;

import queues.implementations.MPFQueue;
import restaurant.Customer;

/** Turn-based simulation of Max's approach to serve customers based on who will bring the highest profit. This approach is referred to as Max-Profit-First (MPF). 
 * @author Bryan J Sanchez
 */

public class MPFSimulator extends AbstractSimulator {
	
	public MPFSimulator(ArrayList<Customer> customerInput) {
		super(customerInput, new MPFQueue(customerInput));
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#0.00");
		return "Max’s approach profit: "+ df.format(profit) 
		+ "\nMax’s approach number of disappointed customers: " + disappointedCustomers + "\n";
	}
}

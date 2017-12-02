package simulators;

import java.text.DecimalFormat;
import java.util.ArrayList;

import queues.LCFSQueue;
import restaurant.Customer;

/** Turn-based simulation of Mat's approach to serve customers based on who arrived last. This approach is referred to as Last-Come-First-Served (LCFS).
 * @author Bryan J Sanchez
 */

public class LCFSSimulator extends AbstractSimulator {

	public LCFSSimulator(ArrayList<Customer> customerInput) {
		super(customerInput, new LCFSQueue(customerInput));
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#0.00");
		return "Mat’s approach profit: "+ df.format(profit) 
		+ "\nMat’s approach number of disappointed customers: " + disappointedCustomers + "\n";
	}
}

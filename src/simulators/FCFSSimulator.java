package simulators;

import java.text.DecimalFormat;
import java.util.ArrayList;

import queues.FCFSQueue;
import restaurant.Customer;

/** Turn-based simulation of Pat's approach to serve customers based on their arrival time, (i.e., selecting the customer who arrives earliest). This approach is referred to as First-Come-First-Served (FCFS).
 * @author Bryan J Sanchez
 */

public class FCFSSimulator extends AbstractSimulator {

	public FCFSSimulator(ArrayList<Customer> customersList) {
		super(customersList, new FCFSQueue(customersList));
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#0.00");
		return "Pat’s approach profit: "+ df.format(profit) 
		+ "\nPat’s approach number of disappointed customers: " + disappointedCustomers + "\n";
	}
}

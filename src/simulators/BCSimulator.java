package simulators;

import java.text.DecimalFormat;
import java.util.ArrayList;

import restaurant.Customer;

/** Returns the best case (BC) results for each input (maximum profit and customers served).
 * @author Bryan J Sanchez
 */

public class BCSimulator {
	
	private double profit = 0;
	private int customersServed = 0;
	
	public BCSimulator(ArrayList<Customer> customersList) {
		for (Customer customer : customersList) {
			profit += customer.getProfit();
			customersServed = customersList.size();
		}
	}

	/**
	 * @return Returns a summary String with the simulator's results.
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#0.00");
		return "Maximum profit possible: "+ df.format(profit) 
		+ "\nMaximum number of customers served possible: " + customersServed + "\n";
	}
}

package simulators;

import java.text.DecimalFormat;

/** Returns the best case (BC) results for each input (maximum profit and customers served).
 * @author Bryan J Sanchez
 */

public class BCSimulator {
	
	private double profit = 0;
	private int customersServed = 0;
	
	public BCSimulator() {
		// TODO
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

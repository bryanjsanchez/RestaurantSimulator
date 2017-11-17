package com.bryanjsanchez.simulators;

import java.util.ArrayList;
import com.bryanjsanchez.restaurant.Customer;

/** Returns the best case (BC) results for each input (maximum profit and customers served).
 * @author Bryan J Sanchez
 */

public class BCSimulator implements Simulator {
	
	private int profit = 0;
	private int customersServed = 0;

	@Override
	public void run(ArrayList<Customer> customers) {
		// TODO Auto-generated method stub
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
	}
	
	/**Returns a summary String with the simulator's results after run() method has been invoked.
	 * @throws IllegalStateException Simulator must be run before invoking this method. 
	 */
	public String toString() {
		// TODO 
		return "";
	}

}

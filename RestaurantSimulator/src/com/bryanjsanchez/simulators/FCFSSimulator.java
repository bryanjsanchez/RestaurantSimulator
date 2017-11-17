package com.bryanjsanchez.simulators;

import java.util.ArrayList;

import com.bryanjsanchez.restaurant.Customer;

/** Turn-based simulation of Pat's approach to serve customers based on their arrival time, (i.e., selecting the customer who arrives earliest). This approach is referred to as First-Come-First-Served (FCFS).
 * @author Bryan J Sanchez
 */

public class FCFSSimulator implements Simulator {
	
	private int currentTurn = 1;
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
	
	/** Proceeds to the next turn in the simulation.
	 */
	private void nextTurn() {
		this.currentTurn++;
	}
	
	/**Returns a summary String with the simulator's results after run() method has been invoked.
	 * @throws IllegalStateException Simulator must be run before invoking this method. 
	 */
	@Override
	public String toString() throws IllegalStateException {
		// TODO Auto-generated method stub
		return "";
	}
}

package simulators;

import java.util.ArrayList;

import restaurant.Customer;

/** Turn-based simulation of Max's approach to serve customers based on who will bring the highest profit. This approach is referred to as Max-Profit-First (MPF). 
 * @author Bryan J Sanchez
 */

public class MPFSimulator  {
	
	private int currentTurn = 1;
	private double profit = 0;
	private int customersServed = 0;
	
	public MPFSimulator() {
		// TODO
	}
	
	/** Proceeds to the next turn in the simulation.
	 */
	private void nextTurn() {
		this.currentTurn++;
	}
	
	/**Returns a summary String with the simulator's results.
	 * @throws IllegalStateException Simulator must be run before invoking this method. 
	 */
	@Override
	public String toString() throws IllegalStateException {
		// TODO Auto-generated method stub
		return "";
	}
}

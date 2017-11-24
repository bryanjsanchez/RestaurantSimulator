package simulators;

import java.util.ArrayList;

import restaurant.Customer;

/** Turn-based simulation of Pac's approach to serve customers based on who can be served in the shortest time. This approach is referred to as Shortest-Job-First (SJF). */

public class SJFSimulator {
	
	private int currentTurn = 1;
	private double profit = 0;
	private int customersServed = 0;

	public SJFSimulator() {
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

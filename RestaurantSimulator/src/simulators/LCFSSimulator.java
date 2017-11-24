package simulators;

/** Turn-based simulation of Mat's approach to serve customers based on who arrived last. This approach is referred to as Last-Come-First-Served (LCFS).
 * @author Bryan J Sanchez
 */

public class LCFSSimulator {
	
	private int currentTurn = 1;
	private double profit = 0;
	private int customersServed = 0;

	public LCFSSimulator() {
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

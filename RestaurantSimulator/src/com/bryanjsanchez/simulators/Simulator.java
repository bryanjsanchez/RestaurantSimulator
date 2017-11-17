package com.bryanjsanchez.simulators;

import java.util.ArrayList;

import com.bryanjsanchez.restaurant.Customer;

public interface Simulator {
	
	/** Runs the simulator if it has been reset or has not been run yet. Results are stored internally and can be accessed by invoking the toString() method;
	 * @param customers List of customers.
	 */
	public void run(ArrayList<Customer> customers);
	
	/** Resets simulator to initial values after run() method has been invoked.
	 */
	public void reset();
}

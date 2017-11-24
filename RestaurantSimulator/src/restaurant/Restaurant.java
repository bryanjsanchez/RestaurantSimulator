package restaurant;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import simulators.FCFSSimulator;

/** Restaurant simulation to analyze various approaches to serving customers. 
 * @author Bryan J Sanchez
 */

public class Restaurant {

	public static void main(String[] args) {
		runSimulations("input.txt");
	}
	
	/** Runs all simulations and generates an *.out file with results for each *.csv input file.
	 * @param filepath File with .txt extension which contains list of input .csv files to be run through each simulation.
	 * @throws IllegalArgumentException File extension is not .txt.
	 * @throws FileNotFoundException 
	 */
	private static void runSimulations(String filepath) {
		// TODO
		ArrayList<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1, "451263", 10, 2.30, 15));
		customers.add(new Customer(2, "540909", 2, 5.00, 10));
		customers.add(new Customer(2, "909028", 5, 1.20, 7));
		customers.add(new Customer(2, "123654", 10, 11.00, 15));
		customers.add(new Customer(4, "541739", 10, 2.30, 20));
		FCFSSimulator simulator = new FCFSSimulator(customers);
		String result = simulator.toString();
		System.out.println(result);
	}
}

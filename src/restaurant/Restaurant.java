package restaurant;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import iomanager.InputReader;
import iomanager.OutputWriter;
import simulators.BCSimulator;
import simulators.FCFSSimulator;
import simulators.LCFSSimulator;
import simulators.MPFSimulator;
import simulators.SJFSimulator;

/** Restaurant simulation to analyze various approaches to serving customers. 
 * @author Bryan J Sanchez
 */

public class Restaurant {

	public static void main(String[] args) {
			InputReader reader = new InputReader();
			ArrayList<String> inputList = null;
			try {
				inputList = reader.getInputList();
				ArrayList<ArrayList<Customer>> customersLists = reader.getCustomersLists(inputList);
				for (int i = 0; i < inputList.size(); i++) {
					runSimulators(reader.getDirectory() + "/output/" + inputList.get(i), customersLists.get(i));
				}
				JOptionPane.showMessageDialog(null, "Simulators Successful!");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	/** Runs all simulations and generates an *.out file with results for each *.csv input file.
	 * @param filepath File with .txt extension which contains list of input .csv files to be run through each simulation.
	 * @throws IllegalArgumentException File extension is not .txt.
	 * @throws FileNotFoundException 
	 */
	private static void runSimulators(String filepath, ArrayList<Customer> customersList) {
		BCSimulator BCSimulator = new BCSimulator(new ArrayList<Customer>(customersList));
		String BCResult = BCSimulator.toString();

		FCFSSimulator FCFSSimulator = new FCFSSimulator(new ArrayList<Customer>(customersList));
		String FCFSResult = FCFSSimulator.toString();

		LCFSSimulator LCFSSimulator = new LCFSSimulator(new ArrayList<Customer>(customersList));
		String LCFSResult = LCFSSimulator.toString();

		MPFSimulator MPFSimulator = new MPFSimulator(new ArrayList<Customer>(customersList));
		String MPFResult = MPFSimulator.toString();

		SJFSimulator SJFSimulator = new SJFSimulator(new ArrayList<Customer>(customersList));
		String SJFResult = SJFSimulator.toString();

		String results = BCResult + FCFSResult + LCFSResult + MPFResult + SJFResult;
		OutputWriter.saveFile(filepath.replace(".csv", ".out"), results);
	}
}

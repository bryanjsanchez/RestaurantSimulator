package iomanager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import restaurant.Customer;

/** Class to manage input files. It should open an input.txt file which contains a list of CSV containing Customer data to be analyzed. 
 * @author Bryan J Sanchez
 */

public class InputReader {

	private String directory;

	public InputReader() {
		openFile();
	}

	/** Reads an input.txt file and generate a list with names of CSV input files to be analyzed by the simulators.
	 * @return Returns a list of input filenames.
	 * @throws IOException 
	 */
	public ArrayList<String> getInputList() throws IOException {

		BufferedReader reader;
		ArrayList<String> inputList = new ArrayList<>();
		String inputLine;
		reader = new BufferedReader(new FileReader(directory + "input.txt"));
		while ((inputLine = reader.readLine()) != null) {
			inputList.add(inputLine);
		}
		reader.close();
		return inputList;
	}

	/** Creates a list of the lists of Customers obtained from CSV files at directory where
	 * the input.txt input file was opened. 
	 * @param inputList List of filenames containing Customer data.
	 * @return Returns a list of all the lists of Customers to be evaluated on the simulations.
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public ArrayList<ArrayList<Customer>> getCustomersLists(ArrayList<String> inputList) throws NumberFormatException, IOException {

		ArrayList<Customer> customersList = null;
		ArrayList<ArrayList<Customer>> customersLists = new ArrayList<>();

		for (String inputFilename : inputList) {
			customersList = parseCustomers(directory + inputFilename);
			customersLists.add(customersList);
		}
		return customersLists;
	}

	/** Sets the working directory to the location where the program was run.
	 * @return file path of the input.txt file with the list of input files to be analyzed by the simulators.
	 */
	private String openFile() {
		this.directory = System.getProperty("user.dir") + "/";
		String inputfilePath = directory + "input.txt"; 
		return inputfilePath;
	}

	/** Creates an ArrayList of Customers with data obtained from a CSV file.
	 * @param filePath File path of *.csv with Customer data to parse.
	 * @return Returns a list of Customers.
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private ArrayList<Customer> parseCustomers(String filePath) throws NumberFormatException, IOException {

		ArrayList<Customer> queue = new ArrayList<>();
		int arrivalTime;
		String id;
		int orderPrepTime;
		double profit;
		int patienceTime;

		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String inputLine;
		while ((inputLine = reader.readLine()) != null) {
			String [] customerData = inputLine.split(",");
			arrivalTime = Integer.parseInt(customerData[0]);
			id = customerData[1];
			orderPrepTime = Integer.parseInt(customerData[2]);
			profit = Double.parseDouble(customerData[3].substring(1));
			patienceTime = Integer.parseInt(customerData[4]);
			if (patienceTime > 0) {
				queue.add(new Customer(arrivalTime, id, orderPrepTime, profit, patienceTime));  
			}
		}
		reader.close();
		return queue;
	}

	/**
	 * @return Returns directory where files are located.
	 */
	public String getDirectory() throws IllegalStateException {
		if (directory == null) {
			throw new IllegalStateException();
		}
		return directory;
	}
}

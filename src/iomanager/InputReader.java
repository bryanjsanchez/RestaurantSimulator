package iomanager;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import restaurant.Customer;

/** Class to manage input files. It should open an input.txt file which contains a list of *.csv containing
 * Customer data to be analyzed. 
 * @author Bryan J Sanchez
 */

public class InputReader {

	private String directory;

	public InputReader() {
		openFile();
	}

	/** Generate a list with names of input files to be analyzed by the simulators.
	 * @return Returns a list of input filenames.
	 */
	public ArrayList<String> getInputList() {

		BufferedReader reader;
		ArrayList<String> inputList = new ArrayList<>();
		String inputLine;

		try {
			reader = new BufferedReader(new FileReader(directory + "input.txt"));
			while ((inputLine = reader.readLine()) != null) {
				inputList.add(inputLine);
			}
			reader.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputList;
	}

	/** Creates a list of the lists of Customers obtained from *.csv files at directory where
	 * the input.txt input file was opened. 
	 * @param inputList List of filenames containing Customer data.
	 * @return Returns a list of all the lists of Customers to be evaluated on the simulations.
	 */
	public ArrayList<ArrayList<Customer>> getCustomersLists(ArrayList<String> inputList) {

		ArrayList<Customer> customersList = null;
		ArrayList<ArrayList<Customer>> customersLists = new ArrayList<>();

		for (String inputFilename : inputList) {
			try {
				customersList = parseCustomers(directory + inputFilename);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			customersLists.add(customersList);
		}
		return customersLists;
	}

	/** Opens a dialog window where the user can choose the file with input filenames and sets directory 
	 * where all the files are located. 
	 * @return filepath of the input.txt file with the list of input files to be analyzed by the simulators.
	 */
	private String openFile() {

		String inputFilepath = null; 
		FileDialog dialog = new FileDialog((Frame) null, "Select input file:");

		dialog.setMode(FileDialog.LOAD);
		dialog.setVisible(true);
		inputFilepath = dialog.getDirectory() + dialog.getFile();
		int endIndex = inputFilepath.lastIndexOf("/") + 1;
		if (endIndex != -1) {
			directory = inputFilepath.substring(0, endIndex);
		}
		return inputFilepath;
	}

	/** Creates a list of Customers with data obtained from a *.csv file.
	 * 
	 * @param filepath Filepath of *.csv with Customer data to parse.
	 * @return Returns a list of Customers.
	 * @throws FileNotFoundException
	 */
	private ArrayList<Customer> parseCustomers(String filepath) throws FileNotFoundException {
		
		ArrayList<Customer> queue = new ArrayList<>();
		int arrivalTime;
		String id;
		int orderPrepTime;
		double profit;
		int patienceTime;

		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		String inputLine;
		try {
			while ((inputLine = reader.readLine()) != null) {
				String [] customerData = inputLine.split(", ");
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
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

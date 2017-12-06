package iomanager;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/** Class to write output files.
 * @author Bryan J Sanchez
 */

public class OutputWriter {
	
	/** Static method which writes a results string to an output *.out file with the same name
	 * as the input *.csv file.
	 * @param filepath Path of the file where data is to be written.
	 * @param results String containing results from the simulators.
	 */
	public static void saveFile(String filepath, String results) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.println(results);
		writer.close();
	}
}

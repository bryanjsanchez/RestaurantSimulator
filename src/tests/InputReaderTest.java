package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import iomanager.InputReader;
import restaurant.Customer;

class InputReaderTest {

	@Test
	void testGetCustomersLists() {
		
		String filename = "input6.csv";
		
		InputReader reader = new InputReader();
		ArrayList<String> inputFilenames = new ArrayList<>();
		ArrayList<Customer> actualCustomers = null;
		
		inputFilenames.add(filename);
		try {
			actualCustomers = reader.getCustomersLists(inputFilenames).get(0);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Customer> expectedCustomers = new ArrayList<>();
		expectedCustomers.add(new Customer(1, "451263", 10, 2.30, 15));
		expectedCustomers.add(new Customer(2, "540909", 2, 5.00, 10));
		expectedCustomers.add(new Customer(2, "909028", 5, 1.20, 7));
		expectedCustomers.add(new Customer(2, "123654", 10, 11.00, 15));
		expectedCustomers.add(new Customer(4, "541739", 10, 2.30, 20));
		
		assertEquals(expectedCustomers.get(0).getArrivalTime(), actualCustomers.get(0).getArrivalTime());
		assertEquals(expectedCustomers.get(1).getArrivalTime(), actualCustomers.get(1).getArrivalTime());
		assertEquals(expectedCustomers.get(2).getArrivalTime(), actualCustomers.get(2).getArrivalTime());
		assertEquals(expectedCustomers.get(3).getArrivalTime(), actualCustomers.get(3).getArrivalTime());
		assertEquals(expectedCustomers.get(4).getArrivalTime(), actualCustomers.get(4).getArrivalTime());
		
		assertEquals(expectedCustomers.get(0).getId(), actualCustomers.get(0).getId());
		assertEquals(expectedCustomers.get(1).getId(), actualCustomers.get(1).getId());
		assertEquals(expectedCustomers.get(2).getId(), actualCustomers.get(2).getId());
		assertEquals(expectedCustomers.get(3).getId(), actualCustomers.get(3).getId());
		assertEquals(expectedCustomers.get(4).getId(), actualCustomers.get(4).getId());
		
		assertEquals(expectedCustomers.get(0).getOrderPrepTime(), actualCustomers.get(0).getOrderPrepTime());
		assertEquals(expectedCustomers.get(1).getOrderPrepTime(), actualCustomers.get(1).getOrderPrepTime());
		assertEquals(expectedCustomers.get(2).getOrderPrepTime(), actualCustomers.get(2).getOrderPrepTime());
		assertEquals(expectedCustomers.get(3).getOrderPrepTime(), actualCustomers.get(3).getOrderPrepTime());
		assertEquals(expectedCustomers.get(4).getOrderPrepTime(), actualCustomers.get(4).getOrderPrepTime());
		
		assertEquals(expectedCustomers.get(0).getArrivalTime(), actualCustomers.get(0).getArrivalTime());
		assertEquals(expectedCustomers.get(1).getArrivalTime(), actualCustomers.get(1).getArrivalTime());
		assertEquals(expectedCustomers.get(2).getArrivalTime(), actualCustomers.get(2).getArrivalTime());
		assertEquals(expectedCustomers.get(3).getArrivalTime(), actualCustomers.get(3).getArrivalTime());
		assertEquals(expectedCustomers.get(4).getArrivalTime(), actualCustomers.get(4).getArrivalTime());
		
		assertEquals(expectedCustomers.get(0).getId(), actualCustomers.get(0).getId());
		assertEquals(expectedCustomers.get(1).getId(), actualCustomers.get(1).getId());
		assertEquals(expectedCustomers.get(2).getId(), actualCustomers.get(2).getId());
		assertEquals(expectedCustomers.get(3).getId(), actualCustomers.get(3).getId());
		assertEquals(expectedCustomers.get(4).getId(), actualCustomers.get(4).getId());
		
		assertEquals(expectedCustomers.get(0).getProfit(), actualCustomers.get(0).getProfit());
		assertEquals(expectedCustomers.get(1).getProfit(), actualCustomers.get(1).getProfit());
		assertEquals(expectedCustomers.get(2).getProfit(), actualCustomers.get(2).getProfit());
		assertEquals(expectedCustomers.get(3).getProfit(), actualCustomers.get(3).getProfit());
		assertEquals(expectedCustomers.get(4).getProfit(), actualCustomers.get(4).getProfit());
		
		assertEquals(expectedCustomers.get(0).getPatienceTime(), actualCustomers.get(0).getPatienceTime());
		assertEquals(expectedCustomers.get(1).getPatienceTime(), actualCustomers.get(1).getPatienceTime());
		assertEquals(expectedCustomers.get(2).getPatienceTime(), actualCustomers.get(2).getPatienceTime());
		assertEquals(expectedCustomers.get(3).getPatienceTime(), actualCustomers.get(3).getPatienceTime());
		assertEquals(expectedCustomers.get(4).getPatienceTime(), actualCustomers.get(4).getPatienceTime());		
	}
}

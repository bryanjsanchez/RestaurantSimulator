package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import restaurant.Customer;
import simulators.SJFSimulator;

class SJFSimulatorTest {

	@Test
	void testEmpty() {
		ArrayList<Customer> customers = new ArrayList<>();
		SJFSimulator simulator = new SJFSimulator(customers);
		String expected = "Pac’s approach profit: 0.00\nPac’s approach number of disappointed customers: 0\n";
		String actual = simulator.toString();
		System.out.println(actual);
		assertEquals(expected, actual);
	}	
	
	@Test
	void test1() {
		ArrayList<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1, "451263", 10, 2.30, 15));
		SJFSimulator simulator = new SJFSimulator(customers);
		String expected = "Pac’s approach profit: 2.30\nPac’s approach number of disappointed customers: 0\n";
		String actual = simulator.toString();
		System.out.println(actual);
		assertEquals(expected, actual);
	}	
	
	@Test
	void test2() {
		ArrayList<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1, "451263", 10, 2.30, 15));
		customers.add(new Customer(2, "540909", 2, 5.00, 10));
		customers.add(new Customer(2, "909028", 5, 1.20, 7));
		customers.add(new Customer(2, "123654", 10, 11.00, 15));
		customers.add(new Customer(4, "541739", 10, 2.30, 20));
		SJFSimulator simulator = new SJFSimulator(customers);
		String expected = "Pac’s approach profit: 20.60\nPac’s approach number of disappointed customers: 1\n";
		String actual = simulator.toString();
		System.out.println(actual);
		assertEquals(expected, actual);
	}
	
	@Test
	void test3() {
		ArrayList<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1, "451263", 10, 2.30, 15));
		customers.add(new Customer(2, "540909", 2, 5.00, 10));
		customers.add(new Customer(2, "909028", 5, 1.20, 7));
		customers.add(new Customer(2, "123654", 10, 11.00, 1));
		customers.add(new Customer(4, "541739", 10, 2.30, 20));
		SJFSimulator simulator = new SJFSimulator(customers);
		String expected = "Pac’s approach profit: 9.60\nPac’s approach number of disappointed customers: 2\n";
		String actual = simulator.toString();
		System.out.println(actual);
		assertEquals(expected, actual);
	}
	
	@Test
	void testNoPatience() {
		ArrayList<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1, "451263", 10, 2.30, -15));
		customers.add(new Customer(2, "540909", 2, 5.00, 0));
		customers.add(new Customer(2, "909028", 5, 1.20, 7));
		customers.add(new Customer(2, "123654", 10, 11.00, 15));
		customers.add(new Customer(4, "541739", 10, 2.30, 20));
		SJFSimulator simulator = new SJFSimulator(customers);
		String expected = "Pac’s approach profit: 14.50\nPac’s approach number of disappointed customers: 2\n";
		String actual = simulator.toString();
		System.out.println(actual);
		assertEquals(expected, actual);
	}	
}

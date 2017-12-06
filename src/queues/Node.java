package queues;

import restaurant.Customer;

public class Node {
	Node next;
	Customer customer;
	
	public Node(Customer customer, Node next) {
		this.customer = customer;
		this.next = next;
	}
	
	public Node(Customer customer) {
		this(customer, null);
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public void clean() { 
		customer = null; 
		next = null; 
	}
}

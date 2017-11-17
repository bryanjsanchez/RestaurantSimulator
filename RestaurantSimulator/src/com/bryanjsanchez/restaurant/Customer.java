package com.bryanjsanchez.restaurant;

/** Represents a customer at Pat and Mat's restaurant.
 * @author Bryan J Sanchez
 */

public class Customer {

	private int arrivalTime; // Turn in which customer arrived.
	private int id;
	private int orderPrepTime; // Number of turns required to prepare order.
	private float profit;
	private int patienceTime; // Number of turns the customer is willing to wait for order.

	public Customer(int arrivalTime, int id, int orderPrepTime, float profit, int patienceTime) {
		this.arrivalTime = arrivalTime;
		this.id = id;
		this.orderPrepTime = orderPrepTime;
		this.profit = profit;
		this.patienceTime = patienceTime; 
	}
	
	/** @return Returns turn in which customer arrived. */
	public int getArrivalTime() {
		return arrivalTime;
	}

	/** @return Returns customer ID. */
	public int getId() {
		return id;
	}

	/** @return Returns the number of turns required to prepare customer's order. */
	public int getOrderPrepTime() {
		return orderPrepTime;
	}

	/** @return Returns profit that could be obtained from this customer. */
	public float getCost() {
		return profit;
	}

	/** @return Returns the number of turns this customer is willing to wait for his order. */
	public int getPatienceTime() {
		return patienceTime;
	}
}

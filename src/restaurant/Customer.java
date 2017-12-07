package restaurant;

/** Represents a customer at Pat and Mat's restaurant.
 * @author Bryan J Sanchez
 */

public class Customer {

	private int arrivalTime; // Turn in which customer arrived.
	private String id;
	private final int ORDERPREPTIME; // Number of turns required to prepare order.
	private int orderPrepTime; // Variable which gets decremented in the simulator.
	private final double PROFIT;
	private final int PATIENCETIME; // Number of turns the customer is willing to wait for order.
	private int patienceTime; // Variable which gets decremented in the simulator.
	private boolean isOrderTaken = false; // true if order is in process, false if it is pending.

	public Customer(int arrivalTime, String id, int orderPrepTime, double profit, int patienceTime) {
		this.arrivalTime = arrivalTime;
		this.id = id;
		this.ORDERPREPTIME = orderPrepTime;
		this.PROFIT = profit;
		this.PATIENCETIME = patienceTime; 
	}
	 
	/** @return Returns turn in which customer arrived. */
	public int getArrivalTime() {
		return arrivalTime;
	}

	/** @return Returns customer ID. */
	public String getId() {
		return id;
	}

	/** @return Returns the number of turns required to prepare customer's order. */
	public int getOrderPrepTime() {
		return orderPrepTime;
	}
	
	public void decrementOrderPrepTime() {
		orderPrepTime--;
	}

	/** @return Returns profit that could be obtained from this customer. */
	public double getProfit() {
		return PROFIT;
	}

	/** @return Returns the number of turns this customer is willing to wait for his order. */
	public int getPatienceTime() {
		return patienceTime;
	}
	
	public void decrementPatienceTime() {
		patienceTime--;
	}
	
	/** @return Returns order status: true if order is taken, false if order is pending. */
	public boolean isOrderTaken() {
		return isOrderTaken;
	}

	/** @param isOrderTaken True if order is taken, false if order is pending. */
	public void setOrderTaken(boolean isOrderTaken) {
		this.isOrderTaken = isOrderTaken;
	}
	
	/** Resets customer variables before adding to a new queue. */
	public void reset() {
		isOrderTaken = false;
		orderPrepTime = ORDERPREPTIME;
		patienceTime = PATIENCETIME;
	}
	
	public boolean equals(Customer customer) {
		return (this.getId() == customer.getId());
	}
}

public class Cargo extends Entity
{
	//ID of the cargo counts as the tracking number at the same time

	/**
	 * Customer who ordered the cargo
	 */
	private Customer customer;

	/**
	 * Status of the cargo
	 */
	private String status;


	/**
	 * Default constructor of the class
	 */
	public Cargo()
	{
		super();
		customer = new Customer();
		status = "";
	}

	/**
	 * Constructor that only takes ID
	 * @param newId ID of the user
	 */
	public Cargo(int newId)
	{
		super(newId);
		customer = new Customer();
		status = "";
	}

	/**
	 * Constructor with ID and customer
	 * @param newId ID of the cargo
	 * @param newCustomer Customer who ordered the cargo
	 */
	public Cargo(int newId, Customer newCustomer)
	{
		super(newId);

		customer = newCustomer;
		status = "";
	}

	/**
	 * Setter function of the customer
	 * @param newCustomer New owner of the cargo
	 */
	public void setCustomer(Customer newCustomer)
	{
		customer = newCustomer;
	}

	/**
	 * Getter function of the customer
	 * @return returns the customer
	 */
	public Customer getCustomer()
	{
		return customer;
	}

	/**
	 * Setter function of the status
	 * @param newStatus ne status of the cargo
	 */
	public void setStatus(String newStatus)
	{
		status = newStatus;
	}

	/**
	 * Getter function for the status
	 * @return Status of the cargo
	 */
	public String getStatus()
	{
		return status;
	}

}

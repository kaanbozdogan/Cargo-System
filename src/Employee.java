public abstract class Employee extends User
{
	/**
	 * Default constructor
	 */
	public Employee()
	{
		super();
	}

	/**
	 * Constructor with employee's ID
	 * @param newId ID of the employee
	 */
	public Employee(int newId)
	{
		super(newId);
	}

	/**
	 * Constructor that fully constructs the object
	 * @param newId ID of the constructed object
	 * @param newPassword password of the constructed object
	 */
	public Employee(int newId, String newPassword)
	{
		super(newId,newPassword);
	}

	/**
	 * Updates the status of the cargo
	 * @param cargo the updated cargo
	 * @param newStatus new status
	 */
	protected void updateCargoStatus(Cargo cargo, String newStatus)
	{
		cargo.setStatus(newStatus);
	}

}
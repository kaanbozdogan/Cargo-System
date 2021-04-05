import java.util.Scanner;

public class TransportEmployee extends Employee
{
	/**
	 * The cargo that employee transports
	 */
	private Cargo cargo;

	/**
	 * Default constructor
	 */
	public TransportEmployee()
	{
		super();
		cargo = new Cargo(0);
	}

	/**
	 * Constructor with employee's ID
	 * @param newId ID of the employee
	 */
	public TransportEmployee(int newId)
	{
		super(newId);
		cargo = new Cargo();
	}

	/**
	 * Contructor that fully constructs the object
	 * @param newId ID of the constructed object
	 * @param newPassword password of the constructed object
	 */
	public TransportEmployee(int newId, String newPassword)
	{
		super(newId,newPassword);
		cargo = new Cargo();
	}

	/**
	 * getter method of the cargo
	 * @return cargo that employee carries
	 */
	public Cargo getCargo(){
		return cargo;
	}

	/**
	 * Returns the availability of the employee
	 * @return true if employee can take a new cargo
	 */
	public boolean isAvaliable()
	{
		return cargo.getId() == 0;
	}

	/**
	 * The cargo that the employee will transfer to the customer
	 * @param newCargo cargo taken
	 */
	void takeCargo(Cargo newCargo)
	{
		if(isAvaliable()) {
			cargo = newCargo;
			updateCargoStatus(cargo, "shipping to the customer");

			System.out.println("Done!");
		}
		else
			System.out.println("Employee is already carying a cargo");
	}

	/**
	 * Gives the cargo that he/she caries to the customer that ordered it
	 */
	void deliverCargo()
	{
		if(cargo.getId() == 0)
			System.out.println("Employee does not have any cargo");

		else
		{
			Customer customer = cargo.getCustomer();

			customer.receiveCargo(cargo);
			updateCargoStatus(cargo, "delivered");
			cargo = new Cargo();

			System.out.println("Done!");
		}
	}

	@Override
	public String userSelection()
	{
		Scanner scanner = new Scanner(System.in);
		String selection;
		boolean flag;

		do{
			System.out.println("\nTransportation Employee Selections:");
			System.out.println("1- Take Cargo");
			System.out.println("2- Deliver Cargo");
			System.out.println("0- Exit");

			selection = scanner.nextLine();

			if( !( selection.equals("1") || selection.equals("2") || selection.equals("0") ) )
			{
				System.out.println("Invalid selection! Try again.\n");
				flag = true;
			} else
				flag = false;

		}while( flag );

		return selection;
	}
}

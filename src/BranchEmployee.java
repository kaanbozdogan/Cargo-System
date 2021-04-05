import java.util.ArrayList;
import java.util.Scanner;

public class BranchEmployee extends Employee
{
	/**
	 * default constructor
	 */
	public BranchEmployee()
	{
		super();
	}

	/**
	 * Constructor with employee's ID
	 * @param newId ID of the employee
	 */
	public BranchEmployee(int newId)
	{
		super(newId);
	}

	/**
	 * Contructor that fully constructs the object
	 * @param newId ID of the constructed object
	 * @param newPassword password of the constructed object
	 */
	public BranchEmployee(int newId, String newPassword)
	{
		super(newId,newPassword);
	}

	/**
	 * Adds a new cargo to the System
	 * @param cargoes the collection of cargoes
	 * @param cargoId new cargo's ID
	 * @param customer customer that ordered the cargo
	 */
	public void addCargo(ArrayList<Cargo> cargoes, int cargoId, Customer customer)
	{
		addItem(cargoes,new Cargo(cargoId,customer));
		updateCargoStatus( cargoes.get( cargoes.size()-1 ) ,"At the Branch");
	}

	/**
	 * Removes the cargo with given ID from the System
	 * @param cargoes the collection of cargoes that will be updated
	 * @param cargoId ID of the cargo that will be removed
	 */
	public void removeCargo(ArrayList<Cargo> cargoes, int cargoId)
	{
		removeItem(cargoes,cargoId);
	}

	/**
	 * Adds a new customer to the System
	 * @param customers the collection of customers
	 * @param cusId new customer's ID
	 */
	public void addCustomer(ArrayList<Customer> customers, int cusId)
	{
		addItem(customers,new Customer(cusId));
	}

	/**
	 * Removes the customer with given ID from the System
	 * @param customers the collection of customers that will be updated
	 * @param cusId ID of the customer that will be removed
	 */
	public void removeCustomer(ArrayList<Customer> customers, int cusId)
	{
		removeItem(customers,cusId);
	}

	@Override
	public String userSelection()
	{
		Scanner scanner = new Scanner(System.in);
		String selection;
		boolean flag;

		do{
			System.out.println("\nBranch Employee Selections:");
			System.out.println("1- Add Customer");
			System.out.println("2- Remove Customer");
			System.out.println("3- Add Cargo");
			System.out.println("4- Remove Cargo");
			System.out.println("0- Exit");

			selection = scanner.nextLine();

			if( !( selection.equals("1") || selection.equals("2") || selection.equals("3")
					|| selection.equals("4") || selection.equals("0") ) )
			{
				System.out.println("Invalid selection! Try again.\n");
				flag = true;
			} else
				flag = false;

		}while( flag );

		return selection;
	}
}

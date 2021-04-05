import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Entity implements UserInterface
{
	/**
	 * Deliveries that customer has taken ever since he/she is added to the System
	 */
	private ArrayList<Cargo> cargoes;

	/**
	 * Default constructor
	 */
	public Customer()
	{
		super();
		cargoes = new ArrayList<>();
	}

	/**
	 * Constructor with customer's ID
	 * @param newId ID of the customer
	 */
	public Customer(int newId)
	{
		super(newId);
		cargoes = new ArrayList<>();
	}

	/**
	 * getter function for the cargoes of the customer
	 * @return the collection of cargoes delivered to the customer
	 */
	public ArrayList<Cargo> getCargoes(){
		return cargoes;
	}

	/**
	 * Takes the cargo from the transportation employee
	 * @param newCargo the cargo taken
	 */
	public void receiveCargo(Cargo newCargo)
	{
		cargoes.add(newCargo);
	}

	@Override
	public String userSelection()
	{
		Scanner scanner = new Scanner(System.in);
		String selection;
		boolean flag;

		do{
			System.out.println("\nCustomer Selections:");
			System.out.println("1- See cargo Status");
			System.out.println("0- Exit");

			selection = scanner.nextLine();

			if( !( selection.equals("1") || selection.equals("0") ) )
			{
				System.out.println("Invalid selection! Try again.\n");
				flag = true;
			} else
				flag = false;

		}while( flag );

		return selection;
	}
}

import java.util.ArrayList;
import java.util.Scanner;

public class Administrator extends User
{
	/**
	 * Default constructor for the class
	 */
	public Administrator()
	{
		super();
	}

	/**
	 * Constructor with password
	 * @param newPassword password of Admin
	 */
	public Administrator(String newPassword)
	{
		super(newPassword);
	}

	/**
	 * Changes Admin's password
	 */
	public void changePassword()
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the password for the Admin");
		password = scanner.nextLine();
	}

	/**
	 * Adds a new branch to the System
	 * @param branches The data structure that will be updated with adding the new branch to it
	 * @param branchId ID of the branch that will be added to the System
	 */
	public void addBranch(ArrayList<Branch> branches, int branchId)
	{
		addItem(branches,new Branch(branchId));
	}

	/**
	 * Removes the branch with the given ID from the system
	 * @param branches The data structure that will be updated with adding the new branch to it
	 * @param branchId ID of the branch that will be removed from the System
	 */
	public void removeBranch(ArrayList<Branch> branches, int branchId)
	{
		removeItem(branches,branchId);
	}

	/**
	 * Adds a new Branch Employee to the System
	 * @param employees The data structure that will be updated with adding the new branch employee to it
	 * @param empId ID of the branch employee that will be added to the System
	 * @param newPassword password of the Branch Employee
	 */
	public void addBranchEmployee(ArrayList<BranchEmployee> employees, int empId, String newPassword)
	{
		addItem(employees,new BranchEmployee(empId,newPassword));
	}

	/**
	 * Removes the Branch Employee with the given ID from the System
	 * @param employees The data structure that will be updated with adding the new branch employee to it
	 * @param empId ID of the branch employee that will be removed from the System
	 */
	public void removeBranchEmployee(ArrayList<BranchEmployee> employees, int empId)
	{
		removeItem(employees,empId);
	}

	/**
	 * Adds a new transportation employee with the given ID to the System
	 * @param employees The data structure that will be updated with adding the new transportation employee to it
	 * @param empId ID of the transportation employee that will be added to the System
	 * @param newPassword password of the Transportation Employee
	 */
	public void addTransportEmployee(ArrayList<TransportEmployee> employees, int empId, String newPassword)
	{
		addItem(employees,new TransportEmployee(empId,newPassword));
	}

	/**
	 * Removes the transportation employee with the given ID from the System
	 * @param employees The data structure that will be updated with adding the new transportation employee to it
	 * @param empId ID of the transportation employee that will be removed from the System
	 */
	public void removeTransportEmployee(ArrayList<TransportEmployee> employees, int empId)
	{
		removeItem(employees,empId);
	}

	@Override
	public String userSelection()
	{
		Scanner scanner = new Scanner(System.in);
		String selection;
		boolean flag;

		do{
			System.out.println("\nAdmin Selections:");
			System.out.println("1- Add Branch");
			System.out.println("2- Remove Branch");
			System.out.println("3- Add Branch Employee");
			System.out.println("4- Remove Branch Employee");
			System.out.println("5- Add Transportation Employee");
			System.out.println("6- Remove Transportation Employee");
			System.out.println("0- Exit");

			selection = scanner.nextLine();

			if( !( selection.equals("1") || selection.equals("2") || selection.equals("3") || selection.equals("4")
					|| selection.equals("5") || selection.equals("6") || selection.equals("0") ) )
			{
				System.out.println("Invalid selection! Try again.\n");
				flag = true;
			} else
				flag = false;

		}while( flag );

		return selection;
	}
}
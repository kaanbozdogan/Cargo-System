import java.util.ArrayList;
import java.util.Scanner;

/**
 * System that holds every data structure together and processes them
 * @author Kaan Can Bozdogan
 */

public class CargoSystem implements UserInterface
{
//fields
	/**
	 * Administrator of the system
	 */
	private Administrator admin; //Can only be one admin

	/**
	 * Branches in the system
	 */
	private ArrayList<Branch> branches;

	/**
	 * Transportation employees in the system
	 */
	private ArrayList<TransportEmployee> transportEmps;

	/**
	 * Customers of the cargo company
	 */
	private ArrayList<Customer> customers;

//methods

	/**
	 * Default constructor of the class
	 * Creates the administrator of the system
	 */
	public CargoSystem()
	{
		//At the start there is only one admin that creates other entities
		admin = new Administrator();

		branches = new ArrayList<>();
		transportEmps = new ArrayList<>();
		customers = new ArrayList<>();
	}

//admin methods

	/**
	 * Admin adds a branch with the given ID to the system
	 */
	public void adminAddBranch()
	{
		Scanner scanner = new Scanner(System.in);
		int branchId = -1;

		try{
			System.out.print("Enter the branch ID: ");
			branchId = Integer.parseInt( scanner.nextLine() );

			admin.addBranch(branches, branchId);
			System.out.println("Done!");
		}
		catch(WrongIdException e){
			System.out.println(e.getMessage());
		}
		catch(NumberFormatException e){
			System.out.println("Given input does not include an Integer");
		}
	}

	/**
	 * Admin removes the branch with the given ID from the system
	 */
	public void adminRemoveBranch()
	{
		Scanner scanner = new Scanner(System.in);

		try{
			System.out.print("Enter the branch ID: ");
			int branchId = Integer.parseInt( scanner.nextLine() );

			admin.removeBranch(branches,branchId);
			System.out.println("Done!");
		}
		catch(WrongIdException e){
			System.out.println(e.getMessage());
		}
		catch(NumberFormatException e){
			System.out.println("Given input does not include an Integer");
		}
	}

	/**
	 * Admin adds a branch employee with the given ID to the branch with the given ID
	 */
	public void adminAddBranchEmp()
	{
		Scanner scanner = new Scanner(System.in);
		Branch branch = null;
		BranchEmployee employee = null;
		ArrayList<BranchEmployee> employees;
		String password;

		try
		{
			System.out.print("Enter the Employee ID: ");
			int empId = Integer.parseInt( scanner.nextLine() );

			System.out.print("Enter the branch ID: ");
			int branchId = Integer.parseInt( scanner.nextLine() );

			//Finding the branch which we will add the employee to
			branch = Entity.findEntity(branches,branchId);
			if(branch == null)
				throw new WrongIdException("Branch ID does not exist");

			//controlling if an employee exists in the system with the same id
			for(Branch value : branches){
				employees = value.getEmployees();

				if (Entity.findEntity(employees, empId) != null)
					throw new WrongIdException("Employee ID already exists");
			}

			//Getting the password of the user
			System.out.print("Enter the Password: ");
			password = scanner.nextLine();

			//branch is assigned with the new employee list
			ArrayList<BranchEmployee> newEmployees = branch.getEmployees();
			admin.addBranchEmployee(newEmployees, empId, password);
			branch.setEmployees(newEmployees);

			System.out.println("Done!");
		}
		catch(WrongIdException e){
			System.out.println(e.getMessage());
		}
		catch(NumberFormatException e){
			System.out.println("Given input does not include an Integer");
		}
	}

	/**
	 * Admin removes a branch employee with the given ID from the system
	 */
	public void adminRemoveBranchEmp()
	{
		Scanner scanner = new Scanner(System.in);
		Branch branch = null;
		BranchEmployee employee = null;
		int empIndex;
		ArrayList<BranchEmployee> employees;

		try
		{
			System.out.print("Enter the Employee ID: ");
			int empId = Integer.parseInt( scanner.nextLine() );

			for(Branch value : branches){
				employees = value.getEmployees();

				empIndex = Entity.findEntityIndex(employees,empId);
				if(empIndex != -1){
					employee = employees.get(empIndex);
					branch = value;
				}
			}
			if(employee== null)
				throw new WrongIdException("Employee ID does not exists");

			ArrayList<BranchEmployee> newEmployees = branch.getEmployees();
			admin.removeBranchEmployee(newEmployees,empId);
			branch.setEmployees(newEmployees);

			System.out.println("Done!");
		}
		catch(WrongIdException e){
			System.out.println(e.getMessage());
		}
		catch(NumberFormatException e){
			System.out.println("Given input does not include an Integer");
		}
	}

	/**
	 * Admin adds a transportation employee with the given ID to the system
	 */
	public void adminAddTransportEmp()
	{
		Scanner scanner = new Scanner(System.in);
		String password;

		try{
			System.out.print("Enter the Transportation Employee ID: ");
			int empId = Integer.parseInt( scanner.nextLine() );

			System.out.print("Enter the Password: ");
			password = scanner.nextLine();

			admin.addTransportEmployee(transportEmps,empId,password);
			System.out.println("Done!");
		}
		catch(WrongIdException e){
			System.out.println(e.getMessage());
		}
		catch(NumberFormatException e){
			System.out.println("Given input does not include an Integer");
		}
	}

	/**
	 * Admin removes the transportation employee with the given ID from the system
	 */
	public void adminRemoveTransportEmp()
	{
		Scanner scanner = new Scanner(System.in);

		try{
			System.out.print("Enter the Transportation Employee ID: ");
			int empId = Integer.parseInt( scanner.nextLine() );

			admin.removeTransportEmployee(transportEmps,empId);
			System.out.println("Done!");
		}
		catch(WrongIdException e){
			System.out.println(e.getMessage());
		}
		catch(NumberFormatException e){
			System.out.println("Given input does not include an Integer");
		}
	}

//Branch Employee methods

	/**
	 * Branch employee with the given ID adds a customer with the given ID to the system
	 * @param employee Employee who will get the job done
	 */
	public void branchEmpAddCustomer(BranchEmployee employee)
	{
		Scanner scanner = new Scanner(System.in);

		try
		{
			System.out.print("Enter the Customer ID: ");
			int custId = Integer.parseInt( scanner.nextLine() );

			employee.addCustomer(customers, custId);
			System.out.println("Done!");
		}
		catch(WrongIdException e){
			System.out.println(e.getMessage());
		}
		catch(NumberFormatException e){
			System.out.println("Given input does not include an Integer");
		}
	}

	/**
	 * Branch employee with the given ID removes the customer with the given ID from the system
	 * @param employee Employee who will do the given action
	 */
	public void branchEmpRemoveCustomer(BranchEmployee employee)
	{
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the Customer ID: ");
			int custId = Integer.parseInt( scanner.nextLine() );

			employee.removeCustomer(customers, custId);
			System.out.println("Done!");
		}
		catch(WrongIdException e){
			System.out.println(e.getMessage());
		}
		catch(NumberFormatException e){
			System.out.println("Given input does not include an Integer");
		}
	}

	/**
	 * Given Branch Employee adds a cargo with the given ID to the branch with the given ID
	 * @param employee Employee who will add the cargo
	 * @param customer Customer who ordered the cargo
	 */
	public void branchEmpAddCargo(BranchEmployee employee, Customer customer)
	{
		try{
			Branch branch = null;
			ArrayList<BranchEmployee> branchEmps;

			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the Cargo ID: ");
			int cargoId = Integer.parseInt( scanner.nextLine() );

			//searching for cargo
			for (Branch value : branches) {
				if (Entity.findEntity( value.getEmployees(), employee.getId() ) == employee)
					branch = value;
			}
			if(branch == null)
				throw new WrongIdException("Cargo does not exist");

			//Employee creates and updates the cargo list of the branch
			ArrayList<Cargo> cargoes = branch.getCargoes();
			employee.addCargo(cargoes,cargoId,customer);
			branch.setCargoes(cargoes);

			System.out.println("Done!");
		}
		catch(WrongIdException e){
			System.out.println(e.getMessage());
		}
		catch(NumberFormatException e){
			System.out.println("Given input does not include an Integer");
		}
	}

	/**
	 * Branch employee with the given ID removes the cargo with the given ID from the branch with the given ID
	 * @param employee Employee who will add the cargo
	 */
	public void branchEmpRemoveCargo(BranchEmployee employee)
	{
		try{
			Branch branch = null;

			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the Cargo ID: ");
			int cargoId = Integer.parseInt( scanner.nextLine() );

			//finding target cargo
			Cargo cargo = null;

			for (Branch value : branches) {
				if (Entity.findEntity(value.getCargoes(), cargoId) != null)
					branch = value;
			}
			if(branch == null)
				throw new WrongIdException("Cargo does not exist in the same Branch with Employee");

			//target employee removes the cargo which is in the same branch as itself
			ArrayList<Cargo> cargoes = branch.getCargoes();
			employee.removeCargo(cargoes,cargoId);
			branch.setCargoes(cargoes);

			System.out.println("Done!");
		}
		catch(WrongIdException e){
			System.out.println(e.getMessage());
		}
		catch(NumberFormatException e){
			System.out.println("Given input does not include an Integer");
		}
	}

//Transportation Employee methods

	/**
	 * Transportation employee with the given ID takes the cargo with the given ID from the branch which cargo exists in
	 * @param employee Employee who will do the action
	 */
	public void transportEmpTakeCargo(TransportEmployee employee)
	{
		Scanner scanner = new Scanner(System.in);
		Cargo cargo = null;
		ArrayList<Cargo> cargoList;
		Branch branch = null;

		try{
			System.out.print("Enter the Cargo ID: ");
			int cargoId = Integer.parseInt( scanner.nextLine() );

			//finding the cargo
			for (Branch value : branches) {
				cargoList = value.getCargoes();

				cargo = Entity.findEntity(cargoList, cargoId);
				if (cargo != null) {
					branch = value;
				}
			}
			if(cargo == null)
				throw new WrongIdException("Cargo does not exist");

			//transportEmployee takes the cargo
			employee.takeCargo(cargo);

			//random branchEmployee removes it from Branch's cargo stock list
			BranchEmployee employeeInstance = new BranchEmployee();

			ArrayList<Cargo> cargoes = branch.getCargoes();
			employeeInstance.removeCargo(cargoes, cargo.getId());
			branch.setCargoes(cargoes);
		}
		catch(WrongIdException e){
			System.out.println(e.getMessage());
		}
		catch(NumberFormatException e){
			System.out.println("Given input does not include an Integer");
		}
	}

	/**
	 * Transportation employee delivers the cargo that he/she is carrying
	 * @param employee Employee who will do the action
	 */
	public void transportEmpDeliverCargo(TransportEmployee employee)
	{
		employee.deliverCargo();
	}

//Customer method

	/**
	 * The status of the cargo is shown to the customer
	 */
	public void customerSeeCargoStatus()
	{
		Scanner scanner = new Scanner(System.in);
		Cargo cargo = null;
		int cargoIndex = -1;
		ArrayList<Cargo> cargoes = null;
		String status = null;

		try{
			System.out.print("Enter the Cargo ID: ");
			int cargoId = Integer.parseInt( scanner.nextLine() );

			//Searching in branches
			for(Branch value : branches){
				cargoes = value.getCargoes();

				cargoIndex = Entity.findEntityIndex(cargoes,cargoId);
				if(cargoIndex != -1)
					cargo = cargoes.get(cargoIndex);
			}
			//Searching in transportation employees
			for(TransportEmployee value : transportEmps){
				if(cargoId == value.getCargo().getId())
					cargo = value.getCargo();
			}
			//Searching in customers
			for(Customer value : customers){
				cargoes = value.getCargoes();

				cargoIndex = Entity.findEntityIndex(cargoes,cargoId);
				if(cargoIndex != -1)
					cargo = cargoes.get(cargoIndex);
			}

			if(cargo != null)
				System.out.println(cargo.getStatus());
			else
				throw new WrongIdException("Cargo does not exist");

		}
		catch(WrongIdException e){
			System.out.println(e.getMessage());
		}
		catch(NumberFormatException e){
			System.out.println("Given input does not include an Integer");
		}
	}

//login methods

	@Override
	public String userSelection()
	{
		Scanner scanner = new Scanner(System.in);
		String selection;
		boolean flag;

		do{
			System.out.println("\nLogin Selections:");
			System.out.println("1- Administrator");
			System.out.println("2- Branch Employee");
			System.out.println("3- Transportation Employee");
			System.out.println("4- Customer");
			System.out.println("0- Exit");

			selection = scanner.nextLine();

			if( !( selection.equals("1") || selection.equals("2") || selection.equals("3") || selection.equals("4") || selection.equals("0") ) ) {
				System.out.println("Invalid selection! Try again.\n");
				flag = true;
			} else
				flag = false;

		}while( flag );

		return selection;
	}

	/**
	 * Actions that can be made by Admin when logged in
	 */
	public void adminLogin()
	{
		String selection;

		//Login with password
		if( admin.login() ) {
			do {
				selection = admin.userSelection();

				switch (selection) {
					case "1":
						adminAddBranch();
						break;

					case "2":
						adminRemoveBranch();
						break;

					case "3":
						adminAddBranchEmp();
						break;

					case "4":
						adminRemoveBranchEmp();
						break;

					case "5":
						adminAddTransportEmp();
						break;

					case "6":
						adminRemoveTransportEmp();
						break;
				}

			} while (!selection.equals("0"));
		}
		else
			System.out.println("Wrong password!");
	}

	/**
	 * Actions that can be made by Branch Employee when logged in
	 */
	public void branchEmpLogin()
	{
		Scanner scanner = new Scanner(System.in);

		BranchEmployee employee = null;
		int empId;
		String selection;

		Customer customer;
		int custId;

		System.out.println("User ID: ");
		empId = scanner.nextInt();

		//Searching for Employee with given ID
		for (Branch branch : branches) {
			ArrayList<BranchEmployee> employees = branch.getEmployees();

			employee = Entity.findEntity(employees,empId);
		}
		//if it is not found
		if(employee == null)
			System.out.println("Employee does not exist");
		else
		{
			//Login with password
			if (employee.login()) {
				do { //User selects the action
					switch (selection = employee.userSelection()) {
						case "1":
							branchEmpAddCustomer(employee);
							break;

						case "2":
							branchEmpRemoveCustomer(employee);
							break;

						case "3":
							System.out.print("Enter the Customer ID who ordered the cargo: ");
							custId = scanner.nextInt();
							//finding the customer
							customer = Entity.findEntity(customers, custId);

							if (customer == null)
								System.out.println("Customer not found.");
							else
								branchEmpAddCargo(employee, customer);
							break;

						case "4":
							branchEmpRemoveCargo(employee);
							break;
					}
				} while (!selection.equals("0"));
			}
			else
				System.out.println("Wrong password!");
		}
	}

	/**
	 * Actions that can be made by Transportation Employee when logged in
	 */
	public void transportEmpLogin()
	 {
		Scanner scanner = new Scanner(System.in);

		TransportEmployee employee;
		int empId;
		int empIndex;
		String selection;

		System.out.println("User ID: ");
		empId = scanner.nextInt();
		//Searching for Employee with given ID
		employee = Entity.findEntity(transportEmps,empId);

		if(employee == null)
			System.out.println("Employee does not exist!");
		else
		{
			if (employee.login())
			{
				do {
					switch (selection = employee.userSelection()) {
						case "1":
							transportEmpTakeCargo(employee);
							break;

						case "2":
							transportEmpDeliverCargo(employee);
							break;
					}

				} while (!selection.equals("0"));
			}
			else
				System.out.println("Wrong password!");
		}
	}

	/**
	 * Actions that can be made by Customer when logged in
	 */
	public void customerLogin()
	{
		Customer customerInstance = new Customer();

		if( customerInstance.userSelection().equals("1") )
			customerSeeCargoStatus();
	}

//Menu Functions

	/**
	 * Menu of the System
	 */
	public void menu()
	{
		String selection;

		System.out.println("Welcome to the Cargo System\n");

		admin.changePassword();

		do{
			selection = userSelection();

			switch ( selection ) {
				case "1":
					adminLogin();
					break;

				case "2":
					branchEmpLogin();
					break;

				case "3":
					transportEmpLogin();
					break;

				case "4":
					customerLogin();
					break;
			}

		}while( !selection.equals("0") );

		System.out.println("\nThank you for using our Cargo System. Come again.");
	}
}
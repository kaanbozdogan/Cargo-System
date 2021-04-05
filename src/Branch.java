import java.util.ArrayList;

public class Branch extends Entity
{
	/**
	 * Employees of the branch
	 */
	private ArrayList<BranchEmployee> employees;

	/**
	 * Cargoes that are not taken by the transportation employees yet
	 */
	private ArrayList<Cargo> cargoes;

	/**
	 * Default constructor
	 */
	public Branch()
	{
		super();
		employees = new ArrayList<>();
		cargoes = new ArrayList<>();
	}

	/**
	 * Constructor with branch's ID
	 * @param newId ID of the branch
	 */
	public Branch(int newId)
	{
		super(newId);
		employees = new ArrayList<>();
		cargoes = new ArrayList<>();
	}

	/**
	 * getter for the collection of cargoes
	 * @return collection of cargoes
	 */
	public ArrayList<BranchEmployee> getEmployees()
	{
		return employees;
	}

	/**
	 * setter for the collection of cargoes
	 * @param newEmployees collection of cargoes
	 */
	public void setEmployees(ArrayList<BranchEmployee> newEmployees)
	{
		employees = newEmployees;
	}

	/**
	 * getter for the cargoes
	 * @return collection of the cargoes
	 */
	public ArrayList<Cargo> getCargoes()
	{
		return cargoes;
	}

	/**
	 * setter for the cargoes
	 * @param newCargoes collection of the cargoes
	 */
	public void setCargoes(ArrayList<Cargo> newCargoes)
	{
		cargoes = newCargoes;
	}

}
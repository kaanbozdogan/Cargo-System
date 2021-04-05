import java.util.ArrayList;
import java.util.Scanner;

public abstract class User extends Entity implements UserInterface
{
	/**
	 * PAssword of the users
	 */
	protected String password;

	/**
	 * Default constructor
	 */
	public User()
	{
		super();
		password = "";
	}

	/**
	 * Constructor that takes only ID
	 * @param newId ID of the constructed object
	 */
	public User(int newId)
	{
		super(newId);
		password = "";
	}

	/**
	 * Constructor that takes only password
	 * @param newPassword password of the constructed object
	 */
	public User(String newPassword)
	{
		super();
		password = newPassword;
	}

	/**
	 * Constructor that fully constructs the object
	 * @param newId ID of the constructed object
	 * @param newPassword password of the constructed object
	 */
	public User(int newId, String newPassword)
	{
		super(newId);
		password = newPassword;
	}

	/**
	 * Adds the given item to the given container
	 * @param list given container
	 * @param newItem given item
	 * @param <T> Generic type that extends Entity
	 */
	protected <T extends Entity> void addItem(ArrayList<T> list, T newItem)
	{
		//controlling if the branch with the same id already exists or not
		if (Entity.findEntityIndex(list,newItem.getId()) != -1)
			throw new WrongIdException("ID already exists");

		list.add(newItem);
	}

	/**
	 * Removes the item with the given ID from the given container
	 * @param list given container
	 * @param itemId Item's ID
	 * @param <T> Generic type that extends Entity
	 */
	protected <T extends Entity> void removeItem(ArrayList<T> list, int itemId)
	{
		//Not searching with object instance because properties other than ID of the object can be different
		//Having the same ID is the only condition of being the same object in this situation
		int index = Entity.findEntityIndex(list,itemId);

		if (index == -1)
			throw new WrongIdException("ID does not exist");

		list.remove(index);
	}

	/**
	 * Checks if the inputted password is the user's password
	 * @return true if the inputted password is the user's password
	 */
	public boolean login()
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("password: ");
		return password.equals(scanner.nextLine());
	}

}
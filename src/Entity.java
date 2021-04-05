import java.util.ArrayList;

public abstract class Entity
{
	/**
	 * ID of the entity
	 */
	protected int id;

	/**
	 * Default constructor of the class
	 */
	public Entity(){
		id = 0;
	}

	/**
	 * Constructor that takes the ID of the entity that will be created
	 * @param newId ID of the entity
	 */
	public Entity(int newId)
	{
		setId(newId);
	}

	/**
	 * Setter function for the ID of the entity
	 * @param newId setted value
	 */
	public void setId(int newId)
	{
		if(newId > 0)
			id = newId;
		else
			throw new WrongIdException("ID must be a positive integer");
	}

	/**
	 * Getter for the ID of the entity
	 * @return ID of the entity
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Finds the Entity with given ID in the given container
	 * @param entities Searched container
	 * @param targetId ID of the searched Entity
	 * @param <T> Entity or classes that extends Entities
	 * @return Returns the index of Entity with the given IDs. If Entity does not exist in the container returns -1.
	 */
	static public <T extends Entity> int findEntityIndex(ArrayList<T> entities, int targetId)
	{
		for (int i = 0; i < entities.size(); i++)
		{
			if (entities.get(i).getId() == targetId)
				return i;
		}

		return -1;
	}

	/**
	 * Finds the Entity with given ID in the given container
	 * @param entities Searched container
	 * @param targetId ID of the searched Entity
	 * @param <T> Entity or classes that extends Entities
	 * @return Returns the Entity with the given IDs. If Entity does not exist in the container returns null
	 */
	static public <T extends Entity> T findEntity(ArrayList<T> entities, int targetId)
	{
		for (T entity : entities) {
			if (entity.getId() == targetId)
				return entity;
		}

		return null;
	}

	/**
	 * Function written for seeing what the function has done to the containers of the system
	 * @return the ID of the Entity as a printable String
	 */
	public String toString() {
		return String.valueOf(getId());
	}
}
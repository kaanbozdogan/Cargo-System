/**
 * Lets us know what is wrong with the action we did on the System
 * @author Kaan Can Bozdoan
 * @version 1.0
 */

public class WrongIdException extends RuntimeException
{
	/**
	 * Default constructor
	 */
	WrongIdException()
	{
		super();
	}

	/**
	 * Constructor with the message
	 * @param str the message
	 */
	WrongIdException(String str)
	{
		super(str);
	}
}

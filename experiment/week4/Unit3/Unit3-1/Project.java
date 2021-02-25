/**
 * This class models an Project. The following information is maintained:
 * <ol>
 * <li>the ID of the Project, an <code>int</code></li>
 * <li>the name of the Project, a <code>String</code></li>
 * <li>the price of the Project, a <code>double</code></li>
 * </ol>
 *
 * @author  iCarnegie
 * @version  1.0.0
 */
public class  Project {

	/* The ID of the Project */
	private int id;

	/* The name of the Project */
	private String  name;

	/* The price of the Project */
	private double  price;

	/**
	 * Creates an Project object with the specified ID, name and price.
	 *
	 * @param initialId  the ID of the Project.
	 * @param initialName  the name of the Project.
	 * @param initialprice  the price of the Project.
	 */
	public Project(int initialId, String initialName, double initialPrice) {

		this.id = initialId;
		this.name = initialName;
		this.price = initialPrice;
	}

	/**
	 * Returns the ID of this Project.
	 *
	 * @return  the ID of this Project.
	 */
	public int  getId()  {

		return  this.id;
	}

	/**
	 * Returns the name of this Project.
	 *
	 * @return  the name of this Project.
	 */
	public String  getName()  {

		return  this.name;
	}

	/**
	 * Returns the Price of this Project.
	 *
	 * @return  the Price of this Project.
	 */
	public double  getPrice()  {

		return  this.price;
	}

	/**
	 * Modifies the Price of this Project.
	 *
	 * @param newPrice  the new Price of this Project.
	 */
	public void  setPrice(double newPrice)  {

		this.price = newPrice;
	}

	/**
	 * Returns the string representation of this Project in the following
	 * format: Project[<i>ID</i>,<i>name</i>,<i>Price</i>]
	 *
	 * @return a string representation of this Project.
	 */
	public String  toString()  {

		return "Project[" + getId() + "," + getName() + "," + getPrice() +"]";
	}
}
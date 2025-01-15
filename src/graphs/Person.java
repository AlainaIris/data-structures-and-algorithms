/**
 * Purpose	Simple Person class for graph
 * Status	In Progress
 *
 * @author	Alaina Iris
 * @version	01.15.2025
 */
public class Person {
	private String name;
	
	/**
	 * Construct new person
	 */
	public Person(String name) {
		setName(name);
	}

	/**
	 * Set the person's name
	 *
	 * @param  name Name to set
	 * @throws IllegalArgumentException When name is invalid
	 */
	private void setName(String name) throws IllegalArgumentException {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Person must be named");
		} else {
			this.name = name;
		}
	}

	public String toString() {
		return name;
	}
}

public class ListIndexOutOfBoundsException extends RuntimeException {
	private String message;

	/**
	 * Create exception with default message
	 */
	public ListIndexOutOfBoundsException() {
		message = "Attempted to access an index out of bound";
	}	

	/**
	 * Create exception with custom message
	 *
	 * @param  message Custom message
	 */
	public ListIndexOutOfBoundsException(String message) {
		this.message = message;
	}

	/**
	 * Formatted string
	 *
	 * @return Formatted string
	 */
	public String toString() {
		return message;
	}
}

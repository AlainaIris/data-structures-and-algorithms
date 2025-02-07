/**
 * Node structure for single direction linked items
 */
public class Node<T> {
	private T value;
	private Node next;

	/**
	 * Construct node from value
	 *
	 * @param  value Value of node
	 */
	public Node(T value) {
		this.value = value;
	}

	/**
	 * Construct node from value and reference to next
	 *
	 * @param  value Value of node
	 * @param  next Node that follows this one
	 */
	public Node(T value, Node next) {
		this.value = value;
		this.next = next;
	}

	/**
	 * Get the node value
	 *
	 * @return value
	 */
	public T getValue() {
		return value;
	}

	/**
	 * Get the next node
	 *
	 * @return next node
	 */
	public Node getNext() {
		return next;
	}


	/**
	 * Update which node follows this one
	 *
	 * @param  next Node which follows this one
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * Pretty String
	 *
	 * @return pretty string
	 */
	public String toString() {
		return value.toString();
	}
}

/**
 * Node structure for double direction linked items
 */
public class DNode<T> {
	private T value;
	private DNode next;
	private DNode back;

	/**
	 * Construct node from value
	 *
	 * @param  value Value of node
	 */
	public DNode(T value) {
		this.value = value;
	}

	/**
	 * Construct node from value and reference to next and back
	 *
	 * @param  value Value of node
	 * @param  next Node that follows this one
	 * @param  back Node that precedes this one
	 */
	public DNode(T value, DNode next, DNode back) {
		this.value = value;
		this.next = next;
		this.back = back;
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
	public DNode getNext() {
		return next;
	}

	/**
	 * Get the previous node
	 *
	 * @return previous node
	 */
	public DNode getBack() {
		return back;
	}

	/**
	 * Update which node follows this one
	 *
	 * @param  next Node which follows this one
	 */
	public void setNext(DNode next) {
		this.next = next;
	}

	/**
	 * Update which node precedes this one
	 *
	 * @param  back Node which precedes this one
	 */
	public void setBack(DNode back) {
		this.back = back;
	}
}

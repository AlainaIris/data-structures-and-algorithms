/**
 * Purpose	Tree Node (Leaf)
 * Status	Finished
 *
 * @author	Alaina Iris
 * @version	01.14.2025
 */
public class Node {
	public int value;
	public Node left;
	public Node right;

	/**
	 * Create a new node
	 *
	 * @param  value Value of node
	 */
	public Node(int value) {
		this.value = value;
		left = null;
		right = null;
	}
	
	/**
	 * Create a new node
	 *
	 * @param  value Value of node
	 * @param  left Left child of node
	 * @param  right Right child of node
	 */
	public Node(int value, Node left, Node right) {
		this.left = left;
		this.right = right;
		this.value = value;
	}
}

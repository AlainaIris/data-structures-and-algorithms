/**
 * Purpose	Node for graphs
 * Status	In Progress
 *
 * @author	Alaina Iris
 * @version	01.15.2025
 */
import java.util.ArrayList;
import java.util.HashSet;
public class Node<T> {
	private T value;
	private ArrayList<Edge> adj;

	/**
	 * Construct a new node
	 *
	 * @param  value Value of node
	 */
	public Node(T value) {
		setValue(value);
		adj = new ArrayList<Edge>();
	}

	/**
	 * Get the edges connected to the node
	 *
	 * @return Adjacent edges
	 */
	public ArrayList<Edge> getAdjacent() {
		return adj;
	}

	/**
	 * Get adjacent nodes
	 *
	 * @return Adjacent nodes
	 */
	public HashSet<Node> getAdjacentNodes() {
		HashSet<Node> nodes = new HashSet<Node>();
		for (Edge e : adj) {
			if (e.getSecondNode() != this) {
				nodes.add(e.getSecondNode());
			} else if (e.getFirstNode() != this) {
				nodes.add(e.getFirstNode());
			}
		}
		return nodes;
	}

	/**
	 * Get cheapest edge connection to another node
	 *
	 * @param  node Node to connect to
	 * @return Cheapest value (or -1)
	 */
	public int getCheapestConnection(Node node) {
		int min = Integer.MAX_VALUE;
		boolean connected = false;
		for (Edge e : adj) {
			Node first = e.getFirstNode();
			Node second = e.getSecondNode();
			if (((first == this && second == node) ||
			    (second == this && first == node))
			    && e.getWeight() <= min) {
				min = e.getWeight();
				connected = true;
			}
		}
		return connected ? min : -1;
	}

	/**
	 * Add edge to node in adjacent list
	 *
	 * @param  edge Edge to add
	 * @throws IllegalArgumentException If invalid edge
	 */
	public void addEdge(Edge edge) {
		if (edge == null) {
			throw new IllegalArgumentException("Edge cannot be null");
		} else if ((edge.getFirstNode() != this) && (edge.directed() || edge.getSecondNode() != this)) {
			throw new IllegalArgumentException("Edge must have this node (or must start with this node if directional)");
		} else {
			adj.add(edge);
		}
	}

	/**
	 * Set the value of the node if valid
	 *
	 * @param  value Value to set
	 * @throws IllegalArgumentException when the value does not exist
	 */
	private void setValue(T value) {
		if (value == null) {
			throw new IllegalArgumentException("Node values cannot be null");
		} else {
			this.value = value;
		}
	}

	/**
	 * Get pretty string for value
	 *
	 * @return Pretty string
	 */
	public String toString() {
		return value.toString();
	}
}

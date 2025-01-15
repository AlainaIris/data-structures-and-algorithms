/**
 * Purpose	Graph implementation (weighted, unweighted, directed, etc.)
 * Status	In Progress
 *
 * @author	Alaina Iris
 * @version	01.15.2025
 */
import java.util.HashSet;
import java.util.ArrayList;

public class Graph<T> {
	private HashSet<Node<T>> verts; // Unique verticies
	
	public Graph() {
		verts = new HashSet<Node<T>>();
	}

	/**
	 * Attempt to add a node to the list of verticies
	 *
	 * @param  node Node to add
	 * @throws IllegalArgumentException When node doesn't exist
	 */
	public void addNode(Node<T> node) throws IllegalArgumentException {
		if (node != null) {
			verts.add(node);
		} else {
			throw new IllegalArgumentException("Nodes must not be null");
		}
	}

	/**
	 * Attempt to add a set of nodes
	 *
	 * @param  nodes Set of nodes
	 */
	public void addNodes(HashSet<Node<T>> nodes) {
		for (Node<T> node : nodes) {
			try {
				addNode(node);
			} catch (IllegalArgumentException e) {
				System.out.println("Addition of node: " + node + " failed");
				System.out.println(e);
			}
		}
	}

	/**
	 * Attempt to add edge to graph
	 *
	 * @param  edge Edge to add
	 * @throws IllegalArgumentException When edge is invalid
	 */
	public void addEdge(Edge edge) throws IllegalArgumentException {
		if (edge == null) {                        
			throw new IllegalArgumentException("Nodes must not be null");
		} else if (containsNode(edge.getFirstNode()) &&
			   containsNode(edge.getSecondNode())) {
			edge.getFirstNode().addEdge(edge);
			if (!edge.directed()) {
				edge.getSecondNode().addEdge(edge);
			}
		} else {
			throw new IllegalArgumentException("Edges can only use nodes already within the network");
		}
	}

	/**
	 * Attempt to add a list of edges
	 *
	 * @param  edges Edges to add
	 */
	public void addEdges(ArrayList<Edge> edges) {
		for (Edge edge : edges) {
			try {
				addEdge(edge);
			} catch (IllegalArgumentException e) {
				System.out.println("Addition of edge: " + edge + " failed");
				System.out.println(e);
			}
		}
	}
	
	/**
	 * Check if node is included in graph
	 *
	 * @param  node Node to check
	 * @return If node is included
	 */
	public boolean containsNode(Node node) {
		return verts.contains(node);
	}
}

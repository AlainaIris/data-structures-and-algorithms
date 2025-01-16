/**
 * Purpose	Implementation of graph edge with modifiers
 * 		By default multigraph edges are permitted; It is
 * 		up to the user to ensure proper parameter checks
 * 		if that is not desired
 * Status	In Progress
 *
 * @author	Alaina Iris
 * @version	01.15.2025
 */
public class Edge {
	private Node node1;
	private Node node2;
	private int weight;
	private boolean directed;
	
	/**
	 * Construct a new edge
	 *
	 * @param  builder Edge Builder
	 */
	public Edge(Builder builder) {
		this.node1 = builder.node1;
		this.node2 = builder.node2;
		this.weight = builder.weight;
		this.directed = builder.directed;
	}
	
	/**
	 * Get first node
	 *
	 * @return first node
	 */
	public Node getFirstNode() {
		return node1;
	}

	/**
	 * Get second node
	 *
	 * @return second node
	 */
	public Node getSecondNode() {
		return node2;
	}

	/**
	 * Get edge weight
	 *
	 * @return weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Get if directed edge
	 *
	 * @return is directed
	 */
	public boolean directed() {
		return directed;
	}

	/**
	 * Get pretty string for edge
	 *
	 * @return Pretty string
	 */
	public String toString() {
		return node1 + " to " + node2;
	}

	/**
	 * Implement edge builder class to handle optional
	 * parameters of weight and directed edge
	 */
	public static class Builder {
		private Node node1;
		private Node node2;
		private int weight;
		private boolean directed;

		/**
		 * Attempt to construct a new edge builder
		 * Program should end abruptly if construction is invalid
		 *
		 * @param  node1 "First" node. Origin of edge for directed edge
		 * @param  node2 "Second" node. End location of edge if directed
		 */
		public Builder newEdge(Node node1, Node node2) {
			setFirstNode(node1);
			setSecondNode(node2);
			directed = false;
			weight = 1;
			return this;
		}

		/**
		 * Attempt to set first node
		 *
		 * @param  node Node to set
		 * @throws IllegalArgumentException If node does not exist
		 */
		private void setFirstNode(Node node) throws IllegalArgumentException {
			if (node == null) {
				throw new IllegalArgumentException("Edges must be between two existing nodes");
			}
			node1 = node;
		}

		/**
		 * Attempt to set second node
		 *
		 * @param  node Node to set
		 * @throws IllegalArgumentException If node does not exist
		 */
		private void setSecondNode(Node node) throws IllegalArgumentException {
			if (node == null) {
				throw new IllegalArgumentException("Edges must be between two existing nodes");
			}
			node2 = node;
		}

		/**
		 * Set edge to be a certain weight
		 *
		 * @param  weight Weight to set
		 * @return Edge builder
		 */
		public Builder weight(int weight) {
			this.weight = weight;
			return this;
		}

		/**
		 * Set edge to be directed (node1 to node2)
		 *
		 * @param  directed If edge is directed
		 * @return Edge builder
		 */
		public Builder directed(boolean directed) {
			this.directed = directed;
			return this;
		}

		/**
		 * Construct edge from builder
		 *
		 * @return New edge
		 */
		public Edge build() {
			return new Edge(this);
		}
	}
}

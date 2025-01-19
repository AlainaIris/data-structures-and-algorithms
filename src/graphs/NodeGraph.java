/**
 * Purpose	Graph implementation (weighted, unweighted, directed, etc.)
 * Status	In Progress
 *
 * @author	Alaina Iris
 * @version	01.15.2025
 */
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Collections;

public class NodeGraph<T> {
	private HashSet<Node<T>> verts; // Unique verticies
	
	public NodeGraph() {
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
	 * DFS traversal path
	 *
	 * @param  start Start node
	 * @return Traversal path (does not include disjoint pathing)
	 */
	public ArrayList<Node> traverseDFSPath(Node start) {
                ArrayList<Node> visited = new ArrayList<Node>();
                Stack<Node> stack = new Stack<Node>();
                stack.push(start);
                while (!stack.isEmpty()) {
                        Node pos = stack.pop();
                        if (visited.contains(pos)) {
                                continue;
                        }
                        visited.add(pos);
                        for (Edge edge : (ArrayList<Edge>) pos.getAdjacent()) {
                                Node adj;
                                if (edge.getSecondNode() != pos) {
                                        adj = edge.getSecondNode();
                                } else if (edge.getFirstNode() != pos) {
                                        adj = edge.getFirstNode();
                                } else {
                                        continue;
                                }
                                if (!visited.contains(adj)) {
                                        stack.push(adj);
                                }
                        }
                }
                return visited;
	}

	/**
	 * BFS traversal path
	 *
	 * @param  start Start node
	 * @return Traversal path (does not include disjoint pathing)
	 */
	public ArrayList<Node> traverseBFSPath(Node start) {
                ArrayList<Node> visited = new ArrayList<Node>();
                ArrayDeque<Node> queue = new ArrayDeque<Node>();
                queue.add(start);
                while (!queue.isEmpty()) {
                        Node pos = queue.remove();
			if (visited.contains(pos)) {
				continue;
			}
			visited.add(pos);
                        for (Edge edge : (ArrayList<Edge>) pos.getAdjacent()) {
                                Node adj;
                                if (edge.getSecondNode() != pos) {
                                        adj = edge.getSecondNode();
                                } else if (edge.getFirstNode() != pos) {
                                        adj = edge.getFirstNode();
                                } else {
					continue;
				}
                                if (!visited.contains(adj)) {
                                        queue.add(adj);
                                }
                        }
                }
                return visited;
	}
	
	private int indexOf(Node[] array, Node value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Shortest path via Dijkstra's Algorithm
	 *
	 * @param  start Start node
	 * @param  end End node
	 * @return Path from end to start
	 */
	public ArrayList<Node> getShortestPath(Node start, Node end) {
		HashSet<Integer> set = new HashSet<Integer>();
		int[] distances = new int[verts.size()];
		Node[] previous = new Node[verts.size()];
		Node[] order = new Node[verts.size()]; // Node id
		int i = 0;
		for (Node node : verts) {
			set.add(i);
			order[i] = node;
			distances[i] = Integer.MAX_VALUE;
			previous[i] = null;
			i++;
		}
		distances[indexOf(order, start)] = 0;
		while (!set.isEmpty()) {
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for (Integer index : set) {
				if (distances[index] <= min) {
					minIndex = index;
					min = distances[index];
				}
			}
			Node location = order[minIndex];
			if (location == end) {
				break;
			}
			set.remove(minIndex);
			HashSet<Node> neighbors = location.getAdjacentNodes();
			for (Node node : neighbors) {
				if (!set.contains(indexOf(order, node))) {
					continue;
				} else {
					i = indexOf(order, node);
					int newWeight = distances[minIndex] + location.getCheapestConnection(node);
					if (newWeight < distances[i]) {
						distances[i] = newWeight;
						previous[i] = location;
					}
				}
			}
		}
		ArrayList<Node> path = new ArrayList<Node>();
		Node location = previous[indexOf(order, end)];
		if (location == null) {
			return null;
		} else {
			path.add(end);
			while (location != start) {
				path.add(location);
				if (indexOf(order, location) != -1) {
					location = previous[indexOf(order, location)];
				} else {
					break;
				}
			}
			path.add(start);
		}
		return path;
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

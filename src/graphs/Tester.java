/**
 * Purpose	General test for graph algorithms and structure
 * Status	In progress
 *
 * @author	Alaina Iris
 * @version	01.15.2025
 */
import java.util.ArrayList;
import java.util.HashSet;

public class Tester {
	public static void main(String[] args) {
		Person p1 = new Person("Ally");
		Person p2 = new Person("Beth");
		Person p3 = new Person("Cathy");
		Person p4 = new Person("Dan");
		Person p5 = new Person("Emily");
		Person p6 = new Person("Frank");
		Node n1 = new Node<Person>(p1);
		Node n2 = new Node<Person>(p2);
		Node n3 = new Node<Person>(p3);
		Node n4 = new Node<Person>(p4);
		Node n5 = new Node<Person>(p5);
		Node n6 = new Node<Person>(p6);
		HashSet<Node<Person>> nodes = new HashSet<Node<Person>>();
		nodes.add(n1);
		nodes.add(n2);
		nodes.add(n3);
		nodes.add(n4);
		nodes.add(n5);
		nodes.add(n6);
		ArrayList<Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge.Builder().newEdge(n1, n2).build());
		edges.add(new Edge.Builder().newEdge(n2, n5).build());
		edges.add(new Edge.Builder().newEdge(n1, n6).build());
		edges.add(new Edge.Builder().newEdge(n6, n4).build());
		edges.add(new Edge.Builder().newEdge(n5, n3).build());
		NodeGraph nodeGraph = new NodeGraph<Person>();
		nodeGraph.addNodes(nodes);
		nodeGraph.addEdges(edges);
		/**
		        |---Ally---Frank---Dan
		  Beth -|
			|---Emily---Cathy
		*/
		ArrayList<Node> dfsPath = nodeGraph.traverseDFSPath(n2);
		ArrayList<Node> bfsPath = nodeGraph.traverseBFSPath(n2);
		for (Node n : dfsPath) {
			System.out.print(n + " ");
		}
		System.out.println("");
		for (Node n : bfsPath) {
			System.out.print(n + " ");
		}
		System.out.println("");
		ArrayList<Node> path = nodeGraph.getShortestPath(n4, n3);
		if (path != null) {
			for (Node n : path) {
				System.out.print(n + " ");
			}
		}
        	int[][] grid = { { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                	         { 1, 1, 1, 0, 1, 1, 1, 0, 1, 1 },
                        	 { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
	                         { 0, 0, 1, 0, 1, 0, 0, 0, 0, 1 },
        	                 { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                	         { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                        	 { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1 },
    	                    	 { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
        	                 { 1, 1, 1, 0, 0, 0, 1, 0, 0, 1 } };
		Grid g = new Grid(grid);
		ArrayList<Integer[]> pathing = g.aStarPath(new int[] {0, 0}, new int[] {8, 9});
		for (Integer[] location : pathing) {
			System.out.println(location[0] + ", " + location[1]);
		}
		System.out.println(g);
	}
}

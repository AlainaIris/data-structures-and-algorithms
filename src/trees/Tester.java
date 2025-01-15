/**
 * Purpose	Test Tree functions
 * Status	In Progress
 *
 * @author	Alaina Iris
 * @version	01.14.2025
 */
import java.util.ArrayList;
public class Tester {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.left.left.left = new Node(7);
		root.right.left.left = new Node(8);
		Tree tree = new Tree(root);
		System.out.println(tree.depthFirstFound(2));
		System.out.println(tree.breadthFirstFound(8));
		System.out.println(tree.getHeight());
		ArrayList<Integer> list = tree.inOrderTraversalAsList();
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println("");
		list = tree.preOrderTraversalAsList();
		for (int i : list) {
			System.out.print(i + " ");
		}
                System.out.println("");
                list = tree.postOrderTraversalAsList();
                for (int i : list) {
                        System.out.print(i + " ");
                }
		System.out.println("");
	}
}

/**
 * Purpose	Tree Data Structure
 * Status	In Progress
 *
 * @author	Alaina Iris
 * @version	01.14.2025
 */
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.ArrayList;
public class Tree {
	private Node root;
	/**
	 * Create tree by a root
	 */
	public Tree(Node root) {
		this.root = root;
	}

	/**
	 * Recurrsive method for getting height of subtrees
	 *
	 * @param  node Subtree root
	 * @return Height
	 */
	private int maxSubtreeHeight(Node node) {
		if (node == null) {
			return -1;
		}
		int left = maxSubtreeHeight(node.left);
		int right = maxSubtreeHeight(node.right);
		return (left > right ? left : right) + 1;
	}

	/**
	 * Get the height of the tree
	 *
	 * @return Tree Height
	 */
	public int getHeight() {
		return maxSubtreeHeight(root);
	}

	/**
	 * Recurrsive method for getting maximum value of subtree
	 *
	 * @param  node Subtree root
	 * @return Maximum value
	 */
	private int maxNodeValue(Node node) {
		int max = node.value;
		if (node.left != null) {
			int leftMax = maxNodeValue(node.left);
			if (leftMax > max) {
				max = leftMax;
			}
		}
		if (node.right != null) {
			int rightMax = maxNodeValue(node.right);
			if (rightMax > max) {
				max = rightMax;
			}
		}
		return max;
	}

	/**
	 * Get the maximum node value
	 *
	 * @return Maximum node value
	 */
	public int maxValue() {
		return maxNodeValue(root);
	}

	/**
	 * Recurrsively get the minimum value of a subtree
	 *
	 * @param  node Subtree root
	 * @return Subtree minimum
	 */
	private int minNodeValue(Node node) {
		int min = node.value;
		if (node.left != null) {
			int leftMin = minNodeValue(node.left);
			if (leftMin < min) {
				min = leftMin;
			}
		}
		if (node.right != null) {
			int rightMin = minNodeValue(node.right);
			if (rightMin < min) {
				min = rightMin;
			}
		}
		return min;
	}

	/**
	 * Get minimum value in the tree
	 * 
	 * @return Minimum value
	 */
	public int minValue() {
		return minNodeValue(root);
	}

	/**
	 * Recurssively construct in order traversal
	 *
	 * @param  node Subtree root
	 * @param  list Path list
	 * @return In order list
	 */
	private ArrayList<Integer> inOrderTraverseSubtree(Node node, ArrayList<Integer> list) {
		if (node.left != null) {
			inOrderTraverseSubtree(node.left, list);
		}
		
		list.add(node.value);
		
		if (node.right != null) {
			inOrderTraverseSubtree(node.right, list);
		}
		
		return list;
	}

	/**
	 * Traversal of non-threaded tree in order
	 *
	 * @return List of node values in visited order
	 */
	public ArrayList<Integer> inOrderTraversalAsList() {
		return inOrderTraverseSubtree(root, new ArrayList<Integer>());
	}

	/**
	 * Traverse subtree in pre-order recurssively
	 *
         * @param  node Subtree root
         * @param  list Path list
         * @return Updated list
	 */
	private ArrayList<Integer> preOrderTraverseSubtree(Node node, ArrayList<Integer> list) {
		list.add(node.value);

		if (node.left != null) {
			preOrderTraverseSubtree(node.left, list);
		}
		if (node.right != null) {
			preOrderTraverseSubtree(node.right, list);
		}
		return list;
	}

	/**
	 * Traversal of non-threaded tree in pre-order
	 *
	 * @return List of node values in pre order traversal
	 */
	public ArrayList<Integer> preOrderTraversalAsList() {
		return preOrderTraverseSubtree(root, new ArrayList<Integer>());
	}

        /**
         * Traverse subtree in post-order recurssively
         * 
	 * @param  node Subtree root
	 * @param  list Path list
	 * @return Updated list
	 */
        private ArrayList<Integer> postOrderTraverseSubtree(Node node, ArrayList<Integer> list) {
                if (node.left != null) {
                        postOrderTraverseSubtree(node.left, list);
                }
                if (node.right != null) {
                        postOrderTraverseSubtree(node.right, list);
                }
		list.add(node.value);
                return list;
        }

        /**
         * Traversal of non-threaded tree in post-order
	 *
	 * @return Post order traversal path
         */
        public ArrayList<Integer> postOrderTraversalAsList() {
                return postOrderTraverseSubtree(root, new ArrayList<Integer>());
        }

	/**
	 * Do a depth first search, returning if a value
	 * exists in the tree
	 *
	 * @param  num Value to find
	 * @return If value is used in tree
	 */
	public boolean depthFirstFound(int num) {
		ArrayList<Integer> visited = new ArrayList<Integer>();
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			if (node.value == num) {
				return true;
			}
			visited.add(node.value);
			if (node.left != null && !visited.contains(node.left.value)) {
				stack.push(node.left);
			}
			if (node.right != null && !visited.contains(node.right.value)) {
				stack.push(node.right);
			}
		}
		return false;
	}

	/**
	 * Do a breadth first search, returning if a value
	 * exists in the tree
	 * 
	 * @param  num Value to find
	 * @return If value is used in tree
	 */
	public boolean breadthFirstFound(int num) {
		ArrayList<Integer> visited = new ArrayList<Integer>();
		ArrayDeque<Node> queue = new ArrayDeque<Node>();
		queue.add(root);
		while (queue.peek() != null) {
			Node node = queue.remove();
                        if (node.value == num) {
                                return true;
                        }
                        visited.add(node.value);
                        if (node.left != null && !visited.contains(node.left.value)) {
                                queue.add(node.left);
                        }
                        if (node.right != null && !visited.contains(node.right.value)) {
                                queue.add(node.right);
                        }
		}
		return false;
	}
}

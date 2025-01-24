/**
 * Tester for lists
 *
 * @author	Alaina Iris
 * @version	01.23.25
 */
public class Tester {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(15);
		stack.push(20);
		stack.push(10);
		stack.push(30);
		System.out.println(stack);
		System.out.format("Popped %d from the stack%n", stack.pop());
		System.out.format("Popped %d from the stack%n", stack.pop());
		System.out.println(stack);
		System.out.format("Peeked at %d%n", stack.peek());
		System.out.format("Popped %d from the stack%n", stack.pop());
		System.out.println(stack);
		System.out.format("Peeked at %d%n", stack.peek());
		Queue<Integer> queue = new Queue<Integer>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		System.out.println(queue);
		System.out.format("Removed %d from the queue%n", queue.remove());
		System.out.println(queue);
		System.out.format("Removed %d from the queue%n", queue.remove());
		System.out.format("Peeked at %d%n", queue.peek());
		System.out.format("Removed %d from the queue%n", queue.remove());
	}
}

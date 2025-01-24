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
		System.out.println(stack.pop());
		stack.pop();
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack);
		System.out.println(stack.peek());
	}
}

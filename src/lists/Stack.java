/**
 * A java implementation of a stack
 *
 * @author	Alaina Iris
 * @version	01.23.25
 */
import java.lang.StringBuilder;

public class Stack<T> {
	private T[] values;
	private int size;
	private int resizeAmount = 10;

	/**
	 * Create a new stack
	 */
	public Stack() {
		values = (T[]) new Object[10];
		size = 0;
	}

	/**
	 * Create a new stack with a custom resize amount
	 *
	 * @param  resizeAmount Resize amount
	 */
	public Stack(int resizeAmount) {
		if (resizeAmount < 1) {
			throw new IllegalArgumentException("Stack resize must be a positive integer");
		} else {
			values = (T[]) new Object[resizeAmount];
			size = 0;
			this.resizeAmount = resizeAmount;
		}
	}

	/**
	 * Peek at top of stack
	 *
	 * @return Top of stack
	 */
	public T peek() {
                if (isEmpty()) {
                        throw new ListIndexOutOfBoundsException("Cannot peek in an empty stack");
                }
		return values[size - 1];
	}

	/**
	 * Add to stack
	 *
	 * @param val Value to add to stack
	 */
	public void push(T val) {
		if (values.length == size) {
			resizeStack(resizeAmount);
		}
		values[size] = val;
		++size;
	}

	/**
	 * Remove from stack
	 *
	 * @return Removed value
	 */
	public T pop() throws ListIndexOutOfBoundsException {
		T value = null;
		if (isEmpty()) {
			throw new ListIndexOutOfBoundsException("Cannot pop an empty stack");
		} else {
			value = values[--size];
			values[size] = null;
		}
		return value;
	}

	/**
	 * Resize the stack by an amount and will forcibly
	 * prevent any resize that could cause loss of data
	 *
	 * @param  amount Amount to increase/decrease stack by
	 */
	public void resizeStack(int amount) throws IllegalArgumentException {
		int newSize = values.length + amount;
		if (size > newSize) {
			throw new IllegalArgumentException("Stacks cannot be resized beneath their current size");
		}
		if (newSize < 10) {
			newSize = 10;
		}
		T[] newStack = (T[]) new Object[newSize];
		for (int i = 0; i < size; i++) {
			newStack[i] = values[i];
		}
		values = newStack;
	}

	/**
	 * Check if stack is empty
	 *
	 * @return Is stack empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Return pretty string
	 *
	 * @return Formatted string
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < size; i++) {
			builder.append(values[i] + " ");
		}
		builder.insert(0, "Values: ");
		builder.append("\nSize: " + size);
		return builder.toString();
	}
}

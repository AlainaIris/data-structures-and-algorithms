import java.lang.StringBuilder;

public class Queue<T> {
	private T[] values;
	private int size;
	private int resizeAmount = 10;

	public Queue() {
		values = (T[]) new Object[resizeAmount];
		size = 0;
	}

	public Queue(int resizeAmount) {
		if (resizeAmount < 1) {
			throw new IllegalArgumentException("Resize amount must be a positive integer");
		} else {
			values = (T[]) new Object[resizeAmount];
			size = 0;
			this.resizeAmount = resizeAmount;
		}
	}

	/**
	 * Add a value to the queue
	 *
	 * @param  value Value to add
	 */
	public void add(T value) {
		if (size == values.length) {
			resizeQueue(resizeAmount);
		}
		values[size++] = value;
	}

	/**
	 * Remove a value from the queue
	 *
	 * @return Value removed
	 */
	public T remove() {
		if (isEmpty()) {
			throw new ListIndexOutOfBoundsException("Cannot remove from an empty queue");
		} else {
			T value = values[0];
			--size;
			for (int i = 0; i < size; ++i) {
				values[i] = values[i + 1];
			}
			values[size] = null; // Set the extra element null
			return value;
		}
	}

	/**
	 * Peek at the next value in the queue
	 *
	 * @return Next value
	 */
	public T peek() {
		if (isEmpty()) {
			throw new ListIndexOutOfBoundsException("Cannot peek at an empty queue");
		} else {
			return values[0];
		}
	}

	/**
	 * Resize the queue by an amount and makes sure to
	 * prevent operations which would cause data loss
	 *
	 * @param  amount Amount to resize queue by
	 */
	public void resizeQueue(int amount) {
                int newSize = values.length + amount;
                if (size > newSize) {
                        throw new IllegalArgumentException("Queues cannot be resized beneath their current size");
                }
                if (newSize < 10) {
                        newSize = 10;
                }
                T[] newQueue = (T[]) new Object[newSize];
                for (int i = 0; i < size; i++) {
                        newQueue[i] = values[i];
                }
                values = newQueue;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Formatted string
	 *
	 * @return Formatted string
	 */
	public String toString() {
		StringBuilder string = new StringBuilder();
		for (int i = 0; i < size; ++i) {
			string.append(values[i] + " ");
		}
		string.insert(0, "Values: ");
		string.append("\nSize: " + size);
		return string.toString();
	}
}

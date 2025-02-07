public class LinkedList<T> {
	private Node<T> head;
	private int items;

	public LinkedList() {
		head = null;
		items = 0;
	}

	public Node get(int index) {
		Node location = head;
		if (index < items) {
			while (index > 0) {
				location = location.getNext();
				--index;
			}
			return location;
		} else {
			throw new IllegalArgumentException("There is no node at that index");
		}
	}

	public void add(T value) {
		add(new Node<T>(value));
	}

	public void add(Node<T> node) {
		if (node == null) {
			throw new IllegalArgumentException("Cannot add a null node to list");
		}
		if (items == 0) {
			head = node;
		} else {
			Node last = get(items - 1);
			last.setNext(node);
		}
		++items;
	}

	public void insert(int index, Node<T> node) {
		if (index > items) {
			throw new IllegalArgumentException("Cannot insert out of bounds");
		}
		if (index == 0) {
			node.setNext(head);
			head = node;
		} else {
			Node location = head;
			while (index-- > 1) {
				location = location.getNext();
			}
			node.setNext(location.getNext());
			location.setNext(node);
		}
		++items;
	}

	public Node remove(int index) {
		Node removed = null;
		if (index < items) {
			Node location = head;
			boolean isLast = index == items - 1;
			while (index > 1) {
				location = location.getNext();
				--index;
			}
			removed = location.getNext();
			if (isLast) {
				location.setNext(null);
			} else {
				location.setNext(removed.getNext());
			}
			--items;
			return removed;
		} else {
			throw new IllegalArgumentException("There is no item at that index");
		}
	}

	public void reverse() {
		if (items > 2) {
			int reversed = 2;
			Node endpoint = head;
			Node midpoint = endpoint.getNext();
			Node startpoint = midpoint.getNext();
			head.setNext(null);
			while (reversed < items) {
				midpoint.setNext(endpoint);
				endpoint = midpoint;
				midpoint = startpoint;
				startpoint = midpoint.getNext();
				++reversed;
			}
			midpoint.setNext(endpoint);
			head = midpoint;

		} else if (items == 2) {
			Node end = head;
			head = head.getNext();
			head.setNext(end);
			end.setNext(null);
		}
	}

	public void concat(LinkedList<T> list) {
		add(list.getHead());
	}

	public int size() {
		return items;
	}

	public Node getHead() {
		return head;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		Node location = head;
		while (location != null) {
			str.append(location);
			str.append(' ');
			location = location.getNext();
		}
		return str.toString();
	}
}

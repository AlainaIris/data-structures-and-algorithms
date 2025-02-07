public class Tester {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(new Node<Integer>(3));
		list.add(2);
		list.add(1);
		list.add(0);
		list.remove(2);
		System.out.println(list);
		list.reverse();
		System.out.println(list);
	}
}

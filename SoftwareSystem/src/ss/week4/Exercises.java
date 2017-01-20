package ss.week4;

public class Exercises {
	static int[] list;
	static int negative = 0;

	public static int countNegativeNumbers(int[] array) {
		int i = 0;
		for (i = 0; i < array.length; i++) {
			if (array[i] < 0) {
				negative++;
			}

		}
		return negative;
	}

	public static void swap(int[] list, int i, int j) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;

	}

	// TODO: implement, see exercise P-4.1

	public static void reverseArray(int[] ints) {

		// TODO: implement, see exercise P-4.2
		int low = 0;
		int high = ints.length - 1;
		while (low < high) {
			swap(ints, low, high);
			low += 1;
			high -= 1;

		}

	}

	class SimpleList {
		public class Element {
		}

		public class Node {
			public Node next;
			public Element element;
		}

		private Node first;

		private Node find(Element element) {
			Node p = first;
			if (p == null) {
				return null;
			}
			while (p.next != null && !p.next.element.equals(element)) {
				p = p.next;
			}
			if (p.next == null) {
				return null;
			} else {
				return p;
			}
		}

		public void remove(Element element) {
			Node p = find(element);
			if (p != null) {
				p.next = p.next.next;
			}
		}
	}
}

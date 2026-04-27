
package Lab_05;
import java.util.Iterator;

public class PosLinkedListDemo
{
	public static void main(String[] args)
	{
		LinkedPositionalList<Integer> list =
			new LinkedPositionalList();

		Position<Integer> p = list.addFirst(110);

		Position<Integer> q = list.addFirst(20);

		Position<Integer> r = list.addAfter(p, 30);

		Position<Integer> s = list.addBefore(r, 50);

		System.out.println(list);

		Position<Integer> t = list.after(list.after(list.first()));

		System.out.println("Third element: " + t.getElement());

		list.remove(t);

		System.out.println(list);

		System.out.println("====== Element iterator =======");

		//Create ElementIterator
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}

		System.out.println("====== Position iterator =======");

		//Create a position iterator
		Iterator<Position<Integer>> posIter = list.positions().iterator();
		while(posIter.hasNext())
		{
			System.out.println(posIter.next().getElement());
		}

		System.out.println("\n====== Testing positionAtIndex(i) =======");
		
		// Test getting positions at different indices
		System.out.println("Current list: " + list);
		System.out.println("List size: " + list.size());
		
		// Test valid indices
		for (int i = 0; i < list.size(); i++) {
			Position<Integer> pos = list.positionAtIndex(i);
			System.out.println("Element at index " + i + ": " + pos.getElement());
		}
		
		// Test invalid index (out of bounds)
		System.out.println("\nTesting invalid index:");
		try {
			Position<Integer> invalidPos = list.positionAtIndex(10);
			System.out.println("Element at index 10: " + invalidPos.getElement());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Caught expected exception: " + e.getMessage());
		}
		
		// Test negative index
		try {
			Position<Integer> negativePos = list.positionAtIndex(-1);
			System.out.println("Element at index -1: " + negativePos.getElement());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Caught expected exception: " + e.getMessage());
		}
	}
}

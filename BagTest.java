public class BagTest {
	public static void main(String[] args) {
		System.out.println("Creating an empty bag.");
		BagInterface<String> aBag = new DoublyLinkedBag();

		testIsEmpty(aBag, true);
		displayBag(aBag);
		String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D"};
		testAdd(aBag, contentsOfBag);
		testIsEmpty(aBag, false);

		System.out.println("\ngetFrequencyOf method/actual number: ");
		System.out.print("A: " + aBag.getFrequencyOf("A") + "/3 ");
		System.out.print("B: " + aBag.getFrequencyOf("B") + "/1 ");
		System.out.print("C: " + aBag.getFrequencyOf("C") + "/1 ");
		System.out.print("D: " + aBag.getFrequencyOf("D") + "/2 ");
		System.out.println("E: " + aBag.getFrequencyOf("E") + "/0 ");

		System.out.print("\nbag ");
		if(aBag.contains("A")) {
			System.out.print("contains ");
		} else {
			System.out.print("doesn't contain ");
		}
		System.out.println("A.");

		System.out.print("\nbag ");
		if(aBag.contains("E")) {
			System.out.print("contains ");
		} else {
			System.out.print("doesn't contain ");
		}
		System.out.println("E.");
		
		System.out.println("\nRemoving an entry");
		System.out.println("The removed string was: " + aBag.remove());
		displayBag(aBag);
		
		System.out.println("\nRemoving a D");
		System.out.print("The string was ");
		if(aBag.remove("D")) {
			System.out.println("removed ");
		} else {
			System.out.println("not removed ");
		}
		displayBag(aBag);
		
		System.out.println("\nRemoving an E");
		System.out.print("The string was ");
		if(aBag.remove("E")) {
			System.out.println("removed ");
		} else {
			System.out.println("not removed ");
		}
		displayBag(aBag);
		
		System.out.println("\nClearing the bag");
		aBag.clear();
		displayBag(aBag);
		testIsEmpty(aBag, true);
		testAdd(aBag, contentsOfBag);
		
		BagInterface<String> bBag = new DoublyLinkedBag();
		String[] contentsOfBBag = {"A", "D", "B", "A", "E", "A", "D"};
		testAdd(bBag, contentsOfBBag);

		System.out.println("\nBag union test");
		BagInterface<String> uBag = aBag.union(bBag);
		displayBag(uBag);

		System.out.println("\nBag intersect test");
		BagInterface<String> iBag = aBag.intersection(bBag);
		displayBag(iBag);

		System.out.println("\nBag difference test");
		BagInterface<String> dBag = aBag.difference(bBag);
		displayBag(dBag);

	}
	
	public static void testIsEmpty(BagInterface<String> bag, boolean empty) {
		System.out.print("\nTesting isEmpty with ");
		if(empty) {
			System.out.println("an empty bag:");
		} else {
			System.out.println("a bag that isn't empty:");
		}
		System.out.print("isEmpty finds the bag ");
		if(empty && bag.isEmpty()) {
			System.out.println("empty: OK");
		} else if (empty) {
			System.out.println("not empty, but it is: ERROR.");
		} else if(!empty && bag.isEmpty()) {
			System.out.println("empty, but it is not empty: ERROR.");
		} else {
			System.out.println("not empty: OK.");
		}
	}
	
	public static void testAdd(BagInterface<String> aBag, String[] content) {
		System.out.print("Adding the following " + content.length + " strings to the bag: ");
		for(int i = 0; i < content.length; i++) {
			if(aBag.add(content[i])) {
				System.out.print(content[i] + " ");
			} else {
				System.out.print("\nUnable to add " + content[i] + " to the bag.");
			}
		}
		System.out.println();
		displayBag(aBag);
	}
	
	public static void displayBag(BagInterface<String> aBag) {
		System.out.println("The bag contains the following string(s):");
		Object[] bagArray = aBag.toArray();

		for(int i = 0; i < bagArray.length; i++) {
			System.out.print(bagArray[i] + " ");
		}
		System.out.println();
	}
	
}

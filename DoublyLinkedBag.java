

public class DoublyLinkedBag<T> implements BagInterface<T> {
	private DoublyLinkedNode<T> firstNode;
	private int numberOfEntries;

	public class DoublyLinkedNode<S> {
		public S data;
		private DoublyLinkedNode next;
		private DoublyLinkedNode prev;
	
		public DoublyLinkedNode(S dataPortion) {
			this(dataPortion, null, null);
		}
	
		public DoublyLinkedNode(S dataPortion, DoublyLinkedNode nextNode) {
			this(dataPortion, nextNode, null);
		}

		public DoublyLinkedNode(S dataPortion, DoublyLinkedNode nextNode, DoublyLinkedNode prevNode) {
			data = dataPortion;
			next = nextNode;
			prev = prevNode;
		}

		public S getData() {
			return data;
		}

		public void setData(S newData) {
			data = newData;
		}

		public DoublyLinkedNode getNextNode() {
			return next;
		}

		public void setNextNode(DoublyLinkedNode nextNode) {
			next = nextNode;
		}

		public DoublyLinkedNode getPrevNode() {
			return prev;
		}

		public void setPrevNode(DoublyLinkedNode prevNode) {
			prev = prevNode;
		}
	
	}
	
	public DoublyLinkedBag(){
		firstNode = null;
		numberOfEntries = 0;
	}

	public int getCurrentSize(){
		return numberOfEntries;
	}

	public boolean isEmpty(){
		return firstNode == null;
	}
	
	public boolean add(T newEntry){
		DoublyLinkedNode newNode = new DoublyLinkedNode(newEntry);
		if(firstNode != null) {
			firstNode.setPrevNode(newNode);
			newNode.setNextNode(firstNode);
		}
		firstNode = newNode;
		numberOfEntries++;
		return true;
	}

	public T remove() {
		T data = null;
		if(firstNode != null) {
			data = (T)firstNode.data;
			firstNode = firstNode.getNextNode();
			numberOfEntries--;
		}
		return data;
	}
	
	public DoublyLinkedNode getReferenceTo(T anEntry) {
		boolean found = false;
		DoublyLinkedNode currNode = firstNode;
		while(!found && (currNode != null)) {
			if(anEntry.equals(currNode.data)) {
				found = true;
			} else {
				currNode = currNode.getNextNode();
			}
		}
		return currNode;
	}

	public boolean remove(T anEntry) {
		boolean done = false;
		DoublyLinkedNode nodeN = getReferenceTo(anEntry);
		if(nodeN != null) {
			nodeN.data = firstNode.data;
			firstNode = firstNode.getNextNode();
			numberOfEntries--;
			done = true;
		}
		return done;
	}
	
	public void clear() {
		while(!isEmpty()) {
		remove();
		}
	}
	
	public int getFrequencyOf(T anEntry) {
		DoublyLinkedNode currNode = firstNode;
		int count = 0;
		while((currNode != null) && (count < numberOfEntries)) {
			if(anEntry.equals(currNode.getData())) {
				count++;
			}
			currNode = currNode.getNextNode();
		}
		return count;
	}
	
	public boolean contains(T anEntry) {
		DoublyLinkedNode currNode = firstNode;
		boolean has = false;
		while((currNode != null) && !has) {
			if(anEntry.equals(currNode.getData())) {
				has = true;
			}
			currNode = currNode.getNextNode();
		}
		return has;
	}

	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] list = (T[])new Object[numberOfEntries];
		DoublyLinkedNode currNode = firstNode;
		for(int i = 0; (i < numberOfEntries) && (currNode != null); i++) {
			list[i] = (T)currNode.data;
			currNode = currNode.getNextNode();
		}
		return list;
	}
	
	public DoublyLinkedNode getFirstNode() {
		return firstNode;
	}
	
	public BagInterface<T> union(BagInterface<T> anotherBag) {
		DoublyLinkedBag uBag = new DoublyLinkedBag();
		DoublyLinkedNode currNode = firstNode;
		while(currNode != null) {
			uBag.add((T)currNode.getData());
			currNode = currNode.getNextNode();
		}
		T data = anotherBag.remove();
		while(data != null) {
			uBag.add(data);
			data = anotherBag.remove();
		}
		return uBag;
	}
	
	public BagInterface<T> intersection(BagInterface<T> anotherBag) {
		DoublyLinkedBag iBag = new DoublyLinkedBag();
		T data;
		while(!anotherBag.isEmpty()){
			data = anotherBag.remove();
			if(this.contains(data) && (data != null)) {
				iBag.add(data);
			}
		}
		return iBag;
	}
	
	public BagInterface<T> difference(BagInterface<T> anotherBag) {
		DoublyLinkedBag dBag = new DoublyLinkedBag();
		DoublyLinkedNode currNode = firstNode;
		T data;
		for(int i = 0; i < numberOfEntries; i++){
			data = (T)currNode.getData();
			if(!anotherBag.contains(data)) {
				dBag.add(currNode.getData());
			}
		}
		return dBag;
	}
}

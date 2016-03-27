import java.util.NoSuchElementException;

public class DoublyLinkedNode<T> {
	public T data;
	private DoublyLinkedNode next;
	private DoublyLinkedNode prev;

	public DoublyLinkedNode(T dataPortion) {
		this(dataPortion, null, null);
	}
	
	public DoublyLinkedNode(T dataPortion, DoublyLinkedNode nextNode) {
		this(dataPortion, nextNode, null);
	}

	public DoublyLinkedNode(T dataPortion, DoublyLinkedNode nextNode, DoublyLinkedNode prevNode) {
		data = dataPortion;
		next = nextNode;
		prev = prevNode;
	}

	public T getData() {
		return data;
	}

	public void setData(T newData) {
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

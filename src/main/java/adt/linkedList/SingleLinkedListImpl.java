package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> auxHead = head;
		while (!auxHead.isNIL()){
			size+=1;
			auxHead = auxHead.next;
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxHead = head;
		System.out.println(head.toString());
		while (!auxHead.isNIL() && auxHead.getData() != element){
			auxHead = auxHead.next;
		}
		return auxHead.getData();
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> auxHead = head;
		if (head.isNIL()){
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<>();
			newHead.setData(element);
			newHead.setNext(head);
			head = newHead;
		}else {
			while (!auxHead.isNIL()){
				auxHead = auxHead.next;
			}
			auxHead.setData(element);
			auxHead.setNext(new SingleLinkedListNode<>());
		}
	}

	@Override
	public void remove(T element) {
		if (head.getData() == element){
			head = head.next;
		} else {
			SingleLinkedListNode<T> auxHead = head;
			while (!auxHead.isNIL() && auxHead.getData() != element){
				auxHead = auxHead.next;
			}
			if (!auxHead.isNIL()){
				auxHead.data = auxHead.next.data;
				auxHead.next = auxHead.next.next;
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> auxHead = head;
		int i = 0;
		while (!auxHead.isNIL()){
			array[i++] = auxHead.getData();
			auxHead = auxHead.next;
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}

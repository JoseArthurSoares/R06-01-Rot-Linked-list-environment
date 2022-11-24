package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl(){
		this.last = new DoubleLinkedListNode<>();
		super.head = new DoubleLinkedListNode<>();
	}
	@Override
	public void insertFirst(T element) {
		if(element != null) {
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(element, (DoubleLinkedListNode<T>) super.head, new DoubleLinkedListNode<>());

			if (isEmpty()){
				super.head = newNode;
				this.last = newNode;
			} else {
				newNode.setNext(super.head);
				((DoubleLinkedListNode<T>) super.head).setPrevious(newNode);
				super.head = newNode;
			}
		}
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element,new DoubleLinkedListNode<T>(), last);
			last.setNext(newNode);
			if(last.isNIL()) {
				head = newNode;
			}
			last = newNode;
		}
	}

	@Override
	public void removeFirst() {
		if (super.head.getNext().isNIL()){
			super.head = new DoubleLinkedListNode<>();
			this.last = new DoubleLinkedListNode<>();
		} else {
			super.head = super.head.getNext();
			((DoubleLinkedListNode<T>) super.head).setPrevious(new DoubleLinkedListNode<>());
		}
	}

	@Override
	public void removeLast() {
		if (this.last.getPrevious().isNIL()){
			super.head = new DoubleLinkedListNode<>();
			this.last = new DoubleLinkedListNode<>();
		} else {
			this.last = this.last.getPrevious();
			this.last.setNext(new DoubleLinkedListNode<>());
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}

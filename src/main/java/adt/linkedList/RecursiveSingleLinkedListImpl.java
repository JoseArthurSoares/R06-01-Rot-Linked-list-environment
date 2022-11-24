package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		if (isEmpty()){
			return 0;
		} else {
			return 1 + next.size();
		}
	}

	@Override
	public T search(T element) {
		if (isEmpty()) return null;
		if (this.data.equals(element)){
			return this.data;
		}else {
			return this.next.search(element);
		}
	}

	@Override
	public void insert(T element) {
		if (isEmpty()){
			this.data = element;
			this.next = new RecursiveDoubleLinkedListImpl<>();
		} else {
			this.next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (isEmpty()) return;
		if (data.equals(element)){
			this.data = next.getData();
			this.next = this.next.getNext();
		}else {
			this.next.remove(element);
		}
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}

package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insertFirst(T element) {
		if (!(element == null)){
			if (isEmpty()){
				super.insert(element);
			} else {
				RecursiveDoubleLinkedListImpl newElement = new RecursiveDoubleLinkedListImpl();
				newElement.setData(super.data);
				newElement.setNext(super.next);
				super.setData(element);
				super.setNext(newElement);
			}
			this.previous = new RecursiveDoubleLinkedListImpl<>();
		}
	}

	@Override
	public void removeFirst() {
		if (!super.isEmpty()){
			super.setData(super.getNext().getData());
			super.setNext(super.getNext().getNext());
		}
	}

	@Override
	public void removeLast() {
		if (super.size() <= 1) {
			this.removeFirst();
		}else {
			Rlast(super.next);
		}
	}

	private void Rlast(RecursiveSingleLinkedListImpl<T> next) {
		if (!next.getNext().isEmpty()) {
			Rlast(next.getNext());
		} else {
			next.setNext(null);
			next.setData(null);
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}

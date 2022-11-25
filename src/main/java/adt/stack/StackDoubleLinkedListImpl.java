package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;


public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()) throw new StackOverflowException();
		if (!(element == null)){
			this.top.insert(element);
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) throw new StackUnderflowException();
		T pop = this.top();
		this.top.removeLast();
		return pop;
	}

	@Override
	public T top() {
		if (isEmpty()) return null;
		T[] array = this.top.toArray();
		return array[array.length - 1];
	}

	@Override
	public boolean isEmpty() {
		return this.top.size() == 0;
	}

	@Override
	public boolean isFull() {
		System.out.println("top size: " + this.top.size());
		System.out.println("size: " + this.size);
		return this.top.size() == this.size;
	}

}

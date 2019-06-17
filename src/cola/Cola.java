package cola;

import lista.EmptyListException;

public interface Cola<E> {
	public E dequeue();
	public void enqueue(E e);
	public boolean isEmpty();
}

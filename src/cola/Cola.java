package cola;

import lista.Position;

public interface Cola<E> {
	public E dequeue();
	public void enqueue(E e);
}

package cola;

import lista.*;

public class ColaImp<E> implements Cola<E> {
	private PositionList<E> lista;

	public ColaImp<E>() {
		lista = new ListaDoble<E>();
	}

	@Override
	public E dequeue() {
		return lista.remove(list.first());
	}

	@Override
	public void enqueue(E e) {
		lista.addLast(e);
	}
}
package cola;

import lista.*;

public class ColaImp<E> implements Cola<E> {
	private PositionList<E> lista;

	public ColaImp<E>() {
		lista = new ListaDoble<E>();
	}

	@Override
	public E dequeue() throws EmptyListException {
		return lista.remove(lista.first());
	}

	@Override
	public void enqueue(E e) {
		lista.addLast(e);
	}
}
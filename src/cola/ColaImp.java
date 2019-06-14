package cola;

import lista.*;

public class ColaImp<E> implements Cola<E> {
	private PositionList<E> lista;

	public ColaImp() {
		lista = new ListaDoble<>();
	}

	@Override
	public E dequeue() {
		try {
			return lista.remove(lista.first());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void enqueue(E e) {
		lista.addLast(e);
	}
}
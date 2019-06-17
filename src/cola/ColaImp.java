package cola;

import lista.*;

public class ColaImp<E> implements Cola<E> {
	private PositionList<E> lista;
	private int size;

	public ColaImp() {
		lista = new ListaDoble<>();
		size = 0;
	}

	@Override
	public E dequeue() {
		try {
			size--;
			return lista.remove(lista.first());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void enqueue(E e) {
		lista.addLast(e);
		size++;
	}

	public boolean isEmpty(){
		return size==0;
	}
}
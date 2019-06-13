package lista;
import java.lang.Exception;

public class EmptyListException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyListException() {
		super("La lista esta vacia.");
	}
}

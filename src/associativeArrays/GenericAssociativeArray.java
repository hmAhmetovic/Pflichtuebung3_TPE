package associativeArrays;

import associativeArrays.AssociativeArray;
import associativeArrays.GenericAssociativeArray.Node;

public class GenericAssociativeArray<Key, Val> implements
		AssociativeArray<Key, Val> {

	/**
	 * Klasse 'Node' zum erstellen von Knoten. Jeder Knoten hat einen Wert,
	 * Schlüssel und zwei Kinder.
	 * 
	 * @author TPE Gruppe 14
	 *
	 * @param <Key>
	 * @param <Val>
	 */
	private class Node<Key, Val> {

		// Schlüssel
		private Key key;
		// Wert
		private Val value;
		// linkes Kind
		private Node<Key, Val> left;
		// rechtes Kind
		private Node<Key, Val> right;

		// Konstruktor
		public Node(Key key, Val value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}

		/*
		 * Methoden
		 */
		private Val getValue() {
			return value;
		}

		private void setValue(Val value) {
			this.value = value;
		}

		private Key getKey() {
			return key;
		}

		private void setKey(Key key) {
			this.key = key;
		}

		private Node<Key, Val> getLeft() {
			return left;
		}

		private void setLeft(Node<Key, Val> left) {
			this.left = left;
		}

		private Node<Key, Val> getRight() {
			return right;
		}

		private void setRight(Node<Key, Val> right) {
			this.right = right;
		}

	}

	// Wurzel des Baums
	private Node<Key, Val> root;

	// Konstruktor
	public GenericAssociativeArray(Key key, Val value) {
		this.root = new Node<Key, Val>(key, value);
	}

	@Override
	public void clear() {
		// Wurzel löschen, damit den gesamten Baum
		this.root = null;

	}

	@Override
	public boolean containsValue(Val value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(Key key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Val get(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// Gibt es eine Wurzel ist der Baum nicht leer
		if (root != null) {
			return true;
			// Falls es keine Wurzel gibt, gibt es auch keinen Baum
		} else {
			return false;
		}
	}

	@Override
	public void put(Key key, Val value) {

		Node<Key, Val> actualNode = this.root;
		// erstelle Schlüssel-Wert-Paar mit übergebenem Schlüssel und Wert
		Node<Key, Val> putNode = new Node<Key, Val>(key, value);
		putNode(putNode, actualNode);
	}

	private void putNode(Node<Key, Val> putNode, Node<Key, Val> actualNode) {

		// Wenn übergebener Schlüssel kleiner ist als Schlüssel vom aktuellen
		// Knoten suche links
		if (actualNode.hashCode() > putNode.hashCode()) {
			if (actualNode.getLeft() == null) {
				// Wenn linker Knoten frei setze Schlüssel-Wert-Paar
				actualNode.setLeft(putNode);
			} else {
				// Prüfe linken Knoten (rekursiver Aufruf)
				putNode(putNode, actualNode.getLeft());
			}

			
		// Wenn übergebener Schlüssel größer ist als Schlüssel vom aktuellen
		// Knoten suche rechts
		} else if (actualNode.hashCode() < putNode.hashCode()) {
			if (actualNode.getRight() == null) {
				actualNode.setRight(putNode);
			} else {
				putNode(putNode, actualNode.getRight());
			}
		}

		/*
		 * Wenn Hashwert des übergebenen Schlüssels gleich mit einem Schlüsssel
		 * im Baum ist soll das übergebene Schlüssel-Wert-Paar verworfen werden
		 */

	}




	@Override
	public Val remove(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Val key, Val value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void forEach() {
		// TODO Auto-generated method stub

	}

	@Override
	public void putAll(associativeArrays.AssociativeArray.Node<Key, Val> tree) {
		// TODO Auto-generated method stub
		
	}



	

}

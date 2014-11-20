package associativeArrays;

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
	private class Node<Key, Val> implements Comparable {

		// Schlüssel
		private Key key;
		// Wert
		private Val value;
		// linkes Kind
		private Node<Key, Val> left;
		// rechtes Kind
		private Node<Key, Val> right;
		// Elternknoten
		private Node<Key, Val> parent;

		// Konstruktor
		public Node(Key key, Val value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
			this.parent = null;
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

		private Node<Key, Val> getParent() {
			return parent;
		}

		private void setParent(Node<Key, Val> parent) {
			this.parent = parent;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

		private GenericAssociativeArray getOuterType() { // ???
			return GenericAssociativeArray.this;
		}

		@Override
		public int compareTo(Object other) {
			return this.key.hashCode() - ((Node) other).key.hashCode();
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
		Node<Key, Val> actualNode = this.root;

		return containsValueRek(value, actualNode);

	}
	//wrapper Methode  zum erweitern der Parameter
	private boolean containsValueRek(Val value, Node<Key, Val> actualNode) {

		// baum ist leer?
		if (actualNode == null) {
			return false;
		}

		// aktueller value ist gleich gesuchter value ?
		if (actualNode.value == value) {
			return true;
		}

		// geht den kommpletten baum durch
		return containsValueRek(value, actualNode.left)
				|| containsValueRek(value, actualNode.right);

	}

	public int size(Val value) {

		return sizeRek(value, this.root);
	}

	private int sizeRek(Val value, Node<Key, Val> actualNode) {

		// baum ist leer?
		if (actualNode == null) {
			return 0;
		}

		return 1 + sizeRek(value, actualNode.left)
				+ sizeRek(value, actualNode.right);

	}

	@Override
	public boolean containsKey(Key key) {
		return containsKey(key, this.root);
		
	}
	
	
	
	private boolean containsKey(Key key, Node<Key, Val> actualNode) {

		// baum ist leer?
		if (actualNode == null) {
			return false;
		}

		// aktueller key ist gleich gesuchter key ?
		if (actualNode.key == key) {
			return true;
		}

		// key ist größer
		if (actualNode.key.hashCode() < key.hashCode()) {

			// rechter Ast leer ?
			if (actualNode.right == null) {
				return false;
				// geh in den rechten Ast
			} else {
				return containsKey(key, actualNode.right);
			}

			// key ist kleiner
			// linker Ast leer
		} else if (actualNode.left == null) {
			return false;
		} else {
			// geh in den linken Ast
			return containsKey(key, actualNode.left);
		}

	}
	
	
	

	@Override
	public Val get(Key key) {

		return getRek(key, this.root);
	}

	private Val getRek(Key key, Node<Key, Val> actualNode) {

		// baum ist leer?
		if (this.isEmpty()) {
			return null;
		}

		// aktueller key ist gleich gesuchter key ?
		if (actualNode.key == key) {
			return actualNode.value;
		}

		// key ist größer
		if (actualNode.key.hashCode() < key.hashCode()) {

			// rechter Ast leer ?
			if (actualNode.right == null) {
				return null;
				// geh in den rechten Ast
			} else {
				return getRek(key, actualNode.right);
			}

			// key ist kleiner
			// linker Ast leer
		} else if (actualNode.left == null) {
			return null;
		} else {
			// geh in den linken Ast
			return getRek(key, actualNode.left);
		}

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

		// erstelle Schlüssel-Wert-Paar mit übergebenem Schlüssel und Wert
		Node<Key, Val> putNode = new Node<Key, Val>(key, value);
		putRek(putNode, this.root);
	} 

	private void putRek(Node<Key, Val> putNode, Node<Key, Val> actualNode) {

		// Wenn übergebener Schlüssel kleiner ist als Schlüssel vom aktuellen
		// Knoten suche links
		if (actualNode.hashCode() > putNode.hashCode()) {
			if (actualNode.getLeft() == null) {
				// Wenn linker Knoten frei setze Schlüssel-Wert-Paar
				actualNode.setLeft(putNode);
				putNode.setParent(actualNode);
			} else {
				// Prüfe linken Knoten (rekursiver Aufruf)
				putRek(putNode, actualNode.getLeft());
			}

			// Wenn übergebener Schlüssel größer ist als Schlüssel vom aktuellen
			// Knoten suche rechts
		} else if (actualNode.hashCode() < putNode.hashCode()) {
			if (actualNode.getRight() == null) {
				actualNode.setRight(putNode);
				putNode.setParent(actualNode);
			} else {
				putRek(putNode, actualNode.getRight());
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

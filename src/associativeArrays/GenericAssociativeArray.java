package associativeArrays;
//Wird für den BiConsumer und BiFunction benötigt
import java.util.function.*;

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
	public static class Node<Key, Val> implements Comparable {

		// Schlüssel
		protected Key key;
		// Wert
		protected Val value;
		// linkes Kind
		protected Node<Key, Val> left;
		// rechtes Kind
		protected Node<Key, Val> right;
		// Elternknoten
		protected Node<Key, Val> parent;

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
		protected Val getValue() {
			return value;
		}

		protected void setValue(Val value) {
			this.value = value;
		}

		protected Key getKey() {
			return key;
		}

		protected void setKey(Key key) {
			this.key = key;
		}

		protected Node<Key, Val> getLeft() {
			return left;
		}

		protected void setLeft(Node<Key, Val> left) {
			this.left = left;
		}

		protected Node<Key, Val> getRight() {
			return right;
		}

		protected void setRight(Node<Key, Val> right) {
			this.right = right;
		}

		protected Node<Key, Val> getParent() {
			return parent;
		}

		protected void setParent(Node<Key, Val> parent) {
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

		private GenericAssociativeArray<Key,Val> getOuterType() { // ???
			return GenericAssociativeArray.this;
		}

		@Override
		public int compareTo(Object other) {
			return this.getKey().hashCode() - ((Node) other).getKey().hashCode();
		}

	}

	// Wurzel des Baums
	protected Node<Key, Val> root;

	// Konstruktor
	public GenericAssociativeArray(Key key, Val value) {
		this.root = new Node<Key, Val>(key, value);
	}

	@Override
	public void clear() {
		// Wurzel null setzen damit ist gesamter Baum leer
		this.root = null;

	}

	@Override
	public boolean containsValue(Val value) {
		Node<Key, Val> actualNode = this.root;

		return containsValueRek(value, actualNode);

	}

	// wrapper Methode zum erweitern der Parameter
	private boolean containsValueRek(Val value, Node<Key, Val> actualNode) {

		// Es gibt keine weiteren Kinderknoten
		if (actualNode == null) {
			return false;
		}

		// Wenn aktueller Knoten den gesuchten Wert enthält return true
		if (actualNode.value == value) {
			return true;
		}

		// sucht den gesamten Baum rekursiv ab (preorder)
		return containsValueRek(value, actualNode.getLeft())
				|| containsValueRek(value, actualNode.getRight());

	}

	@Override
	public int size() {
		return sizeRek(this.root);
	}

	private int sizeRek(Node<Key, Val> actualNode) {

		// Es gibt keine weiteren Kinderknoten
		if (actualNode == null) {
			return 0;
		}

		// summiert alle Knoten im Baum mit Rekursion
		return 1 + sizeRek(actualNode.getLeft()) + sizeRek(actualNode.getRight());

	}

	@Override
	public boolean containsKey(Key key) {
		return containsKey(key, this.root);

	}

	private boolean containsKey(Key key, Node<Key, Val> actualNode) {

		// Es gibt keine weiteren Kinderknoten
		if (actualNode == null) {
			return false;
		}

		// Wenn aktueller Knoten gesuchten Key enthält return true
		if (actualNode.getKey()== key) {
			return true;
		}

		// Wenn gesuchter Key größer ist als Key vom aktuellen Knoten
		if (actualNode.getKey().hashCode() < key.hashCode()) {

			// Wenn rechter Ast leer ist
			if (actualNode.getRight() == null) {
				return false;
				// suche weiter im rechten Ast
			} else {
				return containsKey(key, actualNode.right);
			}

			// Wenn gesuchter Key kleiner ist als Key vom aktuellen Knoten

			// Wenn linker Ast leer ist
		} else if (actualNode.getLeft() == null) {
			return false;
			// suche weiter im linken Ast
		} else {
			return containsKey(key, actualNode.left);
		}

	}

	@Override
	public Val get(Key key) {

		return getRek(key, this.root);
	}

	private Val getRek(Key key, Node<Key, Val> actualNode) {

		// Wenn Baum leer ist return null
		if (this.isEmpty()) {
			return null;
		}

		// Wenn Key in einem Knoten gefunden wurde return Wert des Knoten
		if (actualNode.key == key) {
			return actualNode.value;
		}

		// Wenn gesuchter Key größer ist als key vom aktuellen Knoten
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
			// ist die Wurzel null ist der Baum leer
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

		Val value;
		// Wenn Wert im Baum vorhanden ist
		if (containsKey(this.root.getKey()) == true) {
			value = get(key);
			if (this.root.getKey() == key) {
				removeRoot(this.root);
			} else {
				removeNodeRek(this.root, key);
			}
			// Wert ist nicht vorhanden , null
		} else {
			value = null;
		}
		return value;
	}
	
	
	private void removeNodeRek(Node<Key, Val> actualNode, Key key) {

		if (actualNode.getKey() == key) {
			
			
			if(actualNode.getKey() == actualNode.getParent().getLeft().getKey()){
				Node<Key, Val> setRight = actualNode.getRight();
			// Löschen des Knoten durch Verbinden des Elternknotens mit dem
			// Kindknoten des gelöschten Knoten
			actualNode.getParent().setLeft(actualNode.getLeft());
			actualNode.getParent().getLeft().setRight(setRight);
			} else {
			// Kindknoten des gelöschten Knoten
				Node<Key, Val> setLeft = actualNode.getLeft();
			actualNode.getParent().setRight(actualNode.getRight());
			actualNode.getParent().getRight().setLeft(setLeft);
			}
			
			
		} else {
			// Key ist größer als key vom aktuellen Knoten gehe rechts
			if (actualNode.getKey().hashCode() < key.hashCode()) {
				removeNodeRek(actualNode.getRight(), key);
				// Key ist kleiner als key vom aktuellen Knoten gehe links
			} else {
				actualNode.getLeft().setParent(actualNode);
				removeNodeRek(actualNode.getLeft(), key);
			}

		}
	}

	/**
	 * RemoveRoot() entfernt die Wurzel in einem binären Baum und fügt einen
	 * neuen Baum zusammen
	 * 
	 * @param root
	 */
	private void removeRoot(Node<Key, Val> root) {

		// Wenn Wurzel einziger Knoten ist leere Baum
		if (size() <= 1) {
			clear();

			// Falls Teilbäume zusammengefügt werden müssen
		} else {
			// Wenn Teilbäume nicht leer füge Teilbäume zusammen
			if (this.root.getRight() != null && this.root.getLeft() != null) {
				assembleNewTree(this.root.getLeft(), this.root.getRight());

				// Rechter Teilbaum ist leer, neuer Baum ist linker Teilbaum
			} else if (this.root.getRight() == null
					&& this.root.getLeft() != null) {
				this.root = this.root.getLeft();

				// Linker Teilbaum ist leer, neuer Baum ist rechter Teilbaum
			} else {
				this.root = this.root.getRight();
			}
		}
	}

	/**
	 * assembleNewTree() fügt den linken Teilbaum an das am weitesten links
	 * stehende Element im rechten Teilbaum an
	 * 
	 * @param leftSubTree
	 * @param rightSubTree
	 */
	private void assembleNewTree(Node<Key, Val> leftSubTree,
			Node<Key, Val> rightSubTree) {

		// Suche das letzte linke Element im rechten Teilbaum
		if (rightSubTree.getLeft() != null) {
			assembleNewTree(leftSubTree, rightSubTree.getLeft());
		}

		// Füge den linken Teilbaum an den am weitesten links stehenden Knoten
		// im rechten Teilbaum an
		rightSubTree.setLeft(leftSubTree);

		// Neuer Baum
		this.root = rightSubTree;
	}

	@Override
	public void update(Key key, Val value) {
		// Wenn Key vorhanden ist soll Update ausgeführt werden
		if(containsKey(key) == true)
			updateRek(this.root, key, value);
	}

	private void updateRek(Node<Key,Val> actualNode, Key key, Val value){
		
		// Wenn Knoten gefunden, update value
		if(actualNode.getKey()==key){
			actualNode.setValue(value);
			
		/*
		 * sucht im linken oder rechten Teilbaum nach dem gesuchten Knoten
		 */
		} else if(actualNode.getKey().hashCode() < key.hashCode()){
			updateRek(actualNode.getRight(), key, value);
		} else {
			updateRek(actualNode.getLeft(), key, value);
		}
	}
	
    @Override
    public void forEach(BiConsumer<?, ?> biConsumer){
        Node<Key, Val> actualNode = this.root;
        //Leerer baum?
        if(this.root != null ){
            forEach(this.root,biConsumer);
        }//else{
            //biConsumer.accept(null, null); Was passiert bei einem Leeren Baum
        //}
    }
    //Methode zur Rekursiven implemntierung von forEach()
    private void forEach(Node<Key,Val> actualNode,BiConsumer biconsumer){
        //Linker teilbaum zuerst durchlaufen  
        if(actualNode.getLeft() != null){
            forEach(actualNode.getLeft(),biconsumer);
        }
        //Übergebenen BiConsumer anwenden
        biconsumer.accept(actualNode.getValue(), actualNode.getKey());
        //Rechter Teilbaum durchlaufen  
        if(actualNode.getRight() != null){
            forEach(actualNode.getRight(),biconsumer);
        }
        
    }
	@Override
	public void putAll(GenericAssociativeArray <Key, Val> tree) {
		// TODO Auto-generated method stub
		
		if(tree != null){
			extractAllRek(tree.root, this.root);
		}
	}

	@Override
	public void extractAll(GenericAssociativeArray<Key, Val> tree) {
		if(this.root != null){
			// extractAll nur andersrum
			extractAllRek(this.root, tree.root);
		}
		
	}
	
	private void extractAllRek(Node<Key,Val> extractThis, Node<Key, Val> tree){
		if(extractThis == null){
			
		}else{
			
			// Zwischenspeicher für den Aktuellen Knoten der übergeben werden soll
			Node<Key, Val> temp = new Node<Key,Val>(extractThis.getKey(),extractThis.getValue());
			
			// fügen Knoten in den anderen Baum ein
			putRek(temp, tree);
			
			// geht Rekursiv den ganzen Baum durch
			extractAllRek(extractThis.getLeft(), tree);
			extractAllRek(extractThis.getRight(), tree);
		}
		
		this.root = null;
	}
	   @Override
	    public GenericAssociativeArray map(BiFunction biFunction) {
	        //
	        Node<Key, Val> actualNode = this.root;
	        //neues Array
	        GenericAssociativeArray array = null;
	        
	        
	        
	        
	        
	        
	        return array;
	    }
	    
	    private void map(Node<Key,Val> actualNode,BiFunction biFunction,GenericAssociativeArray array){
	          
	        
	        
	    }
}

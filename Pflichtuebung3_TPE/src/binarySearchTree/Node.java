package binarySearchTree;

/**
 * Klasse Node zur Erstellung von Knoten. Ein Knoten hat einen Schlüssel, Wert und 2 Kinderknoten(links,rechts)
 * @author TPE Gruppe 14
 *
 * @param <Key>
 * @param <T>
 */
public class Node<Key, T> {

	// Attribute eines Knotens
	private Key key;
	private T value;
	private Node<Key, T> left;
	private Node<Key, T> right;
	
	// Konstruktor
	public Node(Key key, T value, Node<Key, T> left, Node<Key, T> right) {
		
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	// Getters & Setters Node
	public Key getKey(){
		return this.key;
	}
	public void setKey(Key key) {
		this.key = key;
	}

	
	public T getValue(){
		return this.value;
	}
	public void setValue(T value) {
		this.value = value;
	}

	
	public Node<Key, T> getLeft(){
		return this.left;
	}
	public void setLeft(Node<Key, T> left) {
		this.left = left;
	}

	
	public Node<Key, T> getRight(){
		return this.right;
	}
	public void setRight(Node<Key, T> right) {
		this.right = right;
	}
	
	
	
	
}

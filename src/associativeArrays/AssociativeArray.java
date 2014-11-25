package associativeArrays;

import associativeArrays.GenericAssociativeArray.Node;
//Wird für den BiConsumer und BiFunction benötigt
import java.util.function.*;




/**
 * Interface 'AssociativeArray' mit den Methoden zum Verwalten eines assiozativen Arrays
 * @author TPE Gruppe 14
 *
 * @param <T>
 */
public interface AssociativeArray<K,T> {

	
	
	/**
	 * clear() leert das assoziative Array
	 */
	public void clear();
	
	/**
	 * containsValue(T value) prüft ob ein übergebener Wert im Array vorhanden ist
	 * @param value
	 * @return boolean
	 */
	public boolean containsValue(T value);
	
	/**
	 * containsKey(T key) prüft ob ein übergebener Schlüssel im Array vorhanden ist
	 * @param key
	 * @return boolean
	 */
	public boolean containsKey(K key);
	
	/**
	 * get(Key key) gibt den Wert an der Stelle des übergebenen Schlüssels zurück
	 * @param key
	 * @return boolean
	 */
	public T get(K key);
	
	/**
	 * isEmpty() prüft ob das Array leer ist
	 * @return boolean
	 */
	public boolean isEmpty();
	
	/**
	 * put(T key, T value) speichert übergebenen Schlüssel und Wert im Array
	 * @param key
	 * @param value
	 */
	public void put(K key, T value);
	
	/**
	 * putAll(Node<Key,Val) fügt alle Schlüssel-Wert Paare zum assiozativen Array hinzu
	 * @param pairs
	 */
	public void putAll(GenericAssociativeArray<K, T> tree);
	
	/**
	 * remove(T key) entfert das Schlüssel-Wert Paar des übergebenen Schlüssels und gibt den Wert zurück
	 * @param key
	 * @return T
	 */
	public T remove(K key);
	
	/**
	 * size() gibt die Anzahl der Schlüssel-Wert Paare in einem assiozativem Array zurück
	 * @return int
	 */
	public int size();
	
	/**
	 * update() ändert den Wert an der Stelle des übergebenen Schlüssels mit dem übergebenen Wert
	 * @param key
	 * @param value
	 */
	public void update(K key, T value);
	
	/**
	 * extractAll() fügt alle aktuellen Schlüssel-Wert-Paare zum übergebenen assoziativen Array hinzu
	 * @param tree
	 */
	public void extractAll(GenericAssociativeArray<K,T> tree);
	
	/**
	 * forEach(BiConsumer<?, ?> biConsumer) Wendet einen übergebenen BiConsumer 
	 * auf alle Schlüssel-Wert-Paare an
	 * @param biConsumer
	 */
	public void forEach(BiConsumer<?, ?> biConsumer);
	   /**
     * GenericAssociativeArray map(BiFunction<?, ?, ?> biFunction) Wendet eine übergebene BiFunction 
     * auf alle Schlüssel-Wert-Paare an und erzeugt ein neues assoziatives Array mit den veränderten  
     * Schlüssel-Wert-Paaren
     * @param biFunction
     * @return
     */
    public GenericAssociativeArray<?,?> map(BiFunction<?, ?, ?> biFunction);//Vom typ <?,?> oder <k,T> 
}

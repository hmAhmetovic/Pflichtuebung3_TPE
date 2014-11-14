package associativeArrays;

/**
 * Interface 'AssociativeArray' mit den Methoden zum Verwalten eines assiozativen Arrays
 * @author TPE Gruppe 14
 *
 * @param <T>
 */
public interface AssociativeArray<T> {

	/**
	 * clear() leert das assoziative Array
	 */
	public void clear();
	
	/**
	 * containsValue(T value) pr�ft ob ein �bergebener Wert im Array vorhanden ist
	 * @param value
	 * @return boolean
	 */
	public boolean containsValue(T value);
	
	/**
	 * containsKey(T key) pr�ft ob ein �bergebener Schl�ssel im Array vorhanden ist
	 * @param key
	 * @return boolean
	 */
	public boolean containsKey(T key);
	
	/**
	 * get(T key) gibt den Wert an der Stelle des �bergebenen Schl�ssels zur�ck
	 * @param key
	 * @return T
	 */
	public T get(T key);
	
	/**
	 * isEmpty() pr�ft ob das Array leer ist
	 * @return boolean
	 */
	public boolean isEmpty();
	
	/**
	 * put(T key, T value) speichert �bergebenen Schl�ssel und Wert im Array
	 * @param key
	 * @param value
	 */
	public void put(T key, T value);
	
	/**
	 * putAll(T pairs[]) f�gt alle Schl�ssel-Wert Paare zum assiozativen Array hinzu
	 * @param pairs
	 */
	public void putAll(T pairs[]);
	
	/**
	 * remove(T key) entfert das Schl�ssel-Wert Paar des �bergebenen Schl�ssels und gibt den Wert zur�ck
	 * @param key
	 * @return T
	 */
	public T remove(T key);
	
	/**
	 * size() gibt die Anzahl der Schl�ssel-Wert Paare in einem assiozativem Array zur�ck
	 * @return int
	 */
	public int size();
	
	/**
	 * update(T key, T value) �ndert den Wert an der Stelle des �bergebenen Schl�ssels mit dem �bergebenen Wert
	 * @param key
	 * @param value
	 */
	public void update(T key, T value);
	
	//BICONSUMER????
	public void forEach();
}

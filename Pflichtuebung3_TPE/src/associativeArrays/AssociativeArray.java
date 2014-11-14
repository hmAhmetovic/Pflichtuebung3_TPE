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
	public boolean containsKey(T key);
	
	/**
	 * get(T key) gibt den Wert an der Stelle des übergebenen Schlüssels zurück
	 * @param key
	 * @return T
	 */
	public T get(T key);
	
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
	public void put(T key, T value);
	
	/**
	 * putAll(T pairs[]) fügt alle Schlüssel-Wert Paare zum assiozativen Array hinzu
	 * @param pairs
	 */
	public void putAll(T pairs[]);
	
	/**
	 * remove(T key) entfert das Schlüssel-Wert Paar des übergebenen Schlüssels und gibt den Wert zurück
	 * @param key
	 * @return T
	 */
	public T remove(T key);
	
	/**
	 * size() gibt die Anzahl der Schlüssel-Wert Paare in einem assiozativem Array zurück
	 * @return int
	 */
	public int size();
	
	/**
	 * update(T key, T value) ändert den Wert an der Stelle des übergebenen Schlüssels mit dem übergebenen Wert
	 * @param key
	 * @param value
	 */
	public void update(T key, T value);
	
	//BICONSUMER????
	public void forEach();
}

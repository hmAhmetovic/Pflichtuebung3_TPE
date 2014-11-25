package associativeArrays;

public class Dictionary extends GenericAssociativeArray<String, String> {

	public Dictionary(String key, String value) {
		super(key, value);
		// TODO Auto-generated constructor stub
	}

	/**
	 * keys() läuft das Dictionary in Preorder ab und speichert alle Schlüssel
	 * der Knoten in ein Array ab
	 * 
	 * @return String[]
	 */
	public String[] keys() {

		// String Array mit Größe von Anzahl der Knoten im Baum
		String keyArray[] = new String[size() - 1];

		keysRek(keyArray, this.root, 0);

		return keyArray;
	}

	private void keysRek(String[] keyArray, Node<String, String> node, int count) {

		if (node == null) {

		} else {
			// speichere Schlüssel in das Array
			keyArray[count] = node.getKey();

			/*
			 * Rekursive Preorder Aufrufe
			 */
			keysRek(keyArray, node.getLeft(), count + 1);
			keysRek(keyArray, node.getRight(), count + 1);
		}
	}

	/**
	 * values() läuft das Dictionary in Preorder ab und speichert alle Werte
	 * der Knoten in ein Array ab
	 * 
	 * @return String[]
	 */
	public String[] values() {

		// String Array mit Größe von Anzahl der Knoten im Baum
		String valueArray[] = new String[size() - 1];

		valuesRek(valueArray, this.root, 0);

		return valueArray;
	}

	private void valuesRek(String[] valueArray, Node<String, String> node,
			int count) {

		if (node == null) {

		} else {
			// speichere Schlüssel in das Array
			valueArray[count] = node.getValue();

			/*
			 * Rekursive Preorder Aufrufe
			 */
			valuesRek(valueArray, node.getLeft(), count + 1);
			valuesRek(valueArray, node.getRight(), count + 1);
		}
	}

}

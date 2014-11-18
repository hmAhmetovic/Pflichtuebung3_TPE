package associativeArrays;

public class GenericAssociativeArray<Key,Val> implements AssociativeArray<Key,Val> {
	
	
	private class Node{
		
		private Val value;
		private Key key;
		private Node<Key,Val> left;
		private Node<Key,Val> right;
		
		public Node(Val value, Key key){
			this.value = value;
			this.key = key;
			this.left = null;
			this.right = null;
		}
		
		
		
		
		
	}

	
	
}

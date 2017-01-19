
public class DoublyLinkedListGeneric <data>{
	public class Node {
		private data item;
		private Node nextLink;
		private Node prevLink;
		
		public Node() {
			this.item = null;
			this.nextLink = null;
			this.prevLink = null;
		}
		
		public Node(data anItem)
		{
			this.item = anItem;
			this.nextLink = null;
			this.prevLink = null;
		}
		
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

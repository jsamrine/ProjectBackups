//import IntDoubleLinkedList.Node;


public class IntDoubleLinkedListTester {

	public static void main(String[] args) {
		IntDoubleLinkedList list = new IntDoubleLinkedList();
		
		for(int i=0;i<10;i++)
		{
			list.insert(i);
			System.out.println(list.getDataAtCurrent());
		}
		
		list.showList();
		
		System.out.println();
		
		for(int i=0;i<4;i++)
		{
			list.goToNext();
		}
		
		list.insertNodeAfterCurrent(22);
		list.showList();
		System.out.println();
		
		list.reset();		
		for(int i=0;i<6;i++)
		{
			list.goToNext();
		}
		list.deleteCurrentNode();
		list.showList();

	}
}
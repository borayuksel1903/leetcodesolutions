public class Test{
	public static void main(String[] args){
		List list1 = new List();
		List list2 = new List();
		
		list1.insert(2);
		list1.insert(4);
		list1.insert(3);

		list2.insert(5);
		list2.insert(6);
		list2.insert(4);

		List result = List.addTwoNumbers(list1, list2);

		result.writeList();
	}
}

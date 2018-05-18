public class List{
	public Node front;
	public int occupancy;

	public List(){
		front = null;
		occupancy = 0;
	}

	public void insert(int data){
		Node working = new Node(data);

		Node.insertNode(this, working);
		occupancy++;
	}

	public int reverseOrder(){
		Node working = this.front.pre;
		int result = working.getData();
		working = working.pre;

		while(working != this.front.pre){
			result = (result * 10) + working.getData();
			working = working.pre;
		}

		return result;
	}

	public void intToList(int sum){
		while(sum != 0){
			int remainder = sum % 10;
			sum /= 10;

			this.insert(remainder);
		}
	}

	public static List addTwoNumbers(List list1, List list2){
		List result = new List(); 
		
		int sum = list1.reverseOrder() + list2.reverseOrder();

		result.intToList(sum);
		
		return result;	
	}

	public void writeList(){
		Node working = this.front; 
		
		while(working != this.front.pre){
			System.out.print(working.getData() + " -> ");
			working = working.next;
		}
		System.out.println(working.getData());
	}
}

public class Node{
	private int data; 
	public Node next;
	public Node pre;

	public Node(int data){
		this.data = data; //stores the data inside the Node
		next = this; //sets nextNode to null
		pre = this; //sets preNode to null
	}


	public int getData(){
		return this.data;
	}

	public void setData(int data){
		this.data = data;
	}

	public static void insertNode(List list, Node node){
		if(list.front == null)
			list.front = node;
		else{
			Node working = list.front;
			
			//attach the node
			node.pre = list.front.pre;
			node.next = list.front;

			//integrate the node
			node.pre.next = node;
			list.front.pre = node;
		}			
	}
}

public class Node{
	private int data; //to store the digit inside the node 
	public Node next; //pointer to the previous node
	public Node pre; //pointer to the next node
   
	/**
	 * Description: constructor that takes in an integer to store inside the
	 * 				 node. Pre and next pointers point to null.
	 *
	 * @param: int data- data to store inside the node
	 */
	public Node(int data){
		this.data = data; //stores the data inside the Node
		next = null; //sets nextNode to null
		pre = null; //sets preNode to null
	}

   
	/**
	 * Description: getter method that gets the private data field from the
	 * 				 calling object
	 *
	 * @return: int- the integer stored in the data field
	 */
	public int getData(){
		return this.data; //returns the data field
	}

	/**
	 * Description: setter method that sets the data field of the calling
	 * 				 object
	 *
	 * @param: int data- the new data to be stored inside node
	 */
	public void setData(int data){
		this.data = data; //sets data field to the input int
	}

	/**
	 * Description: inserts the node to the list by attaching and integrating the
	 * 				 node the list at the end of the list
	 *
	 * @param: List list- list to insert the new node in to
	 */
	public void insertNode(List list){
		//checks if list is empty
		if(list.front == null){
			//front points to the new node
			list.front = this;

			//pre and next pointers point to the node to be inserted
			this.pre = this.next = this;
		}
		//otherwise, attach and integrate with the other nodes
		else{
			Node working = list.front;
			
			//attach the node
			this.pre = list.front.pre;
			this.next = list.front;

			//integrate the node
			this.pre.next = this;
			list.front.pre = this;
		}			
	}
} //end of Node class

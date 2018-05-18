/**
 * Class description: creates a new Circular List, where Nodes are connected to
 * each other through pointers. 
 */
public class List{
	public Node front; //pointer that points to the first node
	public int occupancy; //occupancy of the list

	/**
	 * Description: constructor that creates a new empty list
	 */
	public List(){
		front = null; //sets front pointer to null
		occupancy = 0; //initializes occupancy to 0
	}
   
	/**
	 * Description: takes in an integer to store inside the Node, creates a new
	 * 				 Node with the data, inserts the Node. 
	 *
	 * @param: int data- data to be stored inside the lis by a Node
	 */
	public void insert(int data){
		Node working = new Node(data); //creates a new Node with the data stored 

		working.insertNode(this); //inserts the node to the list
		occupancy++; //increments occupancy
	}
   
	/**
	 * Description: creates a new number with the elements of the List in a
	 * 				 reverse order. i.e. 3->4->5 becomes the integer 543
	 *
	 * @return: int- the number that was resulted from the list
	 */
	public int reverseOrder(){
		Node working = this.front.pre; //starts from the last Node in the List
		int result = working.getData(); //gets the data stored in the last Node
		working = working.pre; //moves back a Node
      
		//loops through each Node in the List
		while(working != this.front.pre){
			//creates a new number throught the data from the Nodes
			result = (result * 10) + working.getData();
			working = working.pre;
		}

		return result; //returns the number created
	}

	/**
	 * Description: inserts each number from the input integer into the List in a
	 * 				 reverse order
	 *
	 * @param: int sum- integer to convert to a List
	 */
	public void intToList(int sum){
		//loops through each number in input
		while(sum != 0){
			int remainder = sum % 10; //gets the last element from the input
			sum /= 10; //deletes the last number from the input

			this.insert(remainder); //inserts the last element to the List
		}
	}

	/**
	 * Description: takes in two circular linked Lists and adds the data stored
	 * 				 inside their Nodes in the reverse order. Then, creates a new
	 * 				 List with the new sum, each integer stored in a reverse order
	 *
	 * @param: List list1- first List to get the number from
	 * @param: List list2- second List to get the number from
	 * @return: List- List containing the sum stored in reverse order
	 */
	public static List addTwoNumbers(List list1, List list2){
		List result = new List(); //creates a new List to store the sum
		
		//calculates the sum from the input Lists
		int sum = list1.reverseOrder() + list2.reverseOrder();

		result.intToList(sum); //converts the sum into a new List
		
		return result;	//returns the List
	}
   
	/**
	 * Description: writes the List on the terminal
	 */
	public void writeList(){
		Node working = this.front; //stores the front Node from List
		
		//loops through each Node and prints data from each Node
		while(working != this.front.pre){
			System.out.print(working.getData() + " -> ");
			working = working.next;
		}
		System.out.println(working.getData()); //prints data from last Node
	}
}

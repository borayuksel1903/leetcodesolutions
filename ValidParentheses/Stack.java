import java.io.*;
import java.util.*;

public class Stack{
	private int pointer_index; //next available index
	private char[] array; //stack array
	private int size; //size of stack

	/**
	 * Description: constructor that creates a new empty Stack
	 *
	 * @param: int size- size of the Stack
	 */
	public Stack(int size){
		array = new char[size]; //creates a new array of size the input int
		pointer_index = 0; //sets poinetr index to 0
		this.size = size; //sets size to the input size
	}
   
	/**
	 * Description: constructor that creates a new Stack with the input array
	 *
	 * @param: char[] chars- char array to store in the Stack
	 */
	public Stack(char[] chars){
		//deep copies the input array into the array field of Stack object
		array = new char[chars.length];
		for(int index = 0; index < chars.length; index++){
			array[index] = chars[index];
		}
		pointer_index = chars.length; //pointer index points to last index + 1
		size = chars.length; //size is equal to the length of the input array
	}

	/**
	 * Description: checks if the Stack is empty
	 * 
	 * @return: true if it is, false if not
	 */
	public boolean isempty_Stack(){
		//checks if the stack exists
		if(this == null){
			System.err.println("NON-EXISTENT STACK");
			return false;
		}

		//if pointer index is 0, stack is empty
		if(pointer_index == 0)
			return true;

		return false; //otherwise stack is not empty
	}

	/**
	 * DescriptionL checks if the Stack is full
	 *
	 * @return: true if it is, false if not
	 */
	public boolean isfull_Stack(){
		//checks if the stack exists
		if(this == null){
			System.err.println("NON-EXISTENT STACK");
			return false;
		}

		//if pointer index points to size, stack is full
		if(pointer_index == size)
			return true;

		return false; //otehrwise stack is not full
	}
	
	/**
	 * Description: removes the last element from teh Stack and saves it to the
	 * 				 input Stack
	 *
	 * @param: Stack popped- where the popped element will be stored
	 * @return: true if successful popping, false if not
	 */
	public boolean pop(Stack popped){
		//checks if the stack exists
		if(this == null){
			System.err.println("POPPING FROM NONEXISTENT STACK");
			return false;
		}
		//checks if the stack is not empty
		else if(isempty_Stack()){
			System.err.println("POPPING FROM AN EMPTY STACK");
			return false;
		}

		//stores the last item in the stack and removes it
		popped.push(array[pointer_index - 1]);
		array[--pointer_index] = 0;

		return true; //successful popping
	}

	/**
	 * Description: pushes the input item to the calling Stack
	 *
	 * @param: char item- element to add to the Stack
	 * @return: true if successfully inserted, false if failed
	 */
	public boolean push(char item){
		//checks if the stack exists
		if(this == null){
			System.err.println("PUSHING TO A NONEXISTENT STACK");
			return false;
		}
		//checks if the stack is full
		else if(isfull_Stack()){
			System.err.println("PUSHING TO A FULL STACK");
			return false;
		}

		//stores the item at the last available index
		array[pointer_index++] = item;

		return true; //successful pushing
	}

	/**
	 * Description: checks if the input parentheses are valid or not
	 *
	 * @param: Stack popped- to store the popped values
	 * @return: true if input is valid, false if not
	 */
	public boolean validParentheses(Stack popped){
		Stack garbage = new Stack(1000);
		//if the last character in string is a open parentheses, return false;
		if(array[pointer_index-1] == '[' || array[pointer_index-1] == '(' || 
				array[pointer_index-1] == '{')
			return false;
		else if(isempty_Stack())
			return true;
		else if(pointer_index == 1)
			return false;

		//checks if parantheses match
		while(!isempty_Stack()){
			//pops the element from the last index if it is '}'
			if(array[pointer_index-1] == '}')
				pop(popped);
			//pops the element from the last index if it is ']'
			else if(array[pointer_index-1] == ']')
				pop(popped);
			//pops the element from the last index if it is ')'
			else if(array[pointer_index-1] == ')')
				pop(popped);
			//otherwise compares the elements with the popped ones
			else{
				//checks if '}' is matched with a '{'
				if(popped.array[popped.pointer_index - 1] == '}'){
					if(array[pointer_index-1] == '{'){
						pop(garbage);
						popped.pop(garbage);
					}
					else
						return false;
				}
				//checks if ']' is matched with a '['
				else if(popped.array[popped.pointer_index-1] == ']'){
					if(array[pointer_index-1] == '['){
						pop(garbage);
						popped.pop(garbage);
					}
					else
						return false;
				}
				//checks if ')' is matched with a '('
				else if(popped.array[popped.pointer_index - 1] == ')'){
					if(array[pointer_index-1] == '('){
						pop(garbage);
						popped.pop(garbage);
					}
					else
						return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args){
		Scanner test = new Scanner(System.in);

		Stack stack; 
		Stack popped = new Stack(1000);
		while(true){
			System.out.print("Please enter parentheses for validation: ");
			String validation = test.next();
			stack = new Stack(validation.toCharArray());
			boolean result = stack.validParentheses(popped);
			if(result)
				System.out.println("Valid Parentheses!");
			else
				System.out.println("Invalid Parentheses. Learn how parentheses work.");
		}
	}
	
	

} //end of Stack class

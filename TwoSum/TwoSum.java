public class TwoSum{

	/**
	 * Description: returns a new array containing the indices of the numbers
	 * from the input array that add up to target
	 *
	 * @param: int[] input- array that contains the numbers to find the indices
	 * 							from
	 * @param: int target- the target sum of the two numbers from the array
	 * @return: int[]- array containing the indices of the numbers
	 */
	public static int[] findNumbers(int[] input, int target){
		int[] solution = new int[2]; //array to store the indices 
		int index1 = 0; //to save index1
		int index2 = 0; //to save index2
		
		//loops through each element and its sum with other elements
		for(int i = 0; i < input.length; i++){
			for(int j = 1; i+j < input.length; j++){
				//checks if sum is equal to target
				if((input[i] + input[j+i]) == target){
					//saves the indices
					index1 = i;
					index2 = i+j;
				}
			}
		}
      
		//stores the indices inside solution array
		solution[0] = index1;
		solution[1] = index2;

		return solution; //returns the array containing the soltuion
	}

	public static void main(String[] args){	
		int[] test = {2, 7, 11, 15};
		int[] answer = findNumbers(test, 26);
		for(int i = 0; i < answer.length; i++)
			System.out.print(answer[i] + " ");
		System.out.print("\n");	
	}
}

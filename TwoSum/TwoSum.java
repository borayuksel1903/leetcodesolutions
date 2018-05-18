public class TwoSum{
	public static int[] findNumbers(int[] input, int target){
		int[] solution = new int[2];
		int index1 = 0;
		int index2 = 0;
		
		for(int i = 0; i < input.length; i++){
			//for(int j = i; j < input.length; j++){
			//	index1 = j;
				for(int j = 1; i+j < input.length; j++){
					if((input[i] + input[j+i]) == target){
						index1 = i;
						index2 = i+j;
					}
				}
			//}
		}
		solution[0] = index1;
		solution[1] = index2;

		return solution;
	}

	public static void main(String[] args){	
		int[] test = {2, 7, 11, 15};
		int[] answer = findNumbers(test, 26);
		for(int i = 0; i < answer.length; i++)
			System.out.print(answer[i] + " ");
		System.out.print("\n");	
	}
}

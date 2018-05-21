public class LongestSubstring{
	/**
	 * Description: finds the length of the longest substring in the input
	 * 				 string
	 * 
	 * @param: String input- the input to find the longest substring from
	 * @return: int- the length of the longest substring
	 */
	public static int longestSubstring(String input){
		String sub = ""; //to save each substring 
		int result = 0; //initializes result to 0
		sub += input.charAt(0); //adds first letter to sub String
		
		//loops through each letter and compares it to the letters in sub
		for(int i = 1; i < input.length(); i++){
			for(int j = 0; j < sub.length(); j++){
				//if the letter matches any letter in sub exists there
				if(input.charAt(i) == sub.charAt(j))
					break;
				sub += input.charAt(j); //otherwise adds it to sub
			}
			//if sub's length is greater than previous result, changes result
			if(result < sub.length())
				result = sub.length();
			sub = ""; //resets sub to an empty string to try with a new substring
		}

		return result; //returns the longest substring
	}

	public static void main(String[] args){
		String test = "abcabcabc";
		String test2 = "bbbbb";
		String test3 = "pwwkew";
		
		System.out.println(longestSubstring(test));
		System.out.println(longestSubstring(test2));
		System.out.println(longestSubstring(test3));
	}
} //end of class

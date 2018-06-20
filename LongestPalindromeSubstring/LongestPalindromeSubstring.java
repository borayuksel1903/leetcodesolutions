public class LongestPalindromeSubstring{
	public static boolean isPalindrome(String s, int beg, int end){
		//checks if we compared each character
		if(beg >= end)
			return true;
		//checks if teh character at the beginning and end are the same
		else if(s.charAt(beg) == s.charAt(end))
			return isPalindrome(s, beg+1, end-1); //compare the next chars
		//otherwise not a palindrome
		else
			return false;
	}

	public static String subStr(String s, int beg, int end){
		String result = ""; //to save the resultant substring

		//loops through each char within the limit
		for(int i = beg; i < end; i++){
			result += s.charAt(i); //add chars to the result
		}

		return result; //return the substring
	}
	
	public static String longestPalindromeSubstring(String s){
		String result = ""; //to save the resultant substring
		int length = s.length(); //input strings length

		//loops through each character in the input string
		for(int i = 0; i < length; i++){
			//loops through the rest of the characters in the input string 
			for(int j = 0; i+j < length; j++){
				//checks if there is a palindrome in the substrings
				if(isPalindrome(s, i, i+j)){
					//saves the substring that makes a palindrome
					String toCompare = subStr(s, i, i+j+1);

					//if result has a smaller length, replaces it
					if(result.length() < toCompare.length())
						result = toCompare;
				}
			}
		}

		return result; //returns the longest paliindrome substring
	}
	
	public static void main(String[] args){
		System.out.println("--- Testing isPalindrome ---");
		String test1 = "racecar";
		String test2 = "bcb";
		String test3 = "bb";
		String test4 = "ba";

		//test case 1
		if(isPalindrome(test1, 0, test1.length()-1))
			System.out.println("Test Passed for " + test1);
		else
			System.out.println("Test Failed for " + test1);
		
		//test case 2
		if(isPalindrome(test2, 0, test2.length()-1))
			System.out.println("Test Passed for " + test2);
		else
			System.out.println("Test Failed for " + test2);
		
		//test case 3
		if(isPalindrome(test3, 0, test3.length()-1))
			System.out.println("Test Passed for " + test3);
		else
			System.out.println("Test Failed for " + test3);
		
		//test case 4
		if(!isPalindrome(test4, 0, test4.length()-1))
			System.out.println("Test Passed for " + test4);
		else
			System.out.println("Test Failed for " + test4);

		System.out.println("\n--- Testing longestPalindromeSubstring ---");
		String test5 = longestPalindromeSubstring("babad");
		String test6 = longestPalindromeSubstring("cbbd");

		//test case 5
		if(test5.equals("bab") || test5.equals("aba"))
			System.out.println("Test Passed for 'babad'");
		else{
			System.out.println("Test Failed for 'babad'");
			System.out.println("Correct answer: bab or aba");
			System.out.println("Your answer: " + test5);
		}
		
		//test case 6
		if(test6.equals("bb"))
			System.out.println("Test Passed for 'cbbd'");
		else{
			System.out.println("Test Failed for 'cbbd'");
			System.out.println("Correct answer: bb");
			System.out.println("Your answer: " + test6);
		}
	}
}

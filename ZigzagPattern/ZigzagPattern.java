public class ZigzagPattern{
	public static String convert(String s, int numRows){
		int[][] arr = new int[numRows][7];

	}
	
	public static void main(String[] args){
		System.out.println("--- Testing convert ---");
		String test = "PAYPALISHIRING";

		if(convert(test, 3).equals("PAHNAPLSIIGYIR"))
			System.out.println("Test 1 Passed");
		else
			System.out.println("Test 1 Failed");

		if(convert(test, 4).equals("PINALSIGYAHRPI"))
			System.out.println("Test 2 Passed");
		else
			System.out.println("Test 2 Failed");
	}
}

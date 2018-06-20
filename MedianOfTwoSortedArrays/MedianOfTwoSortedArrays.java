public class MedianOfTwoSortedArrays{
	public static double medianOfTwoArrays(int[] nums1, int[] nums2){
		//puts the arrays together in a new array in a sorted manner
		int[] resultArr = new int[nums1.length + nums2.length];
		int midPoint = resultArr.length / 2;
		double result = 0.0; //initializes result to 0
		int count1 = 0; //keeps track of place in array 1
		int count2 = 0; //keeps track of place in array 2

		//puts the numbers from both arrays in a sorted way to the new array
		for(int i = 0; i < resultArr.length; i++){
			//checks if we traversed through each number in first array
			if(count1 >= nums1.length && count2 < nums2.length)
				resultArr[i] = nums2[count2]; //assigns number from second array

			//checks if we traversed through each number in second array
			else if(count2 >= nums2.length && count1 < nums1.length)
				resultArr[i] = nums1[count1]; //assigns number from first array

			//compares the numbers from both arrays
			else if(nums1[count1] < nums2[count2]){
				//adds number from array 1 if it is smaller
				resultArr[i] = nums1[count1];
				count1++; //increments count1 to keep track of where we are
			}

			else{
				//adds number from array 2 since it is smaller or equal
				resultArr[i] = nums2[count2];
				count2++; //increments count2 to keep track of where we are
			}
		}
		
		//checks if the length of the result array is even
		if(resultArr.length % 2 == 0)
			//finds the average of the numbers in the middle
			result = (resultArr[midPoint] + resultArr[midPoint-1])/2.0;
		else
			//otherwise finds the number in the middle
			result = resultArr[midPoint];

		return result; //returns the median
	}

	public static void main(String[] args){
		int[] nums1Test1 = {1, 3};
		int[] nums2Test1 = {2};
		System.out.println(medianOfTwoArrays(nums1Test1, nums2Test1));

		int[] nums1Test2 = {1, 2};
		int[] nums2Test2 = {3, 4};
		System.out.println(medianOfTwoArrays(nums1Test2, nums2Test2));
	}
}	

package tests.java.practice1;

import org.junit.Test;

public class Practice1 {

	
	@Test
	public void test() {
//		System.out.println(removeElement((new int[] {3,2,2,3}), 3));
//		System.out.println(searchInsert(new int[] {1,3,5,7}, 3));
		System.out.println(searchInsert(new int[] {1,3,5,7}, 4));
	}
	
	 public static int removeElement(int[] nums, int val) {
	        int counter = 0;
	        int arrayCount = nums.length;
	        for(int i = 0; i < arrayCount; i++)
	        {
	            if(nums[i] != val)
	            {
	            	nums[counter] = nums[i];
	                counter++;
	            }
	        }
			return counter;
	    }
	 
	 public int searchInsert(int[] nums, int target) {
	        for(int i = 0; i<nums.length; i++)
	        {
	            if(nums[i] == target)
	            {
	            	return i;
	            }
	            else if(target<nums[i])
	            {
	            	return i;
	            }
	            	            	
	        }
	        return nums.length;
	    }
}

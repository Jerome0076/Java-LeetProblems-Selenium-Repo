package tests.java.week1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class Day2Practice {

	@Test
	public void findSingleNumberTest()
	{
		int[] array = {1,1,2,2,3};
		System.out.println("Single Number in the array is "+singleNumber(array));
	}
	
	@Test
    public void countXandXplusOne() 
	{
    	int[] array = {1,2,2,2,3,4,5,1,1};
    	int count = countXandX1(array);
		System.out.println("The counted value of x and x+1 is " +count);
	 }
	
	@Test
	public void majorityElementTest()
	{
		int[] array = {1,2,2,2,1,1,1};
		System.out.println("The majority element in the array is "+majorityElement(array));
	}
	
	@Test
	public void countOnes()
	{
		int[] array = {0,0,0,0,1,1,1,1};
		System.out.println("The number 1 element in the array is "+countOne(array));
	}
	
	
	 public static int countXandX1(int[] array)
	    {
	    	Set<Integer> set = new HashSet<>();
	        for(int num : array)
	        {
	            set.add(num);
	        }
	        int count = 0;
	        for(int i=0; i< array.length; i++)
	        {
	            if(set.contains(array[i]+1))
	            {
	                count++;
	            }
	        }
	        return count;
	    }
	 
//		    Using HashSet
//		    Use for each loop to iterate within the array
//		    check if the current value is unable to add in set, if so remove the number.
//		    print the set
	    public int singleNumber(int[] nums) {
	        int singlevalue = 0;
	        HashSet<Integer> set = new HashSet<Integer>();
	        for(int num : nums)
	        {
	            if(!set.add(num))
	            {
	                set.remove(num);
	            }
	            
	        }
	      return set.iterator().next();  
	    }
		
	    
	    public int majorityElement(int[] nums) {
	        //Initialize a Map for storing majority
	        // 
	        Map<Integer, Integer> map = new HashMap<>();

	        for(int num : nums)
	        {
	            if(map.containsKey(num))
	            {
	                map.put(num, map.get(num)+1);
	            }
	            else
	            {
	                map.put(num,1);
	            }
	        }
	        int majorityElement = 0;
	        int maxCount = 0;

	        // Find the element with the maximum count
	        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	            if (entry.getValue() > maxCount) {
	                maxCount = entry.getValue();
	                majorityElement = entry.getKey();
	            }
	        }
	        return majorityElement;
	    }
	 
	    public static int countOne(int[] array)
		{
			int count = 0;
			for(int num : array)
			{
				if(num == 1)
				{
					count++;
				}
			}
			return count;
		}
		
}
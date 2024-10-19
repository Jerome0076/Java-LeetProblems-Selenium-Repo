package tests.java.week2;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Day4Practice {	


	@Test
	public void moveZeroTest()
	{
		int[] array = {1,2,3,0,0,2,1,0};
		System.out.println(Arrays.toString(moveZeros(array)));
		System.out.println(Arrays.toString(moveZeros(new int[] {1,2,3,4,0,0,4,0,5,0,6})));
		System.out.println(Arrays.toString(moveZeros(new int[] {0,0,4,0,5,0,0})));
	}
	
	@Test
	public void twoSumTest()
	{
		int[] array = {1,2,3,0,0,2,1,0};
		int target = 5;
		int[] result = twoSum(array, target);
		System.out.println("twoSumTest - The value is for sum is "+result[0]+ " and " +result[1]);
	}
	
	@Test
	public void isPowerofThree()
	{
		System.out.println(isPowerOfThree(27));
		System.out.println(isPowerOfThree(0));
		System.out.println(isPowerOfThree(-1));
		System.out.println("Test "+isPowerOfThree(24));
	}
	
	@Test
	public void sortedSquares()
	{
		System.out.println(Arrays.toString(sortedSquares(new int[] {-4,-1,0,3,10})));
		System.out.println(Arrays.toString(sortedSquares(new int[] {-7,-3,2,3,11})));
	}
	
	@Test
	public void climbStairs()
	{
		System.out.println(climbStairs(0));
		System.out.println(climbStairs(4));
		System.out.println(climbStairs(7));
		System.out.println(climbStairs(17));
	}
	
	@Test
	public void aliceCandyTest()
	{
		System.out.println(distributeCandies(new int[] {1,1,3,3,4,4}));
		System.out.println(distributeCandies(new int[] {1,1,3,3,4,0,5,3,2}));
		System.out.println(distributeCandies(new int[] {1,1,3,3,0,0,1,4,5,9}));
	}
	
	/*
	 * Move Zeros Program
	 * Ex: 0, 1, 0, 3, 12 --> 1, 3, 12, 0, 0
	 * 
	 * 1. Initialize an index variable
	 * 2. Iterate through each element in array
	 * 3. Compare each element with 0
	 * 4. If current is not 0,
	 * 		a. take that element and put in the first index
	 * 		b. increment current index
	 * 5. Iterate from current index till end of array
	 * 6. assign the current value with 0
	 * 7. increment the current index
	 *  
	 * 1, 1, 0, 3, 12
	 * 1, 3, 0, 3, 12
	 * 1, 3, 12, 3, 12
	 * 1, 3, 12, 0, 12
	 * 1, 3, 12, 0, 0
	 * 
	 */
	public int[] moveZeros(int[] array)
	{
		int index = 0;
		for(int i=0; i<=array.length-1; i++)
		{
			if(array[i] != 0)
				
			{
				array[index] = array[i];
				index++;
			}
		}
		for(int i = index; i<=array.length-1; i++)
		{
		array[i] = 0;	
		}
		return array;
	}
	
	
	/*
	 * Two Sum
	 * Ex: input = [2, 4, 6, 8]
	 * 		target = 10
	 * 1. Initialize a map
	 * 2. Iterate through the array
	 * 3. Get the difference of the current number from the target
	 * 4. If the difference is present in the map as key,
	 * 		a. return current index, index of difference from map
	 * 5. Put the key as the current element and value as it's index
	 * 6. if no matching target, return -1, -1
	 */
	public static int[] twoSum(int[] array, int targetSum)
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		int arrayLength = array.length;	 
		for(int i=0; i<arrayLength; i++)
		{
			int diffValue = targetSum - array[i];
			if(map.containsKey(diffValue))
			{
				return new int[]{array[map.get(diffValue)], array[i]}; 
			}
			map.put(array[i], i);
		}
		return null;
	}
	
	
	/*Homework Problem 1 - isPowerOfThree
	 * inputs n = 27, n=0, n=-1
	 * 
	 * Have conditions to check if the given value in negative
	 * check if the given value is greater than 1
	 * using while condition (n is not divisible by 3) return false
	 * n = n/3 and complete the loop return true
	 */
	public boolean isPowerOfThree(int n) {
        if(n<1 || n==0)
        {
            return false;
        }
        while(n>1){
        if(n%3!=0)
        {
            return false;     
        }
        n = n/3;
        }
        return true;
    }
	
	/*
	 * Homework Problem 2 - sortedSquares
	 * Get the length of the input array
	 * Iterate thoughout the array values one by one
	 * multiply the same value with the same and store it in the same array index of the iteration
	 * Return the array
	 */
	public static int[] sortedSquares(int[] array)
	{
		int arrayLength = array.length;
		for(int i=0; i<arrayLength; i++)
		{
			array[i] = array[i] * array[i];
		}
		Arrays.sort(array);
		return array;
	}
	
	/*
	 * Homework Problem 3 - climbstairs
	 * Inputs int n = 2, 3, 9, 0
	 * Using fibonacci scenario solve the problem
	 */
	public static int climbStairs(int n)
	{
		if(n==0 || n==1) return 1;
		
		return climbStairs(n-1) + climbStairs(n-2);
	}
	
	/*
	 * Homework Problem 4 - Alice Candies - 575 LeetCode
	 * Alice is allowed to eat only n/2 number of candies
	 * 
	 * Given an integer array, Get the length of the int array and use formula n/2
	 * return the result
	 */
	public static int distributeCandies(int[] candyType) 
	{
		int length = candyType.length/2;
        Set<Integer> uniqueCandy = new HashSet<Integer>();
		for(int eachCandy : candyType)
		{
			uniqueCandy.add(eachCandy);
		}
		int candyCount = uniqueCandy.size();
        if(candyCount<=length)
        {
            return candyCount;
        }
        else
        {
            return length;
        }
    }
}

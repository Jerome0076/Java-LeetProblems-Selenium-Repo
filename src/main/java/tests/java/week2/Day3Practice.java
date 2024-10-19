package tests.java.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Day3Practice {
	
	@Test
	public void countOne()
	{
		int[] array = {0,0,0,1,1,1,1};
		System.out.println(countOne(array));
	}
	
	@Test
	public void removeTargetElement()
	{
		int[] array = {0,0,0,1,1,1,1,3,4,5,6};
		int target = 6;
		removeTargetElement(array, target);
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

	
	//Remove the Target element from an array
	//Positive Case = {1,2,3,4,5,7,8}, target = 7
	//Negative Case = {1,2,3,4,5,7,8}, target = 9
	//Edge Case = {}
	//Convert the given array to list
	//remove the taget element
	//convert list back to array
	//print the output of array		
	public static void removeTargetElement(int[] array, int targetValue)
	{
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<array.length; i++)
		{
			if(array[i] == targetValue) continue;
			else
			{
				list.add(array[i]);
			}
		}
		System.out.println(list.toString());
	}
		
	public static int arrangeCoins(int n)
	{
		int rows = 1;
		while(n == 0)
		{
			rows++;
			n = n-1;
		}
		return rows-1;
	}
	
	
	
}

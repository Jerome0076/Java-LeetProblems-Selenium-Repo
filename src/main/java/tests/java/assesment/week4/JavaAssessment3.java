package tests.java.assesment.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class JavaAssessment3 {
/*
 * Program1: Find first and last position of element in sorted array Given an array of integers nums sorted in non-decreasing order, 
 * find the starting and ending position of a given target value. 
 * If target is not found in the array, return [-1, -1]. 
 * Example 1: Input: nums = {5,7,7,8,8,10}, target = 8 Output: {3,4} 
 * Example 2: Input: nums = {5,7,7,8,8,10}, target = 6 Output: [-1,-1] 
 * Example 3: Input: nums = [], target = 0 Output: [-1,-1] 
 * Example4: Input: nums = {5,6,7,7,8,8,10}, target = 6 Output: [1,1] 
 * 
 * 
 * Program2: Longest Common Prefix Write a function to find the longest common prefix string amongst an array of strings. 
 * If there is no common prefix, 
 * return an empty string "". 
 * Example 1: Input: strs = ["flower","flow","flight"] 
 * Output: "fl" 
 * Example 2: Input: strs = ["dog","racecar","car"] Output: "" 
 * Explanation: There is no common prefix among the input strings. 
 * 
 * 
 * Program3: Anagram Grouping Write a program to group a list of strings into anagrams. 
 * An anagram is a word formed by rearranging the letters of another. 
 * Example: Input: {"eat", "tea", "tan", "ate", "nat", "bat"} 
 * Output: {{"eat", "tea", "ate"}, {"tan", "nat"}, {"bat"}}
 * 
 */
	
	
	@Test
	public void testRuns(){
		System.out.println(Arrays.toString(findTargetsIndex(new int[] {5,7,7,8,8,10}, 8)));
		System.out.println(Arrays.toString(findTargetsIndex(new int[] {}, 5)));
		System.out.println(Arrays.toString(findTargetsIndex(new int[] {5,7,7,8,8,10}, 6)));
		System.out.println(Arrays.toString(findTargetsIndex(new int[] {5,7,7,8,8,10}, 7)));
		
		
		System.out.println(findCommonPrefix(new String[] {"flower", "flow", "flight"}));
		System.out.println(findCommonPrefix(new String[] {"dog","racecar","car"}));
		System.out.println(findCommonPrefix(new String[] {"abcd", "abc", "ab"}));
		
		System.out.println(groupAnagram(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
	}
	
	/*
	 * Program 1 - Pseudocode
	 * 
	 * Inputs
	 * Positive Case
	 * Example 1: Input: nums = {5,7,7,8,8,10}, target = 8 Output: {3,4} 
	 * Example 3: Input: nums = [], target = 0 Output: [-1,-1]
	 * 
	 * Negative Case
	 * Example 2: Input: nums = {5,7,7,8,8,10}, target = 6 Output: [-1,-1] 
	 * 
	 * Edge Case
	 * Example4: Input: nums = {5,6,7,7,8,8,10}, target = 6 Output: [1,1] 
	 * 
	 * Initialize a boolean flag to set after the start and end index is found
	 * Intialize a int[] with length 2 to return the target indexes.
	 * Check array length, if empty return -1,-1
	 * Iterate the array using for loop, have condition to check if the target element is present (Iterate from beginning),
	 * store the index in startIndex
	 * Repeat the iteration again from end of the array and check the target element is present
	 * store the endIndex
	 * Have flags to identify both start and end Index, 
	 * if target not present in the input array, return [-1, -1]
	 */
	public static int[] findTargetsIndex(int[] array, int target)
	{
		boolean startIndex = false;
		boolean endIndex = false;
		int[] indexes = new int[2];
		for(int i=0; i<array.length; i++)
		{
			if(array[i] == target) {
				startIndex = true;
				indexes[0] = i;
				break;
			}
			
		}
		for(int i=array.length-1; i>0; i--)
		{
			if(array[i] == target) {
				endIndex = true;
				indexes[1] = i;
				break;
			}
			
		}
		
		if(array.length<=0 || startIndex == false && endIndex == false) {
			indexes[0] = -1;
			indexes[1] = -1;
		}
		return indexes;	
	}
	
	/*
	 * Problem 2 - Pseudocode
	 * 
	 * Inputs
	 * Positive : ["flower","flow","flight"] Output: "fl" 
	 * 
	 * Negative : ["dog","racecar","car"] Output: "" 
	 * 
	 * Edge Case : [] Output: ""
	 *  
	 * Initialize a string to store the result
	 * Iterate through the string array
	 * Prefix should start from index 0
	 * Get the prefix, using charAt and store in result.
	 * During iteration, if the stored value is found, increment the index and 
	 * check if the next value is available on other strings
	 * Break iteration, when there is no common prefix found
	 * Have conditions and return "" for empty input and if result string is empty.
	 */
	public static String findCommonPrefix(String[] string)
	{
		Arrays.sort(string);
		String firstWord = string[0];
		String lastWord = string[string.length-1];
		int index = 0;
		while(index < firstWord.length() && index < lastWord.length())
		{
			if(firstWord.charAt(index) == lastWord.charAt(index))
			{
				index++;
			}
			else
			{
				break;
			}
		}
		return firstWord.substring(0, index);
	}
//		String result = "";
//		int inputLength = string.length;
//		if(inputLength==0 || string == null)
//		{
//			return "";
//		}
//		for(int i=0; i<inputLength-1; i++)
//		{
//			
//			for(int j=i+1;j<inputLength-1; i++)
//				if(string[i].charAt(i) == string[j].charAt(i))
//				{
//					result = result + string[i].charAt(i);
//				}
//				else
//				{
//					break;
//				}		
//		}
//		return result;
//	}
	
	/*
	 * Problem 3 - Pseudocode
	 * Inputs
	 * Example: Input: {"eat", "tea", "tan", "ate", "nat", "bat"} 
	 * Output: {{"eat", "tea", "ate"}, {"tan", "nat"}, {"bat"}}
	 * 
	 * Initialize a Map containing list
	 * Using a for each loop iterate via the given strings,
	 * Convert the strings to to charArray
	 * Sort each entry and store in the map, add the string in map as key
	 * for the added key, add the rest of the input strings as List
	 * Return the map values 
	 */
	public static Collection<List<String>> groupAnagram(String[] strings)
	{
		Map<String,List<String>> map = new HashMap<>();
		for(String s : strings)
		{
			char[] ch = s.toCharArray();
			Arrays.sort(ch);
			String SortedChars = new String(ch);
			
			if(!map.containsKey(SortedChars))
			{
				map.put(SortedChars, new ArrayList<>());
			}
			map.get(SortedChars).add(s);
		}
		return map.values();
		
		
	}
}

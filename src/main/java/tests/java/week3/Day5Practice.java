package tests.java.week3;

import org.junit.Test;

public class Day5Practice {

	@Test
	public void testpalindrome()
	{
		System.out.println("Palindrome "+isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println("Palindrome "+isPalindrome("race a car"));
		System.out.println("Palindrome "+isPalindrome(" "));
	}
	
	@Test
	public void testHalves()
	{
		System.out.println(halvesAreAlike(" "));
		System.out.println(halvesAreAlike("alphabet"));
		System.out.println(halvesAreAlike("animAl"));
	}
	
	@Test
	public void restoreString()
	{
		System.out.println(restoreString("codeleet", new int[] {4,5,6,7,0,2,1,3}));
		System.out.println(restoreString("codeleet", new int[] {4,5,6,7,0,2,1,3}));
		System.out.println(restoreString("codeleet", new int[] {4,5,6,7,0,2,1,3}));
	}
	
	@Test
	public void testFirstPalindrome()
	{
		System.out.println("First Palindrome "+firstPalindrome(new String[] {"avt", "atr", "atrm", "ava", "arkt"}));
		System.out.println("First Palindrome "+firstPalindrome(new String[] {"abc","car","ada","racecar","cool"}));
		System.out.println("First Palindrome "+firstPalindrome(new String[] {"notapalindrome","racecar"}));
		System.out.println("First Palindrome "+firstPalindrome(new String[] {"def","ghi"}));
	}
	
	@Test
	public void testMergeAlternatively()
	{
		System.out.println(mergeAlternately("test", "leaf"));
	}
	
	
	/*
	 * ClassWork 125 Valid Palindrome LeetCode
	 * Inputs 
	 */
	public boolean isPalindrome(String s) {
	    if (s != null) {    
	        String removeWhiteSpaces = s.replaceAll("\\s+", "");
	        String removeNonAlphaNumeric = removeWhiteSpaces.replaceAll("[^a-zA-Z0-9]", "");	  
	        String beforeReverse = removeNonAlphaNumeric.toLowerCase();
	        String reverseString = "";
	        for (int i = beforeReverse.length() - 1; i >= 0; i--) {
	            reverseString = reverseString+beforeReverse.charAt(i);
	        }
	        return beforeReverse.equals(reverseString);
	    }
	    return false; // Return false if the input is null
	}
	
	/*
	 * Classwork 1704 Determine if string halves are alike
	 * input String " ", "alphabet", "animAl"
	 * Check the length of the given string and using substring divide the strings and store in
	 * a string variables
	 * Initialize a counter variable for counting vowels in a string
	 * Provide the strings of a as input and check vowels count
	 * Similarly for strings of b
	 * if a and b matches the count, return true else false 
	 */
	public boolean halvesAreAlike(String s) {
        int stringLength = s.length();
        int halfIndex = stringLength/2;
        String firstPart = s.substring(0, halfIndex);
        String secondPart = s.substring(halfIndex);
        int firstPartCount = countVowels(firstPart);
        int sesecondPartCount = countVowels(secondPart);
        if(firstPartCount == sesecondPartCount)
        {
        	return true;
        }
        else
        {
        	return false;
        }
        
    }	
	public int countVowels(String s) {
	    int vowelCount = 0;

	    for (int i = 0; i < s.length(); i++) {
	        char ch = s.charAt(i); 
	        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || 
	            ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
	            vowelCount++;
	        }
	    }
	    return vowelCount;
	}

	/*
	 * ClassWork 1528 Shuffle String
	 * Given Inputs
	 * "codeleet" - [4,5,6,7,0,2,1,3]
	 * "abc" - [0,1,2]
	 * "cab" - [2,0,1]
	 * 
	 * Create/Initialize a string str
	 * Iterate through the values in the indexes given
	 * Assign the char[i] to the created String
	 */
	public String restoreString(String s, int[] indices) {
	        char[] ch=new char[indices.length];
	        for(int i = 0; i<indices.length; i++)
	        {
	        	ch[indices[i]] = s.charAt(i);
	        }
	        String str = String.valueOf(ch);
			return str;
	    }
	
	/*
	 * Homework Week3 - 2108 Find first palindromic string in the array - LeetCode
	 * Initialize Palindrome array index
	 * In a for loop, check if the value in the indexes are palindrome one by one
	 * if the String, is palidrome, break the loop and return the string
	 */
	public String firstPalindrome(String[] words) {
        int index = 0;
        for(int i = 0; i<words.length; i++)
        {
        	if(isPalindrome1(words[i])==true)
        	{
        	return words[i];
        	}
        }
	return "";
    }
	
	public static boolean isPalindrome1(String s)
	{
		String reverseString = "";
		for (int i = s.length() - 1; i >= 0; i--) {
            reverseString = reverseString+s.charAt(i);
        }
        return s.toLowerCase().equals(reverseString.toLowerCase());
	}
	
	/*
	 * Homework Week3 Day1 - 1768 Merge two strings alternatively
	 * Convert both strings to toCharArray
	 * In a new string initiation, add string1 and string2
	 * using substring add the rest letters to the new string
	 */
	public String mergeAlternately(String word1, String word2) {
        String str = "";
        int w1len = word1.length();
        int w2len = word2.length();
        if(w1len<=w2len)
        {
        	for(int i=0; i<w1len; i++)
        	{
        		str = str + word1.charAt(i)+word2.charAt(i);
        	}
        }
        else if(w2len<=w1len)
        {
        	for(int i=0; i<w2len; i++)
        	{
        		str = str + word1.charAt(i)+word2.charAt(i);
        	}
        }
        return str;
    } 
	
	
	
	
}


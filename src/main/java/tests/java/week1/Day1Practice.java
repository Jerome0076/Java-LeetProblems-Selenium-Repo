package tests.java.week1;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Day1Practice {

    @Test
    public void testPrime() {
        // Call the isPrime method with a sample value
        boolean result = isPrime(40);
        System.out.println("Is 40 a prime number? " + result);
    }
    
    @Test
    public void findOccurances() {
    	int[] array = {1,2,2,2,3,4,5,1,1};
    	Day1Practice.numberOccurances(array);
    }
    
    @Test
	 public void fizzBuzzTest() { 
		System.out.println(fizzBuzz(30));
	 }

    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false; // 0 and 1 are not prime numbers
        }
        if (n == 2) {
            return true; // 2 is the only even prime number
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false; // If divisible by any number, it's not prime
            }
        }
        return true; // If no divisors found, it's a prime number
    }
    
    public static void numberOccurances(int[] array)
    {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<array.length; i++)
        {
            if(list.contains(array[i])) continue;
            int count = 1;
            if(!list.contains(array[i]))
            {
                for(int j=i+1; j<array.length; j++)
                {
                    if(array[i] == array[j])
                        {
                        list.add(array[i]);
                        count++;
                        }
                }
            }
            System.out.println("Number " + array[i] + " occurs " + count + " times.");
        }
    }
    
    public List<String> fizzBuzz(int n) 
    {
     List<String> answer = new ArrayList<>();
      for(int i=1; i<=n; i++)
      {
        if(i%3==0 && i%5==0){
            answer.add("FizzBuzz");
        }
        else if(i%3==0){
            answer.add("Fizz");
        }
        else if(i%5==0){
            answer.add("Buzz");
        }
        else
        {
            answer.add(String.valueOf(i));
        }
      }
        return answer;
    }
    
}

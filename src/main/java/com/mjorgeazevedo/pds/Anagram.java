package com.mjorgeazevedo.pds;

import java.util.Arrays;

/**
 * Class created to study anagrams.
 * 
 * @author Mario Jorge
 */
public class Anagram {
	
	public static void main(String[] args) {
		String[] anagramArray = {"cba", "def", "ghi", "abc", "fed", "igh"} ;
		
		anagramSort(anagramArray);
		
		System.out.println(Arrays.toString(anagramArray));
	}
	
	/**
	 * Method to sort anagram array
	 * 
	 * @param anagramArray
	 */
	public static void anagramSort(String[] anagramArray) {
		anagramSort(anagramArray, 0, anagramArray.length-1);
	}

	/**
	 * Quicksort implementation for sort anagram array
	 * 
	 * @param anagramArray
	 * @param start array position
	 * @param finish array position
	 */
	private static void anagramSort(String[] anagramArray, int start, int finish) {
		if (start < finish) {
			final int pivot = partition(anagramArray, start, finish);
			anagramSort(anagramArray, start, pivot - 1);
			anagramSort(anagramArray, pivot + 1 ,finish);
		}
	}
	
	/**
	 * Make array partition;
	 * 
	 * @param anagramArray
	 * @param start array position
	 * @param finish array position
	 * @return pivot position.
	 */
	private static int partition(String[] anagramArray, int start, int finish) {
		final String pivot = anagramArray[start];
		final int hashPivot = hash(pivot);

		int i = start + 1;
		String swap; 
		
		while (i <= finish) {
			if (hash(anagramArray[i]) <= hashPivot) {
				i++;
			} else if (hashPivot < hash(anagramArray[finish])) {
				finish--;
			} else {
				swap = anagramArray[i];
				anagramArray[i] = anagramArray[finish];
				anagramArray[finish] = swap;
				i++;
				finish--;
			}
		}
		
		anagramArray[start] = anagramArray[finish];
		anagramArray[finish] = pivot;
		
		return finish;
	}	

	/**
	 * My own calculate mode method.
	 * 
	 * @param s is input string
	 * @return calculated hash
	 */
	private static int hash(String s) {
		return (s.charAt(1) << 8) + s.charAt(0) + s.charAt(2);
	}
}

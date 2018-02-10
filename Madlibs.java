/* Madlibs.java
 * Author: Hannah Parraga
 * firstByte Intro to Java
 * Takes different parts of speech from std in and prints
 * them to std out in a story. 
 */

import java.util.*;

public class Madlibs {
	public static void main(String args[]) {
		//scan words into program 
		Scanner scanny = new Scanner(System.in); 
		
		//A = adjective N = noun V = verb AV = adverb C = character
		String myStory = (
				"Once upon a time, there was a A1 A2 N1 named C1 who\n"
				+ "always thought about N2 even while V1 or V2 .\n" 
				+ "But AV1 , C1 was changed by a A3 event.\n" +  
				"A N3 V3 AV2 so C1 could never\n" + 
				"think about N2 in the same way again.\n" + 
				"The end.\n");
		//Build a TreeMap to match words with blanks
		//keys are taken from myStory
		//values are prompts to user
		HashMap<String,String> myBlanks = new HashMap<>();
		myBlanks.put("A1", "Adjective: ");
		myBlanks.put("A2", "Adjective: ");
		myBlanks.put("N1", "Noun: ");
		myBlanks.put("C1", "Character name: ");
		myBlanks.put("N2", "Noun: ");
		myBlanks.put("V1", "ING verb: ");
		myBlanks.put("V2", "ING verb: ");
		myBlanks.put("AV1", "Adverb: ");
		myBlanks.put("A3", "Adjective: ");
		myBlanks.put("N2", "Noun: ");
		myBlanks.put("N3", "Noun: ");
		myBlanks.put("V3", "Past tense verb: ");
		myBlanks.put("AV2", "Adverb: ");
	
		//replace prompts with user input in map
		for (String key : myBlanks.keySet()) {
			//print prompts
			System.out.print(myBlanks.get(key));
			myBlanks.replace(key, scanny.nextLine());
		}

		//replaces blanks in myStory with user input
		//split myStory into an array of words
		String splitStory[] = myStory.split(" ");
		for (int i = 0; i < splitStory.length; i++) {
			//if word is a key in the map of blanks
			if (myBlanks.containsKey(splitStory[i])) {
				//set word as value for that blank
				splitStory[i] = myBlanks.get(splitStory[i]);
			}
		}
		//join array of words back into string
		myStory = String.join(" ", splitStory);
		//print finished story
		System.out.println(myStory);
	}
}




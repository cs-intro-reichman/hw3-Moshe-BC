/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	public static boolean isAnagram(String str1, String str2) {
		String first = preProcess(str1);
		String second = preProcess(str2);

		if (first.length() != second.length()){
			return false;
		}
		while (first.isEmpty() == false) {
			char currentChar = first.charAt(0);
			int index = second.indexOf(currentChar);
			if (index == -1) { //check if current letter exists in second word
				return false;
			}
			//Remove current from both strings:
			first = first.substring(1);
			second = second.substring(0, index) + second.substring(index + 1);
		}
		return true;
	}

	public static String preProcess(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++){
			char current = str.charAt(i);
			if (Character.isLetter(current) || current == ' '){//add letters as lower case version:
				result += Character.toLowerCase(current);
			}
		}
		return result;
	} 
	   
	public static String randomAnagram(String str) {
		String result = "";
		//add random letter to result and remove it from string until completed
		while (str.isEmpty() == false) {
			int random = (int)(Math.random() * str.length());
			result += str.charAt(random);
			str = str.substring(0, random) + str.substring(random + 1);

				}
		return result;
	}
}

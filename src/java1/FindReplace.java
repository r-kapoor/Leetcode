package java1;

import java.util.HashMap;

public class FindReplace {

	static HashMap<String, String> mappings = new HashMap<String, String>();


	static boolean plagiarismCheck(String[] code1, String[] code2) {

		//Check for all invalid combinations in beginning to reduce unnecessary calculations
		if (code1.length == 0 && code2.length == 0)
			return true;
		//either of string is empty
		if (code1.length == 0 || code2.length == 0)
			return false;
		//strings do not match in length
		if (code1.length != code2.length)
			return false;

		
		for (int i = 0; i < code1.length; i++) {
			//for each part of string, it will check string and find out mappings and store in mappings hashmap
			if (!checkWithMappings(code1[i], code2[i]))
				return false;

		}

		for (int i = 0; i < code1.length; i++) {
			//now after data in mappings, it will replace next all occurrences and compare strings
			if (!replacewithMappingsData(code1[i], code2[i]))
				return false;

		}
		//if strings satisfy all conditions
		return true;

	}

	 static boolean replacewithMappingsData(String s1, String s2) {

		int numUsed = -1;

		for (String keys : mappings.keySet()) {
			//replace with mapping data
			if (mappings.containsKey(mappings.get(keys))) {

				s1 = s1.replaceAll("\\b" + keys + "\\b", String.valueOf(numUsed));

				s2 = s2.replaceAll("\\b" + mappings.get(keys) + "\\b", String.valueOf(numUsed));
				//num used is used to neglect already used new character
				numUsed--;

			}

			else
				s1 = s1.replaceAll("\\b" + keys + "\\b", mappings.get(keys));

		}

		if (!s1.equals(s2))
			return false;

		return true;

	}

	 static boolean checkWithMappings(String s1, String s2) {

		int i = 0;
		int j = 0;

		StringBuffer string1 = new StringBuffer("");

		StringBuffer string2 = new StringBuffer("");

		while (i < s1.length() && j < s2.length()) {
			//equal at characters
			if (s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
				continue;
			}

			else {

				if (!(Character.isAlphabetic(s1.charAt(i)) || s2.charAt(i) == '_'))
					return false;
				
				while (i < s1.length() && (Character.isDigit(s2.charAt(i))
						|| Character.isAlphabetic(s1.charAt(i)) || s1.charAt(i) == '_')) {

					string1 = string1.append(s1.charAt(i));

					i++;

				}

				if (!(Character.isAlphabetic(s2.charAt(j)) || s2.charAt(j) == '_'))
					return false;
				//check for digits and characters
				while (j < s2.length() && (Character.isDigit(s2.charAt(j))
						|| Character.isAlphabetic(s2.charAt(j)) || s2.charAt(j) == '_')) {

					string2 = string2.append(s2.charAt(j));

					j++;

				}

			}

			if (mappings.containsKey(string1.toString())) {

				if (mappings.get(string1.toString()).equals(string2.toString()))
					continue; //if already present and strings are equal

				else
					return false;

			} else {
				//put new replacements
				mappings.put(string1.toString(), string2.toString());

			}
			//make empty for new replacements
			string1 = new StringBuffer("");

			string2 = new StringBuffer("");

		}

		if (i == s1.length() && j == s2.length())
			return true;
		//strings not equal
		return false;

	}

	public static void main(String[] args) {

		String[] string1 = { "def is_even_sum(a, b):",

				"    return (a + b) % 2 == 0" };

		String[] string2 = { "def is_even_sum(summand_1, summand_2):",

				"    return (summand_1 + summand_2) % 2 == 0" };

		// System.out.println(plagiarismCheck(string1,string2));

		String[] string3 = { "def return_smth(a, b):",

				"  return a + a" };

		String[] string4 = { "def return_smth(b, a):",

				"  return b + b" };

		// System.out.println(plagiarismCheck(string3,string4));

		String[] string5 = { "def f(a,b)",

				"    return a + b" };

		String[] string6 = { "def f(b,a)",

				"    return a + b" };

		System.out.println(plagiarismCheck(string5, string6));

	}

}

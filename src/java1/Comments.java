package java1;

import java.util.LinkedList;
import java.util.List;

public class Comments {
	
	static int shortestSolutionLength(String[] source){
		int count = 0;
		boolean multilineComment = false;
		List<String> removed = new LinkedList<String>();
		for(int i = 0; i < source.length; i++){
			if(multilineComment){
				if(isCommentEnding(source[i])){
					count += lengthAfterCommentEnd(source[i]);
					multilineComment = false;
					continue;
				}
				else{
					continue;
				}
			}
			source[i] = removeMultilineComments(source[i]);
			if(isCommentStarting(source[i])){
				multilineComment = true;
			}
			
			count += lengthFrom(source[i]);
		}
		return count;
	}

	private static int lengthAfterCommentEnd(String s) {
		// TODO Auto-generated method stub
		int index = s.indexOf("*/");
		s = s.substring(index+2);
		s = removeMultilineComments(s);
		return lengthFrom(s);
	}

	private static boolean isCommentStarting(String s) {
		// TODO Auto-generated method stub
		int multilineStart = s.indexOf("/*");
		int singleLineStart = s.indexOf("//");
		if(multilineStart != -1){
			if(singleLineStart != -1){
				if(singleLineStart < multilineStart){
					return false;
				}
			}
			return true;
		}
//		for(int i = 0; i < s.length(); i++){
//			if(s.charAt(i) == '/' && (i+1 < s.length()) && s.charAt(i+1) == '*'){
//				return true;
//			}
//		}
		return false;
	}

	private static boolean isCommentEnding(String s) {
		// TODO Auto-generated method stub
		return s.indexOf("*/") != -1;
//		return false;
	}

	private static int lengthFrom(String string) {
		int count = 0;
		for(int i = 0; i < string.length(); i++){
			if(string.charAt(i) == ' '){
				continue;
			}
			if(string.charAt(i) == '/'){
				if(i+1 < string.length()){
					if(string.charAt(i+1) == '/'){
						//Single line Comment has started
						break;
					}
					if(string.charAt(i+1) == '*'){
						//Multiline comment
						break;
					}
				}
			}
			count++;
		}
		return count;
	}

	private static String removeMultilineComments(String string) {
		// TODO Auto-generated method stub
		int i = 0;
		while(string.indexOf("/*") != -1){
			int startIndex = string.indexOf("/*", i);
			if(startIndex + 2 == string.length()){
				break;
			}
			int endIndex = string.indexOf("*/", startIndex+2);
			if(startIndex < endIndex){
				//Has a comment
				string = string.substring(0, startIndex) + string.substring(endIndex+2);
			}
			else{
				break;
			}
		}
		return string;
	}

	public static void main(String[] args) {
//		System.out.println(removeMultilineComments("x = 2 //*/"));
		// TODO Auto-generated method stub
//		String[] source = {"int a = 5;"};
//		String[] source = {"int a = 5;", "a = 10;//comment"};
//		String[] source = {"int a = 5;", "a = 10;//comment", "//something"};
//		String[] source = {"int a = 5;", "a = 10;//comment", "//something", "a + /* something */ 2;"};
//		String[] source = {"int a = 5;", "a = 10;//comment", "//something", "a + /* something */ 2;", "a++; /*", "rtgyt", "*/"};
//		String[] source = {"x = 2 //*/", "x++;"};
//		String[] source = {"x = 2 /*iue//rh", "rth/* gt */ a /* fhf */ tr", "thtr// rtg*/ x = 1"};
		String s = "  t = f";
		System.out.println(s.replaceAll("\\bt\\b", "f"));
//		System.out.println(shortestSolutionLength(source));
	}

}

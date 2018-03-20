package java1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class EmailMask {
	public static void main(String... args) throws Exception {
	    String s = "nileshkemse@gmail.com";
	    s= s.replaceAll("(?<=.{1}).(?=.{1}.*@)", "*");
	    
	    System.out.println(s);
	    int count=0;
	     System.out.println(s);
	     
	     ArrayList<Integer> list = new ArrayList<>();
	    
	     Queue<Integer> queue = new LinkedList<>();
	     queue.add(2);
	     queue.poll();
	     
	}
}

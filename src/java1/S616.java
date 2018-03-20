package java1;

import java.util.ArrayList;
import java.util.Collections;

public class S616 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabbccdd";
		String[] dict = {"aa", "aab", "ccd"};
		System.out.println(addBoldTag(s, dict));

	}
	
	public static String addBoldTag(String s, String[] dict) {
		String out = "";
		ArrayList<Pair> tags = new ArrayList<Pair>();
		for(String word:dict){
			int index = s.indexOf(word);
			if(index == -1){
				continue;
			}
			while(index != -1){
				Pair pair = new Pair(index, index+word.length());
				tags.add(pair);
				index = s.indexOf(word, index+1);
			}
		}
		Collections.sort(tags);
		int cur = 0;
		for(int i = 0; i < tags.size(); i++){
			Pair tag = tags.get(i);
			System.out.println("Cur:"+cur);
			System.out.println(tag);
			System.out.println("Out:"+out);
			out += s.substring(cur, tag.begin);
			out += "<b>";
			if(i+1 < tags.size()){
				Pair nextTag = tags.get(i+1);
				int maxEnd = tag.end;
				while(nextTag.begin <= maxEnd){
					if(maxEnd < nextTag.end){
						maxEnd = nextTag.end;
					}
					i++;
					if(i+1 >= tags.size()){
						break;
					}
					nextTag = tags.get(i+1);
					
				}
				out += s.substring(tag.begin, maxEnd);
				out += "</b>";
				cur = maxEnd;
			}
			else{
				out += s.substring(tag.begin, tag.end);
				out += "</b>";
				cur = tag.end;
			}
		}
		if(cur < s.length()){
			out += s.substring(cur);
		}
        return out;
    }

}

class Pair implements Comparable<Pair>{
	public Integer begin, end;
	public Pair(int begin, int end){
		this.begin = begin;
		this.end = end;
	}
	
	@Override
	public int compareTo(Pair o) {
		int compared = this.begin.compareTo(o.begin);
		if(compared == 0){
			return this.end.compareTo(o.end);
		}
		return compared;
	}
	
	public String toString(){
		return begin+":"+end;
	}
}

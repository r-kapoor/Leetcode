package java1;

import java.util.ArrayList;
import java.util.List;

public class S271 {

	public static void main(String[] args) {
		List<String> strs = new ArrayList<String>();
		strs.add("C#");
		strs.add("&");
		strs.add("~Xp|F");
		strs.add("R4QBf9g=_");
		S271 codec = new S271();
		String s = codec.encode(strs);
		System.out.println(s);
		strs = codec.decode(s);
		for(String str:strs){
			System.out.println(str);
		}
	}

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String lengths = "";
        String appends = "";
        for(String str : strs){
        	appends += str;
        	lengths += ":" + str.length();
        }
        lengths = (lengths.length()+1) + lengths;
        return lengths+":"+appends;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
    	List<String> list = new ArrayList<String>();
    	if(s.equals("1:")){
    		return list;
    	}
    	String[] split = s.split(":");
    	int length = Integer.parseInt(split[0]);
    	length += split[0].length();
    	String appends = s.substring(length);
    	String lengths = s.substring(split[0].length()+1, length-1);
    	split = lengths.split(":");
    	int begin = 0;
    	for(int i = 0; i < split.length; i++){
    		int l = Integer.parseInt(split[i]);
    		list.add(appends.substring(begin, begin+l));
    		begin = begin+l;
    	}
		return list;
    }


}

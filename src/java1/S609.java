package java1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S609 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> contentToFile = new HashMap<String, List<String>>();
        for(int i = 0; i < paths.length; i++) {
        	String[] splitPaths = paths[i].split(" ");
        	for(int j = 1; j < splitPaths.length; j++) {
        		int endOfName = splitPaths[j].indexOf('(');
        		String name = splitPaths[j].substring(0, endOfName);
        		String content = splitPaths[j].substring(endOfName+1, splitPaths[j].length()-1);
        		if(contentToFile.containsKey(content)) {
        			contentToFile.get(content).add(splitPaths[0] +"/"+ name);
        		}
        		else {
        			ArrayList<String> list = new ArrayList<String>();
        			list.add(splitPaths[0] +"/"+ name);
        			contentToFile.put(content, list);
        		}
        	}
        }
        for(String content : contentToFile.keySet()) {
        	List<String> list = contentToFile.get(content);
        	if(list.size() > 1) {
        		result.add(list);
        	}
        }
        return result;
    }

}

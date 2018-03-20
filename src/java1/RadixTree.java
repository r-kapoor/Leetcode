package java1;

import java.util.HashMap;

import java1.Trie.Node;

public class RadixTree {
	
	Node root;
	class Node {
		HashMap<String, Node> map;
		boolean endOfWord;
		public Node() {
			map = new HashMap<String, Node>();
			endOfWord = false;
		}
	}
	
	public RadixTree() {
		root = new Node();
	}

	public static void main(String[] args) {
		RadixTree tree = new RadixTree();
		tree.addWord("hello");
		tree.addWord("hi");
		tree.addWord("water");
		tree.addWord("watery");
		System.out.println(tree.findPrefix("hello"));
		System.out.println(tree.findPrefix("hel"));
		System.out.println(tree.findPrefix("h"));
		System.out.println(tree.findPrefix("hi"));
		System.out.println(tree.findPrefix("air"));
		System.out.println(tree.findPrefix("wat"));
		System.out.println(tree.findPrefix("watery"));
	}
	
	public void addWord(String word) {
		addWord(word, 0, root);
	}
	
	private void addWord(String word, int index, Node root) {
		if(index >= word.length()) {
			root.endOfWord = true;
			return;
		}
		
		String currWord = word.substring(index);
		int i = 0;
		String edgeWordMatched = null;
		for(String edgeWords : root.map.keySet()) {
			int minLength = Math.min(edgeWords.length(), currWord.length());
			for(; i < minLength; i++) {
				if(edgeWords.charAt(i) != currWord.charAt(i)) {
					break;
				}
			}
			if(i > 0) {
				//Match
				edgeWordMatched = edgeWords;
				break;
			}
		}
		if(i > 0) {
			//Matched
			String matched = edgeWordMatched.substring(0, i);
			Node child = root.map.get(edgeWordMatched);
			root.map.remove(edgeWordMatched);
			Node newChild = new Node();
			newChild.map.put(edgeWordMatched.substring(i), child);
			root.map.put(matched, newChild);
			addWord(word, index+i, newChild);
		}
		else {
			// Add the word to the map
			Node node = new Node();
			root.map.put(currWord, node);
			addWord(word, index+currWord.length(), node);
		}
	}
	
	public boolean findPrefix(String prefix) {
		return findPrefix(prefix, 0, root);
	}
	
	private boolean findPrefix(String prefix, int index, Node root) {
		if(index >= prefix.length()) {
			return true;
		}
		
		String currWord = prefix.substring(index);
		for(String edgeWords : root.map.keySet()) {
			int minLength = Math.min(edgeWords.length(), currWord.length());
			int i = 0;
			for(; i < minLength; i++) {
				if(edgeWords.charAt(i) != currWord.charAt(i)) {
					break;
				}
			}
			if(i > 0) {
				//Match
				return true;
			}
		}
		return false;
	}

}

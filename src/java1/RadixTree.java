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
		// TODO Auto-generated method stub

	}
	
	public void addWord(String word) {
		addWord(word, 0, root);
	}
	
	private void addWord(String word, int index, Node root) {
		if(index >= word.length()) {
			root.endOfWord = true;
			return;
		}
		
		char cur = word.charAt(index);
		if(root.map.containsKey(cur)) {
			// Character already in the map
			addWord(word, index+1, root.map.get(cur));
		}
		else {
			// Add the character to the map
			Node node = new Node();
			root.map.put(cur, node);
			addWord(word, index+1, node);
		}
	}

}

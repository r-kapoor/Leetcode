package java1;

import java.util.HashMap;

public class Trie {
	
	Node root;
	class Node {
		HashMap<Character, Node> map;
		boolean endOfWord;
		public Node() {
			map = new HashMap<Character, Node>();
			endOfWord = false;
		}
	}
	
	public Trie() {
		root = new Node();
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.addWord("hello");
		trie.addWord("hi");
		trie.addWord("sharayu");
		trie.addWord("clear");
		System.out.println("Prefix");
		System.out.println(trie.findPrefix("h"));
		System.out.println(trie.findPrefix("hi"));
		System.out.println(trie.findPrefix("sha"));
		System.out.println(trie.findPrefix("shah"));
		System.out.println(trie.findPrefix("cli"));
		System.out.println("Word");
		System.out.println(trie.findWord("h"));
		System.out.println(trie.findWord("hi"));
		System.out.println(trie.findWord("sha"));
		System.out.println(trie.findWord("shah"));
		System.out.println(trie.findWord("cli"));
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
	
	public boolean findPrefix(String prefix) {
		return findPrefix(prefix, 0, root);
	}
	
	private boolean findPrefix(String prefix, int index, Node root) {
		if(index >= prefix.length()) {
			return true;
		}
		
		char cur = prefix.charAt(index);
		if(root.map.containsKey(cur)) {
			return findPrefix(prefix, index+1, root.map.get(cur));
		}
		return false;
	}
	
	public boolean findWord(String prefix) {
		return findWord(prefix, 0, root);
	}
	
	private boolean findWord(String prefix, int index, Node root) {
		if(index >= prefix.length()) {
			return root.endOfWord;
		}
		
		char cur = prefix.charAt(index);
		if(root.map.containsKey(cur)) {
			return findWord(prefix, index+1, root.map.get(cur));
		}
		return false;
	}
	
	

}

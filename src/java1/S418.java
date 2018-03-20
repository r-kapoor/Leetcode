package java1;

public class S418 {

	public static void main(String[] args) {
//		String[] sentence = {"hello","world"};
//		System.out.println(wordsTyping(sentence, 2, 8));
		String[] sentence = 
		{"abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r"};
		System.out.println(wordsTyping(sentence, 20000, 20000));
	}
	
	public static int wordsTyping(String[] sentence, int rows, int cols) {
		int counter = 0;
		int curWord = 0;
		int row = 0, col = 0;
		int totalLength = 0;
		for(int i = 0; i < sentence.length; i++){
			totalLength += sentence[i].length()+1;
		}
		totalLength--;
		while(true){
//			System.out.println(curWord);
			//Try to fit sentence
			if(col + totalLength <= cols){
				counter++;
				col += totalLength + 1;
				if(col >= cols){
					col = 0;
					row++;
					if(row == rows){
						break;
					}
				}
			}
			int wordLength = sentence[curWord].length();
			if(col + wordLength <= cols){
				col += wordLength + 1;
				curWord++;
				if(curWord == sentence.length){
					counter++;
					curWord = 0;
				}
				if(col >= cols){
//					System.out.println("W:"+counter);
					col = 0;
					row++;
					if(row == rows){
						break;
					}
				}
			}
			else {
				//Not enough space in row
//				System.out.println("R:"+counter);
				row++;
				col = 0;
				if(row == rows){
					break;
				}
			}			
		}
		return counter;
        
    }

}

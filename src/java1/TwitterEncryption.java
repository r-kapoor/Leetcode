package java1;

public class TwitterEncryption {
	
	public static void main(String args[]){
		String s = "Otjfvknou kskgnl, K mbxg iurtsvcnb ksgq hoz atv. Vje xcxtyqrl vt ujg smewfv vrmcxvtg rwqr ju vhm ytsf elwepuqyez. -";
		String s1 = "Atvt hrqgse, Cnikg";
		String letters = s.replaceAll("[^a-zA-z]", "");
		System.out.println(letters);
		System.out.println(letters.length());
		
		s = s+s1;
		
		String decrypted = "";
		int[] key = {8,2,5,1,2,2,0};
		int keyIndex = 0;
		for(int i = 0; i < s.length(); i++){
			char cur = s.charAt(i);
			if(Character.isUpperCase(cur)){
				int charIndex = cur - 'A';
				charIndex -= key[keyIndex];
				if(charIndex < 0){
					charIndex += 26;
				}
				decrypted += (char)('A' + charIndex);
				keyIndex++;
				keyIndex = keyIndex >= key.length?0:keyIndex;
			}
			else if(Character.isLowerCase(cur)){
				int charIndex = cur - 'a';
				charIndex -= key[keyIndex];
				if(charIndex < 0){
					charIndex += 26;
				}
				decrypted += (char)('a' + charIndex);
				keyIndex++;
				keyIndex = keyIndex >= key.length?0:keyIndex;
			}
			else{
				decrypted += cur;
			}
		}
		System.out.println(decrypted);
	}
}

package java1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class S767 {

	public static void main(String[] args) {
		System.out.println(reorganizeString("tndsewnllhrtwsvxenkscbivijfqnysamckzoyfnapuotmdexzkkrpmppttficzerdndssuveompqkemtbwbodrhwsfpbmkafpwyedpcowruntvymxtyyejqtajkcjakghtdwmuygecjncxzcxezgecrxonnszmqmecgvqqkdagvaaucewelchsmebikscciegzoiamovdojrmmwgbxeygibxxltemfgpogjkhobmhwquizuwvhfaiavsxhiknysdghcawcrphaykyashchyomklvghkyabxatmrkmrfsppfhgrwywtlxebgzmevefcqquvhvgounldxkdzndwybxhtycmlybhaaqvodntsvfhwcuhvuccwcsxelafyzushjhfyklvghpfvknprfouevsxmcuhiiiewcluehpmzrjzffnrptwbuhnyahrbzqvirvmffbxvrmynfcnupnukayjghpusewdwrbkhvjnveuiionefmnfxao"));
	}
	
	public static String reorganizeString(String S) {
		HashMap<Character, Integer> characterFreq = new HashMap<Character, Integer>();
		for(int i = 0; i < S.length(); i++) {
			characterFreq.put(S.charAt(i), characterFreq.getOrDefault(S.charAt(i), 0) + 1);
		}
		ArrayList<CharacterFreq> list = new ArrayList<CharacterFreq>();
		for(char c:characterFreq.keySet()) {
			list.add(new CharacterFreq(c, characterFreq.get(c)));
		}
		Collections.sort(list);
		int maxFreqAllowed = (S.length()%2 == 0)?S.length()/2:S.length()/2+1;
		if(list.get(0).freq > maxFreqAllowed) {
			return "";
		}
		char[] result = new char[S.length()];
		for(int i = 0; i < result.length; i++) {
			result[i] = '_';
		}
		int currPos = 0;
//		System.out.println(list);
		for(CharacterFreq cf : list) {
//			System.out.println(cf);
//			System.out.println(currPos);
			for(int i = 0; i < cf.freq; i++) {
				if(currPos >= result.length) {
					if(currPos%2 == 0) {
						currPos = 1;
					}
					else {
						return "";
					}
				}
				result[currPos] = cf.c;
				currPos += 2;
			}
			System.out.println(new String(result));
		}
		return new String(result);
    }

}

class CharacterFreq implements Comparable<CharacterFreq>{
	char c;
	int freq;
	public CharacterFreq(char c, int freq) {
		this.c = c;
		this.freq = freq;
	}
	@Override
	public int compareTo(CharacterFreq o) {
		return -Integer.compare(this.freq, o.freq);
	}
	
	public String toString() {
		return c+":"+freq;
	}
}
package java1;

public class S393 {
	/**
	 * This is not the final submission
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {35,105,110,99,108,117,100,101,60,98,105,116,115,47,115,116,100,99,43,43,46,104,62,13,10,117,115,105,110,103,32,110,97,109,101,115,112,97,99,101,32,115,116,100,59,13,10,116,121,112,101,100,101,102,32,108,111,110,103,32,108,111,110,103,32,108,108,59,13,10,116,121,112,101,100,101,102,32,112,97,105,114,60,105,110,116,44,32,105,110};
		System.out.println(validUtf8(data));
	}
	
	public static boolean validUtf8(int[] data) {
        return validUtf8(data, 0);
    }
    
    public static boolean validUtf8(int[] data, int begin){
        System.out.println("Begin:"+begin);
        if(begin >= data.length){
            return true;
        }
        String cur = getStringOfLength8(data[begin]);
        // System.out.println(cur);
        int index = cur.indexOf('0');
        if(index == -1){
            return false;
        }
        if(index == 0){
            return validUtf8(data, begin + 1);
        }
        if(index > data.length){
            return false;
        }
        for(int i = begin+1; i < begin+index; i++){
            cur = getStringOfLength8(data[i]);
            // System.out.println(cur);
            int index0 = cur.indexOf('0');
            if(index0 != 1){
                return false;
            }
        }
        // System.out.println(begin+index);
        return validUtf8(data, begin+index);
    }
    
    public static String getStringOfLength8(int num){
        String binary = Integer.toBinaryString(num);
        int len = binary.length();
        if(len > 8){
            return binary.substring(len-8);
        }
        while(binary.length() < 8){
            binary = "0" + binary;
        }
        return binary;
    }

}

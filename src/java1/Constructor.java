package java1;

public class Constructor {
	
	static String str;
	public void Contructor(){
		System.out.println("In");
		str = "Hello World";
	}
	
	public static void main(String[] args){
		Constructor c = new Constructor();
		System.out.println(str);
	}

}

public class Hanoi{
	public static byte free(byte a,byte b){
		return (byte)(3-(a+b));
	}
	public static void move(int h, byte a, byte b){
		if(h>0){
			byte c = free(a,b);
			move(h-1,a,c);
			System.out.println("\tmove" + a + " to " + b);
			move(h-1,c,b);
		}
	}

	public static void main(String[] args){
		System.out.println("Hanoi");
	}
}

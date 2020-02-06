import java.util.Scanner;
import java.math.BigInteger;

public class squareNumber {

	public squareNumber() { recu(); }
	
	public void recu() {
		BigInteger MAX_VALUE = new BigInteger("9223372036854775807");
		for(int i = 0; i < 10; i++) {
			System.out.println( MAX_VALUE.multiply( MAX_VALUE ).toString() );
		}	
	}

	public static void main(String[] args) {
		squareNumber sq = new squareNumber();		
	}

}

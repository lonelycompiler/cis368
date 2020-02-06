
import java.util.Scanner;

public class Test {
	public Scanner sc;

	public Test() {
		sc = new Scanner(System.in);
		
		double[][] array = getArray();
		
		//double[][] array = {{23.5,35,2,10},{2.5,3,45,3.5},{35,44,5.5,9.6}};
		
		Location loc = new Location();
		Location roc = loc.locateLargest(array);
		
		System.out.print("The location of the largest element is " + roc.maxValue);
		System.out.println(" at (" + roc.row + ", " + roc.column + ")");
		
		sc.close();
	}
	
	public double[][] getArray() {
		/* This is the input for the size of the 2D array */
		System.out.print("Enter the number of rows and columns in the array: ");
		String input = sc.nextLine();
		String[] rowCol = input.split(" ");
		int rows = (int) Integer.parseInt(rowCol[0]), cols = (int) Integer.parseInt(rowCol[1]);
		
		/* Fill in the 2D array */
		double[][] array = new double[rows][cols];
		
		System.out.println("Enter the array:");
		
		for(int i = 0; i < rows; i++) {
			String[] tempInput = sc.nextLine().split(" ");
			for(int j = 0; j < cols; j++) {
				array[i][j] = (double) Double.parseDouble(tempInput[j]);
			}
		}
		
		return array;
		
	}

	public static void main(String[] args) {
		Test test = new Test();
	}

}

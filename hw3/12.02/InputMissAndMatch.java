import java.util.Scanner;
import java.util.InputMismatchException;
public class InputMissAndMatch
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int[] input = new int[2]; int i = 0;
		while(i < 2)
		{
			try
			{
				System.out.print("Number " + (i+1) + ": ");
				input[i] = sc.nextInt();
				++i;
			}
		       	catch (InputMismatchException e)
			{
				System.out.println("Invalid character! Integers only! Try Again!");
				sc.next();
			}
		}
		System.out.println("The answer is " + (input[0] + input[1]));
	}
}

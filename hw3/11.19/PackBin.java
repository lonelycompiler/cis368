
import java.util.Scanner;
import java.util.ArrayList;

public class PackBin
{
	public static void main(String[] args)
	{
		//get input	
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of objects: ");
		int numObj = Integer.parseInt(sc.nextLine());
		System.out.print("Enter the weight of the objects: ");
		String objs = sc.nextLine();

		//This part takes the weights and converts to integer array	
		String[] idk = objs.split(" ");
		int weight;// = new int[numObj];
	
		int total = 0, j = 0;
		ArrayList<Integer> w = new ArrayList<Integer>();
		for(int i = 0 ; i < numObj; i++)
		{
			weight = Integer.parseInt(idk[i]);
			if((total+weight) <= 10) 
			{ 
				w.add(weight);
				total+=weight;
			}
			else
			{
				System.out.println("Container " + (++j) + " contains objects with weight " + w.toString());
				w.removeAll(w);
				w.add(weight);
				total=weight;
			}

		}System.out.println("Container " + (++j) + " contains objects with weight " + w.toString());
		
	}
}


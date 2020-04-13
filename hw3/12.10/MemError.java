

public class MemError
{
	public static void main(String[] args)
	{
		long[] r;
		while(true)
		{
			try
			{
				r = new long[2147483647];
				for(int i = 0; i < r.length; ++i)
				{
					r[i] = 99999999;
				}
			}
			catch(OutOfMemoryError e)
			{
				System.out.println("ERROR: YOU'RE OUT OF ERROR!!!!!!");
				System.exit(0);
			}
		}
	}
}

import java.io.*;

public class UnzipDat
{
	public static void main(String[] args)
	{
		String path = "ZappedJpgFiles.dat";
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try
		{
			fis = new FileInputStream(path);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error, the file "+path+" was not found! "+e.getMessage());
		}
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try
		{
			ois = new ObjectInputStream(fis);
			int numFiles = ois.readInt();
			int off = 0;
			for(int i = 0; i < numFiles; ++i)
			{
				//String fileName = ois.readUTF();
				byte[] buf1 = new byte[4];
				ois.read(buf1, off, 4);
				int fileSize = ois.readInt();
				byte[] buf = new byte[fileSize];
				ois.read(buf, off, fileSize);
				off+=fileSize;
				fos = new FileOutputStream("image"+(i+1)+".jpg");
				oos = new ObjectOutputStream(fos);
				oos.write(buf);
			}
			oos.flush();
			oos.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (fis != null)
			{
                try
                {
                    fis.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
		}
	}
}

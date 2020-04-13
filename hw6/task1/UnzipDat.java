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
		
		try
		{
			ois = new ObjectInputStream(fis);
			int numFiles = ois.readInt();
			System.out.println("There are " + numFiles + " files!");
			int off = 0;
			for(int i = 0; i < numFiles; ++i)
			{
				String fileName = "";
				try{
					fileName=ois.readUTF();
				}
				finally
				{
					int fileSize = ois.readInt();
					byte[] buf = new byte[fileSize];
					ois.read(buf, 0, fileSize);
					off+=fileSize;
					fos = new FileOutputStream(fileName);
					try(ObjectOutputStream oos = new ObjectOutputStream(fos))
					{
						System.out.println("Writing to " + fileName);
						oos.write(buf);
						oos.flush();
					}
				}
			}
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
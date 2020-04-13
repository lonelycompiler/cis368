import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.*;
import java.util.Scanner;

public class problem4
{
    public static void main(String[] args)
    {
        while(true)
        {
            // read from a URL and 
            Scanner sc = new Scanner(System.in);
            String userEnteredURL = sc.nextLine();//"https://github.com/YalingZheng/CIS368Spr20/blob/master/babynamesranking2017.txt";
            
            // Create URL from url .
            try 
            {
                URL url = new URL(userEnteredURL);
                BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    if( inputLine.matches("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}"))
                        System.out.println(inputLine);
                break;
            }
            catch (MalformedURLException e) 
            {
                System.out.println("invalid URL, please enter a valid one.");
            }
            catch (IOException e) 
            {
                System.out.println("INVALID URL!!");
            }
            sc.close();
        }
    }
}



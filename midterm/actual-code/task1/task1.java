/*
    Take input from user -- URL
        if URL is invalid, MalformedURLException, and output invalid URL
    read double numbers from file
        IO Exception needs to be handled
        NumberFormatException for non-numbers
    multiply all double, the result will be a bigdecimal
    program will output the result
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigDecimal;

public class task1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            System.out.print("Enter URL: ");
            String userEnteredURL = sc.nextLine(); //http://eecs.csuohio.edu/~yazheng/DecimalNumbers.txt

            URL url = new URL(userEnteredURL);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine;
            ArrayList<String> elements = new ArrayList<String>();
            while ((inputLine = in.readLine()) != null)
            {
                String[] input = inputLine.split("\\W+");

                for(int i = 0; i < input.length; i++)
                {
                    inputLine = input[i];
                    try
                    {
                        double inp = Double.valueOf(inputLine);
                        elements.add(inputLine);
                    } 
                    catch(NumberFormatException e)
                    {
                        System.out.println(inputLine + " is not a valid double!");
                    }
                }

                BigDecimal result = new BigDecimal(elements.get(0));

                for(int i = 1; i < elements.size(); i++)
                    result = result.multiply(new BigDecimal(elements.get(i)));

                System.out.println("Result:\n" + result.toString());

            }
        }
        catch (MalformedURLException e)
        {
            System.out.println("invalid URL");
        }
        catch (IOException e)
        {
            System.out.println("IOException: Failure reading URL!");
        }
    }
}
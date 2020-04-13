import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;


public class problem1 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        BigInteger result = new BigInteger("1");


        try {
            //System.out.println("Enter a url");
            //String userEnteredURL = keyboard.nextLine();
            String userEnteredURL = "https://raw.githubusercontent.com/YalingZheng/CIS368Spr20/master/babynamesranking2017.txt";
            // Create URL from url .
            URL url = new URL(userEnteredURL);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine;
            List<Integer> elements = new ArrayList<>();
            while ((inputLine = in.readLine()) != null){
                String[] input = inputLine.split("\\W+");
                //System.out.println(Arrays.toString(input));



                for (int i = 0; i < input.length; i++) {
                    try {
                        elements.add(Integer.parseInt(input[i]));
                        BigInteger product = BigInteger.valueOf(i);

                    }catch (NumberFormatException e){}//do nothing when numberformat exception caught
                }

                System.out.println(inputLine);
            }
            for (int i = 0; i < elements.size(); i++) {
                BigInteger product = BigInteger.valueOf(i);
                result.multiply(product);
            }



            System.out.println(result);

        }
        catch (MalformedURLException e) {
            System.out.println("Please enter a valid URL:\n");
        }
        catch (IOException e) {
            System.out.println("something wrong");
        }
        keyboard.close();
    }

}

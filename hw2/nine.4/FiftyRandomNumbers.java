
import java.util.Random;

public class FiftyRandomNumbers {
    Random rand = new Random(1000);
    
    public displayRandomNumbers() {
        for(int i = 0; i<10; i++) {
            for(int j = 0; j < 5; j++) 
                System.out.print(rand.nextInt(100));
            System.out.println();
        }
    }
}
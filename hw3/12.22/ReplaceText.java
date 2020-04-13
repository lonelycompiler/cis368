import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

public class ReplaceText {
  public static void main(String[] args) throws Exception {
    // Check command line parameter usage
    if(args.length == 3)
    {
        //dir oldString newString --- arg[0] arg[1] arg[2]
        File[] dir = (new File(".")).listFiles();
        for(File i : dir)
        {
            if(!(i.getName().length() >= 11 && i.getName().substring(0, 11).equals("ReplaceText"))) {
              Scanner input = new Scanner(i);
              PrintWriter output = new PrintWriter(i);
              String f = "";
              while (input.hasNext()) { 
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(args[1], args[2]);
                System.out.println("s1: " + s1 + "\ns2: " + s2);
                f = f + s2 + "\n";
              }
              System.out.println("Output is getting " + f);
              output.println(f);
            }
        }
    } 
    else if (args.length != 4) {
      System.out.println(
        "Usage to replace one file:  $ java ReplaceText sourceFile targetFile oldStr newStr\nUsage to replace all files: $ java ReplaceText dir oldString newString");
      System.exit(1);
    } else {

      /* -------- HI ALL HERES THE ORIGINAL FILE.. --------- */
      // Check if source file exists
      File sourceFile = new File(args[0]);
      if (!sourceFile.exists()) {
        System.out.println("Source file " + args[0] + " does not exist");
        System.exit(2);
      }

      // Check if target file exists
      File targetFile = new File(args[1]);
      if (targetFile.exists()) {
        System.out.println("Target file " + args[1] + " already exists");
        System.exit(3);
      }

      try (
        // Create input and output files
        Scanner input = new Scanner(sourceFile);
        PrintWriter output = new PrintWriter(targetFile);
      ) {        
        while (input.hasNext()) {
          String s1 = input.nextLine();
          String s2 = s1.replaceAll(args[2], args[3]);
          output.println(s2);
        }
      }
    }
  }
}

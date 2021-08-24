import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CleaningTex {
    String input;
    String output;

    public CleaningTex(String input, String output) {
        this.input = input;
        this.output = output;
    }

    public String cleaningText() throws Exception {
        String inpt=null;
        Scanner sc = new Scanner(new File(input));
        FileWriter writer = new FileWriter(output);
        Set set = new HashSet();
        while (sc.hasNextLine()) {
            inpt = sc.nextLine();
            if (set.add(inpt)) {
                writer.append(inpt + " \n");
            }
        }
        writer.flush();
        System.out.println("Duplicate emails deleted and a new file created!");
        return output;
    }
}

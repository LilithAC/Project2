package pss1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Salter1 {

    public static void salt(File file, int bound1) throws FileNotFoundException {
        try (Scanner in = new Scanner(file)) {
            File output = new File("saltedOutput.csv");
            Random rand = new Random();

            ArrayList<Integer> xValues = new ArrayList<>();
            ArrayList<Integer> yValues = new ArrayList<>();

            //continues while there is a line
            while (in.hasNextLine()) {
                //take entire line
                String line = in.next();
                //splits by comma
                String[] values = line.split(",");

                int x = Integer.parseInt(values[0]);
                int y = Integer.parseInt(values[1]) + rand.nextInt(-bound1, bound1);
                xValues.add(x);
                yValues.add(y);
            }
            Exporter1.export(output, xValues, yValues);
        }
    }
}

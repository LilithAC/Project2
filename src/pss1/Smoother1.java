package pss1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Smoother1 {

    public static void smoother(File file, int windowValue) throws FileNotFoundException {
        //try with resources
        try (Scanner in = new Scanner(file)) {
            File output = new File("smoothedOutput.csv");

            ArrayList<Integer> xValues = new ArrayList<>();
            ArrayList<Integer> yValues = new ArrayList<>();

            //loop through data and smooth y value
            while (in.hasNextLine()) {
                String line = in.next();
                String[] values = line.split(",");

                int x = Integer.parseInt(values[0]);
                int y = Integer.parseInt(values[1]);
                xValues.add(x);
                yValues.add(y);
            }
            Exporter1.exportD(output, xValues, smooth(yValues, windowValue));
        }
    }

    public static ArrayList<Double> smooth(ArrayList<Integer> values, int windowValue) { //ISE means "hey, you're using me wrong" unchecked exception
        if (windowValue%2 == 0) {
            throw new IllegalStateException("Odd number for windowValue only.");
        }
        ArrayList<Double> smoothed = new ArrayList<>();
        //go through every value
        for (int i = 0; i < values.size(); i++) {
            //sum numbers by window
            int sum = 0;
            int count = 0;
            int half = windowValue/2;
            for (int j = -half; j < half; j++) {
                //check if index in window is OOB
                if (i + j < 0 || i + j > values.size()-1) {
                    continue;
                }
                sum += values.get(i+j);
                count++;
            }
            double avg = (double) sum /count;
            //truncate before adding
            double trunc = Math.floor(avg * 100) / 100;
            smoothed.add(trunc);
        }
        return smoothed;
    }
}

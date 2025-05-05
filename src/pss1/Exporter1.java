package pss1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Exporter1 {

    //writes arrayList of ints to a file formatted for csv
    public static void export(File file, ArrayList<Integer> xValues, ArrayList<Integer> yValues) throws FileNotFoundException {
            PrintWriter writer = new PrintWriter(file);
            for (int i = 0; i < xValues.size(); i++) {
                //checks for last line of data
                if(i == xValues.size()-1) {
                    writer.print(xValues.get(i) + "," + yValues.get(i));
                } else {
                    writer.println(xValues.get(i) + "," + yValues.get(i));
                }
            }
            writer.close();
    }

    //exporter for y values as doubles
    public static void exportD(File file, ArrayList<Integer> xValues, ArrayList<Double> yValues) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter(file);
        for (int i = 0; i < xValues.size(); i++) {
            //checks for last line of data
            if(i == xValues.size()-1) {
                writer.print(xValues.get(i) + "," + yValues.get(i));
            } else {
                writer.println(xValues.get(i) + "," + yValues.get(i));
            }
        }
        writer.close();
    }
}

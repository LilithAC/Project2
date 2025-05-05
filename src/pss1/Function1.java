package pss1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Function1 {

    public static void exportQuadratic(File file, int xBound) throws FileNotFoundException {
        ArrayList<Integer> xValues = new ArrayList<>();
        ArrayList<Integer> yValues = new ArrayList<>();
        for (int i = -xBound; i <= xBound; i++) {
            xValues.add(i);
            yValues.add(quadratic(i));
        }
        Exporter1.export(file, xValues, yValues);
    }

    //simply squares the given x value
    public static int quadratic(int x) {
        return Integer.valueOf((int) Math.pow(x, 2));
    }
}

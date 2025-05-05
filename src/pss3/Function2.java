package pss3;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Function2 {

    //helper method
    public static Integer quadratic(int x) {
        return (int) (Math.pow(x, 2));
    }

    //populates a XYSeries dataset with the quadratic function
    public static XYSeriesCollection quadraticData(int xBound) {
        XYSeries series = new XYSeries("MyGraph");
        for (int i = 0; i <= xBound; i++) {
            series.add(i, quadratic(i));
        }
        return new XYSeriesCollection(series);
    }
}

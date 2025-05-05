package pss3;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.util.Random;

public class Salter2 {
    //takes dataset, salts it, then returns new dataset
    public static XYSeriesCollection salt(XYSeriesCollection dataset, int bound1, int bound2) {
        XYSeries series = new XYSeries("SaltedData");
        Random rand = new Random();
        for (int i = (int) dataset.getDomainLowerBound(false); i < dataset.getDomainUpperBound(false); i++) {
            //salt y value according to determined bounds
            int y = (int) dataset.getY(0,i) + rand.nextInt(bound1, bound2);
            series.add(dataset.getX(0, i), y);
        }
        return new XYSeriesCollection(series);
    }
}

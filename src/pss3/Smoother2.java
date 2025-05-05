package pss3;

import org.apache.commons.statistics.descriptive.Mean;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.ArrayList;


public class Smoother2 {
    //takes dataset, smooths it, returns new dataset
    public static XYSeriesCollection smooth(XYSeriesCollection dataset, int windowSize) {
        if (windowSize%2 == 0) {
            throw new IllegalStateException("Odd number for windowSize only");
        }
        int half = windowSize/2;
        XYSeries series = new XYSeries("SmoothedGraph");
        for (int i = (int) dataset.getDomainLowerBound(false); i < dataset.getDomainUpperBound(false); i++) {

            //create new array of window size
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = -half; j < half; j++) {
                //check that window value is not OOB
                if (i + j < 0 || i + j > dataset.getDomainUpperBound(false)) {
                    continue;
                }
                //add value into window
                list.add((int) dataset.getY(0,i+j));
            }
            double[] values = new double[list.size()];
            for (int k = 0; k < list.size(); k++) {
                values[k] = list.get(k);
            }
            double avg = Mean.of(values).getAsDouble();
            series.add(i,avg);
        }

        return new XYSeriesCollection(series);
    }
}

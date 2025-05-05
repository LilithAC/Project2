package statsLibrary;

import java.math.BigDecimal;

public class DistributionsUpdate {
    public static BigDecimal poisson(int y, double lambda) {
        ComboPermu a = new ComboPermu();
        BigDecimal yFactorial = new BigDecimal(a.factorial(y));
        BigDecimal numerator = new BigDecimal(Math.pow(Math.E, -lambda)*Math.pow(lambda,y));
        return numerator.divide(yFactorial);
    }

    public static double uniform(int a, int b, int c, int d) {
        return (double) (d-c)/(b-a);
    }

    //given an upper and lower bound and standard deviation amount, returns the k variable that describes how many standard deviations away from the mean the data is
    public static double chevycheb(int lower, int upper, int stdDev) {
        if((upper-lower)%2 != 0) {
            throw new IllegalStateException("Even window of upper and lower bounds only.");
        }
        int within = (upper - lower)/2;
        return (double) within/stdDev;
    }
}

package pss1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import dummyHash.DummyHash;
import org.jfree.data.xy.XYSeriesCollection;
import pss3.Exporter2;
import pss3.Function2;
import pss3.Salter2;
import pss3.Smoother2;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //pss1 outputs
        File output = new File("output.csv");
        File salt = new File("saltedOutput.csv");
        Function1.exportQuadratic(output,50);
        Salter1.salt(output, 80);
        Smoother1.smoother(salt, 3);

        //dummy hash testing
        HashMap<String, Integer> hash = new HashMap<>();
        DummyHash dh = new DummyHash();
        hash.put("FL", dh.dumbHash("FL"));
        hash.put("NJ", dh.dumbHash("NJ"));
        hash.put("TX", dh.dumbHash("TX"));

        System.out.println(hash.containsKey("FL"));

        //pss3 outputs
        XYSeriesCollection quadratic = Function2.quadraticData(50);
        Exporter2.export(quadratic, "Quadratic Graph");
        XYSeriesCollection salted = Salter2.salt(quadratic,-300, 300);
        Exporter2.export(salted, "Salted Graph");
        XYSeriesCollection smoothed = Smoother2.smooth(salted,11);
        Exporter2.export(smoothed, "Smooth Graph");
    }
}

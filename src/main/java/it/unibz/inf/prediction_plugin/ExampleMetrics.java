package it.unibz.inf.prediction_plugin;

import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class ExampleMetrics implements Metrics {

    public static final Metric<Double> RANDOM = new Metric.Builder("random", "Random", Metric.ValueType.FLOAT)
            .setDescription("Random value")
            .setDirection(Metric.DIRECTION_BETTER)
            .setQualitative(false)
            .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    // getMetrics() method is defined in the Metrics interface and is used by
    // Sonar to retrieve the list of new metrics
    public List<Metric> getMetrics() {
        return Arrays.asList(RANDOM);
    }
}

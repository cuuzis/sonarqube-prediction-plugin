package it.unibz.inf.prediction_plugin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.sonar.api.ce.measure.Component;
import org.sonar.api.ce.measure.Measure;
import org.sonar.api.ce.measure.MeasureComputer;

import static it.unibz.inf.prediction_plugin.ExampleMetrics.RANDOM;

public class ExampleComputeEngine implements MeasureComputer {

    private static Logger LOG = LoggerFactory.getLogger(ExampleComputeEngine.class);

    public MeasureComputerDefinition define(MeasureComputerDefinitionContext def) {
        return def.newDefinitionBuilder()
                .setOutputMetrics(RANDOM.key())
                .build();
    }

    public void compute(MeasureComputerContext context) {
        if (context.getComponent().getType() != Component.Type.FILE) {
            double sum = 0;
            double count = 0;
            for (Measure child : context.getChildrenMeasures(RANDOM.key())) {
                sum += child.getDoubleValue();
                count++;
                LOG.info("Measure current value: " + child.getDoubleValue());
            }
            double average = count == 0 ? 0 : sum / count;
            LOG.info("Measure average value: " + average);
            context.addMeasure(RANDOM.key(), average);
        }
    }
}

package it.unibz.inf.prediction_plugin;
import org.sonar.api.Plugin;

public class PredictionPlugin implements Plugin {

    public void define(Context context) {
        context.addExtensions(
                //Definitions
                ExampleMetrics.class,
                ExampleRules.class,
                //Batch job on local machine
                ExampleSensor.class,
                // Compute Engine on server
                ExampleComputeEngine.class,
                // UI page on server
                ExamplePage.class);
    }
}

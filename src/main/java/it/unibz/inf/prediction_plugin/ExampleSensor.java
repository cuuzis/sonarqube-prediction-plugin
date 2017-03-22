package it.unibz.inf.prediction_plugin;

import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputComponent;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.measure.Metric;
import org.sonar.api.batch.sensor.Sensor;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;
import org.sonar.api.batch.sensor.issue.NewIssue;
import org.sonar.api.batch.sensor.issue.NewIssueLocation;
import org.sonar.api.batch.sensor.measure.Measure;
import org.sonar.api.config.Settings;

import java.io.Serializable;

import static it.unibz.inf.prediction_plugin.ExampleMetrics.RANDOM;

public class ExampleSensor implements Sensor {

    public void describe(SensorDescriptor sensorDescriptor) {
        // Shows at start of analysis
        System.out.println("-------------------------> Sensor descriptor");
    }

    public void execute(SensorContext context) {
        System.out.println("-------------------------> Sensor execution");

        FileSystem fs = context.fileSystem();
        Settings settings = context.settings();
        for (InputFile javaFile : fs.inputFiles(fs.predicates().hasLanguage("java"))) {
            //set measures:
            context.<Double>newMeasure()
                    .forMetric(RANDOM)
                    .on(javaFile)
                    .withValue(Math.random())
                    .save();

            // create issues:
            NewIssue newIssue = context.newIssue()
                    .forRule(ExampleRules.RULE_ON_LINE_1)
                    // gap is used to estimate the remediation cost to fix the debt
                    .gap(3.0);
            NewIssueLocation primaryLocation = newIssue.newLocation()
                    .on(javaFile)
                    .at(javaFile.selectLine(1))
                    .message("You can't do anything. This is first line!");
            newIssue.at(primaryLocation);
            newIssue.save();
        }
    }
}

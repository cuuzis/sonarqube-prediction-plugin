package it.unibz.inf.prediction_plugin;

import org.sonar.api.web.page.Context;
import org.sonar.api.web.page.Page;
import org.sonar.api.web.page.PageDefinition;

public class ExamplePage implements PageDefinition {

    public void define(Context context) {
        //Key format: <plugin_key>/<page_id>
        context.addPage(Page.builder("predictions/global").setName("Prediciton plugin").build());
    }
}

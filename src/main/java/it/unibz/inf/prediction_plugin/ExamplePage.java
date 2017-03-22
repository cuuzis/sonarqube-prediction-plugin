package it.unibz.inf.prediction_plugin;

import org.sonar.api.web.page.Context;
import org.sonar.api.web.page.Page;
import org.sonar.api.web.page.PageDefinition;

public class ExamplePage implements PageDefinition {

    public void define(Context context) {



        context
                .addPage(Page.builder("unibzlab/my_page").setName("Prediciton plugin").build());
                //.addPage(Page.builder("my_plugin/another_page").setName("Another Page").build());
    }
}

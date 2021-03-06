package it.unibz.inf.prediction_plugin;

import org.sonar.api.rule.RuleKey;
import org.sonar.api.rule.RuleStatus;
import org.sonar.api.rule.Severity;
import org.sonar.api.server.rule.RulesDefinition;

public class ExampleRules implements RulesDefinition {

    public static final String REPOSITORY = "java-example";
    public static final String JAVA_LANGUAGE = "java";
    public static final RuleKey RULE_ON_LINE_1 = RuleKey.of(REPOSITORY, "line1");


    public void define(Context context) {
        NewRepository repository = context.createRepository(REPOSITORY, JAVA_LANGUAGE).setName("My Custom Java Analyzer");
        NewRule x1Rule = repository.createRule(RULE_ON_LINE_1.rule())
                .setName("Stupid rule")
                .setHtmlDescription("Generates an issue on every line 1 of Java files")
                // optional tags
                .setTags("code-smell", "stupid")
                // optional status. Default value is READY.
                .setStatus(RuleStatus.BETA)
                // default severity when the rule is activated on a Quality profile. Default value is MAJOR.
                .setSeverity(Severity.MAJOR);

        //http://javadocs.sonarsource.org/6.3/apidocs/org/sonar/api/server/debt/DebtRemediationFunction.Type.html#LINEAR
        x1Rule.setDebtRemediationFunction(x1Rule.debtRemediationFunctions().linearWithOffset("1h", "30min"));

        // don't forget to call done() to finalize the definition
        repository.done();
    }
}

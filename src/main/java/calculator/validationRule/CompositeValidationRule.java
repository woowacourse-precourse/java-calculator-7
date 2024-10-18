package calculator.validationRule;

import java.util.ArrayList;
import java.util.List;

public class CompositeValidationRule implements ValidationRule {
    private final List<ValidationRule> rules;

    public CompositeValidationRule(List<ValidationRule> rules) {
        this.rules = new ArrayList<>(rules);
    }

    @Override
    public void validate(String input) {
        rules.stream().forEach(rule -> {
                    if (rule.canHandle(input)) {
                        rule.validate(input);
                    }
                }
        );

    }

    @Override
    public boolean canHandle(String input) {

        return false;
    }

    public void addRule(ValidationRule rule) {
        rules.add(rule);
    }
}
package calculator.inputValidator;

import calculator.validationRule.ValidationRule;
import java.util.ArrayList;
import java.util.List;

public class InputValidatorV1 implements InputValidator {
    private final List<ValidationRule> rules;

    public InputValidatorV1(List<ValidationRule> rules) {
        this.rules = new ArrayList<>(rules);
    }

    @Override
    public void validate(String input) {
        rules.stream().forEach(rule -> rule.validate(input));
    }

    public void addRule(ValidationRule rule) {
        rules.add(rule);
    }

    
}

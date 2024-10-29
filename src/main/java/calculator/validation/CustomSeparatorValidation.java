package calculator.validation;

import calculator.model.domain.Separator;
import calculator.validation.customSeparator.CustomSeparatorNumberValidation;
import calculator.validation.customSeparator.CustomSeparatorRuleValidation;

public class CustomSeparatorValidation {
    private CustomSeparatorValidation() {
    }
    public static void validate(String inputString) {
        if (Separator.isCustomSeparator(inputString)) {
            CustomSeparatorRuleValidation.validate(inputString);
            CustomSeparatorNumberValidation.validate(inputString);

        }
    }


}

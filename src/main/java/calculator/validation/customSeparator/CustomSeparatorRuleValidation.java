package calculator.validation.customSeparator;

import calculator.validation.ErrorMesaage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomSeparatorRuleValidation {
    private CustomSeparatorRuleValidation() {
    }

    public static void validate(String inputString) {
        final List<Character> CUSTOM_SEPARATOR = new ArrayList<>(Arrays.asList('/','/','1','\\','n'));
        for (int i = 0; i < CUSTOM_SEPARATOR.size(); i++) {
            if (i == 2) {
                continue;
            }
            if(CUSTOM_SEPARATOR.get(i)!=inputString.charAt(i)) {
                throw new IllegalArgumentException(ErrorMesaage.CUSTOM_SEPARATOR_RULE.getMessage());
            }
        }
    }

}

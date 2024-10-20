package calculator.validator;

import java.util.List;

public interface Validator {

    boolean hasNegativeValue(List<Integer> list);

    boolean customDelimiterContains(String input);
    boolean isSpecialDelimiter(String string);
}

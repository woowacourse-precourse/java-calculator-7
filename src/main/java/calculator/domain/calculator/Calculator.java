package calculator.domain.calculator;

import java.util.*;

public class Calculator {

    private static final ArrayList<String> DEFAULT_DELIMITERS = new ArrayList<>(Arrays.asList(",", ":"));
    private final Validator validator;

    public Calculator(String input) {
        this.validator = new Validator();
    }

    public int sum() {
        return 0;
    }

}

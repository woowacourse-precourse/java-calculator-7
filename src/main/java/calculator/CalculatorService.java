package calculator;

import java.util.regex.Pattern;

public class CalculatorService {

    public CalculatorService() {
    }

    public boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    public long logic(String input) {

        if (isBlank(input)) {
            return 0;
        }

        return 1;
    }
}

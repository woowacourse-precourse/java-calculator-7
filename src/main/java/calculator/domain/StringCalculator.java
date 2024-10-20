package calculator.domain;

import calculator.util.Validator;
import java.util.List;

public class StringCalculator {

    private final InputProcessor inputProcessor = new InputProcessor();

    public long add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        List<String> tokens = inputProcessor.splitInput(input);
        Validator.validateNumbers(tokens);

        return tokens.stream()
                     .mapToLong(Long::parseLong)
                     .sum();
    }

}

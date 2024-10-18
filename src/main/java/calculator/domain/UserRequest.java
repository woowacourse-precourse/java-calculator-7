package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserRequest {
    private static final String CUSTOM_DELIMITER_PATTERN = "^//.*\\n$";

    private String input;

    public UserRequest(String input) {
        this.input = input;
        validate();
    }

    public List<Integer> extractNumbers() {
        try {
            return Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validate() {
        if (input.contains(" ")) {
            throw new IllegalArgumentException();
        }

        if (input.matches(CUSTOM_DELIMITER_PATTERN)) {
            String customDelimiter = input.substring(2, 3);
            input = input.substring(5);
            input = input.replace(customDelimiter, ",");
        }

        input = input.replace(":", ",");
    }
}

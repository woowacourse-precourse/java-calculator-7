package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Calculator {
    private String input;
    private String separatorRegex;

    Calculator(String input) {
        this.input = input.trim();
        this.separatorRegex = Regex.DEFAULT_SEPARATOR_REGEX.getPattern();
    }

    private void updateInput(String input) {
        this.input = input;
    }

    private void updateSeparatorRegex(String additionalSeparator) {
        if (additionalSeparator.isEmpty()) {
            return;
        }

        if (isSpecialCharacter(additionalSeparator)) {
            this.separatorRegex = this.separatorRegex
                    + Delimiter.OR.getValue()
                    + Delimiter.BRACKET_OPEN.getValue()
                    + additionalSeparator
                    + Delimiter.BRACKET_CLOSE.getValue();
        } else {
            this.separatorRegex = this.separatorRegex
                    + Delimiter.OR.getValue()
                    + additionalSeparator;
        }
    }

    public Integer caculate() {
        List<String> strs = extract();

        List<Integer> numbers = convert(strs);

        Integer result = sum(numbers);

        return result;
    }

    private List<String> extract() {
        List<String> strings = new ArrayList<>();

        if (input.isEmpty()) {
            return strings;
        }

        Optional<String> customSeparator = Validator.checkCustomSeparator(input);
        if (customSeparator.isPresent()) {
            updateSeparatorRegex(customSeparator.get());

            int startIdx = input.indexOf(Delimiter.CUSTOM_SEPARATOR_END.getValue())
                    + Delimiter.CUSTOM_SEPARATOR_END.getValue().length();
            updateInput(input.substring(startIdx));
        }

        strings = Arrays.stream(input.split(separatorRegex))
                .toList();

        return strings;
    }

    private List<Integer> convert(List<String> strs) {
        Validator.checkString(strs);

        List<Integer> numbers = strs.stream()
                .filter(s -> !s.isEmpty() && !s.isBlank())
                .map(Integer::parseInt)
                .toList();

        return numbers;
    }

    private Integer sum(List<Integer> numbers) {
        Integer result = 0;

        result = numbers.stream()
                .reduce(result, Integer::sum);

        return result;
    }

    private boolean isSpecialCharacter(String str) {
        if (str.matches(Regex.SPECIAL_CHARACTER_REGEX.getPattern())) {
            return true;
        } else {
            return false;
        }
    }
}

package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public enum InputPattern {
    TYPE_A(Pattern.compile("[0-9,:]*$"), -1, -1), // -1은 쓰지 않음을 의미
    TYPE_B(Pattern.compile("^//(.)\\\\n([0-9,:]|\\1)*$"), 5, 2);

    private final Pattern pattern;
    private final int numberIndex;
    private final int separatorIndex;

    InputPattern(Pattern pattern, int numberIndex, int separatorIndex) {
        this.pattern = pattern;
        this.numberIndex = numberIndex;
        this.separatorIndex = separatorIndex;
    }

    public int getNumberIndex() {
        return numberIndex;
    }

    public int getSeparatorIndex() {
        return separatorIndex;
    }

    public boolean matches(String input) {
        return pattern.matcher(input).matches();
    }

    public static InputPattern match(String input) {
        return Arrays.stream(InputPattern.values())
                .filter(inputType -> inputType.matches(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown input pattern: Value does not belong to any type."));
    }

    public String extractNumbers(String input) {
        if (this.equals(TYPE_A)) {
            validate(input);
            return input;
        } else if (this.equals(TYPE_B)) {
            String numbers = input.substring(getNumberIndex());
            validate(numbers);
            return numbers;
        }
        throw new IllegalArgumentException("Unknown input pattern: Value does not belong to any type.");
    }

    public List<String> getSeparators(String input) {
        List<String> separators = new ArrayList<>(Arrays.asList(",", ":"));
        if (this == TYPE_B) {
            separators.add(String.valueOf(input.charAt(getSeparatorIndex())));
        }
        return separators;
    }

    private void validate(String numbers) { // 구분자가 연속으로 등장할 경우 exception
        for (int i = 0; i < numbers.length() - 1; i++) {
            if (!Character.isDigit(numbers.charAt(i)) && !Character.isDigit(numbers.charAt(i + 1))) {
                throw new IllegalArgumentException("Unknown input pattern: Separators appear consecutively.");
            }
        }
    }
}
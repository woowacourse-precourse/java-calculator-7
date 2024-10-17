package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public enum InputPattern {
    TYPE_A(Pattern.compile("[0-9,:]*$"), -1, -1),
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
                .orElseThrow(() -> new IllegalArgumentException("Unknown input pattern"));
    }

    public String extractNumbers(String input) {
        if (this.equals(TYPE_A)) {
            return input;
        } else if (this.equals(TYPE_B)) {
            return input.substring(getNumberIndex());
        }
        throw new IllegalArgumentException("Unknown input pattern");
    }

    public List<String> getSeparators(String input) {
        List<String> separators = new ArrayList<>(Arrays.asList(",", ":"));
        if (this == TYPE_B) {
            separators.add(String.valueOf(input.charAt(getSeparatorIndex())));
        }
        return separators;
    }
}
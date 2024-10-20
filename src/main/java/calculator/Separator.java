package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    public int[] separateInput(String input) {
        String separators = Constant.BASIC_SEPARATOR;
        String pattern = Constant.INPUT_PATTERN;
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);

        if (!m.find()) {
            throw new IllegalArgumentException();
        }

        if (!(m.group(1) == null)) {
            separators = buildSeparators(m.group(1));
        }
        return separateNums(m.group(2), separators);
    }

    private int[] separateNums(String input, String separators) {
        String[] stringNums = input.split(separators);
        return Arrays.stream(stringNums).mapToInt(this::stringToInt).toArray();
    }

    private String buildSeparators(String customSeparators) {
        String basicSeparators = Constant.BASIC_SEPARATOR;
        customSeparators = customSeparators.replace("\\n", "");
        customSeparators = customSeparators.replace("//", "|");
        return basicSeparators + customSeparators;
    }

    private int stringToInt(String stringNum) {
        if (stringNum.isBlank()) {
            return 0;
        }
        try {
            return Integer.parseInt(stringNum);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}

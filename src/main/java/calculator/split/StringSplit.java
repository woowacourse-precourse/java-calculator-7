package calculator.split;

import static calculator.validate.StringValidate.isInputStartWithSlash;
import static calculator.validate.StringValidate.validateCalFormula;
import static calculator.validate.StringValidate.validateNewLineInput;
import static calculator.validate.StringValidate.validateSeperator;

import java.util.Arrays;
import java.util.Objects;

public class StringSplit {
    private static final String REGEX = "(\\\\n|\\n)";
    private static final String DEFAULT_SEPARATOR = ",:";

    public static String getSeparator(final String string) {
        if (isInputStartWithSlash(string)) {
            validateNewLineInput(string);
            String[] split = string.split(REGEX);
            return split[0].substring(2).concat(DEFAULT_SEPARATOR);
        }
        return DEFAULT_SEPARATOR;
    }

    public static String getCalFormula(final String string) {
        String[] split = string.split(REGEX, 2);
        if (split.length > 1) {
            return split[1];
        }
        return string;
    }

    public static int[] splitCalFormulaBySeparator(final String calFormula, final String separator) {
        validateSeperator(separator);
        validateCalFormula(calFormula, separator);
        return Arrays.stream(calFormula.split(String.format("[%s]", separator), -1))
                .mapToInt(StringSplit::stringToNumber)
                .toArray();
    }

    public static int stringToNumber(final String strNum) {
        if (Objects.equals(strNum, "")) {
            return 0;
        }
        return Integer.parseInt(strNum);
    }

}

package calculator.split;

import java.util.Arrays;
import java.util.Objects;

public class StringSplit {
    public static String getCustomSeparator(String string) {
        String[] split = string.split("\n");
        return split[0].substring(2).concat(",:");
    }

    public static String getCustomCalFormula(String string) {
        String[] split = string.split("\n", 2);
        return split[1];
    }

    public static String getDefaultSeparator() {
        return ",:";
    }

    public static String getDefaultCalFormula(String string) {
        return string;
    }

    public static int[] splitCalFormulaBySeparator(String calFormula, String separator) {
        return Arrays.stream(calFormula.split(String.format("[%s]", separator), -1))
                .mapToInt(StringSplit::stringToNumber)
                .toArray();
    }

    public static int stringToNumber(String strNum) {
        if (Objects.equals(strNum, "")) {
            return 0;
        }
        return Integer.parseInt(strNum);
    }

}

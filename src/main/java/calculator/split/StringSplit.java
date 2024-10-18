package calculator.split;

import java.util.Arrays;
import java.util.Objects;

public class StringSplit {
    public static String getFrontString(String string) {
        String[] split = string.split("\n");
        return split[0].substring(2);
    }

    public static String getBackString(String string) {
        String[] split = string.split("\n", 2);
        return split[1];
    }

    public static int[] splitStringBySeparator(String string, String separator) {
        return Arrays.stream(string.split(String.format("[%s]", separator), -1))
                .mapToInt(StringSplit::stringToNumber)
                .toArray();
    }

    public static int stringToNumber(String string) {
        if (Objects.equals(string, "")) {
            return 0;
        }
        return Integer.parseInt(string);
    }

}

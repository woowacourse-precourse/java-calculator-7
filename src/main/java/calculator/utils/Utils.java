package calculator.utils;

import calculator.domain.Calculator;

public class Utils {

    public static void addCustomDelimiters(Calculator list, String s) {
        if (s.startsWith("//")) {
            char[] ss = extractDelimitersFromHeader(s);
            for (char c : ss) {
                list.delimiters.add(c);
            }
        }
    }

    private static char[] extractDelimitersFromHeader(String s) {
        String ss = s.substring(2);
        String[] split = ss.split("\\\\n");
        return split[0].toCharArray();
    }

    public static String extractCalculationString(String s) {
        String[] split = s.split("\\\\n");
        return split[1];
    }
}

package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    /**
     * 구분자 목록
     */
    public static List<String> separators = new ArrayList<>();
    public static String input = "";
    public static final String customSeparatorSymbol1 = "//";
    public static final String customSeparatorSymbol2 = "\\n";

    public static void main(String[] args) {
        Application app = new Application();
        app.initSeparator();

        input = Console.readLine();
        app.addSeparator(app.getCustomSeparator(input));
        System.out.println(app.calc(app.splitString()));
    }

    private void initSeparator() {
        separators.add(",");
        separators.add(":");
    }

    private char getCustomSeparator(String input) {
        int firstTokenIdx = input.indexOf(customSeparatorSymbol1);
        int lastTokenIdx = input.lastIndexOf(customSeparatorSymbol2);

        if (firstTokenIdx == -1 || lastTokenIdx == -1) {
            throw new IllegalArgumentException();
        }

        if (((firstTokenIdx + 1) - (lastTokenIdx - 1)) > 1) {
            throw new IllegalArgumentException();
        }

        char customSeparator = input.charAt(lastTokenIdx - 1);
        removeRangeString(firstTokenIdx, lastTokenIdx + 2);
        return customSeparator;
    }

    private void removeRangeString(int start, int end) {
        StringBuilder sb = new StringBuilder(input);
        sb.delete(start, end);
        input = sb.toString();
    }

    private void addSeparator(char separator) {
        separators.add(String.valueOf(separator));
    }

    private String[] splitString() {
        return input.split(String.join("|", separators));
    }

    private int calc(String[] lst) {
        int result = 0;

        for (String separator : lst) {
            try {
                int parseNumber = Integer.parseInt(separator);
                if (parseNumber < 0) {
                    throw new IllegalArgumentException();
                }
                result += parseNumber;
            } catch (NumberFormatException ex) {
                throw new NumberFormatException();
            }
        }

        return result;
    }
}
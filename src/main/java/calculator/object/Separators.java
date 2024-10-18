package calculator.object;

import java.util.ArrayList;
import java.util.List;

public class Separators {

    private static final List<Character> DEFAULT_SEPARATORS = List.of(',', ':');
    private static final String SEPARATOR_HEADER = "//";
    private static final String SEPARATOR_FOOTER = "\\n";

    private final String customSeparator;
    private final List<Character> separators;

    public Separators(String inputFormula) {
        if (isNotIncludedHeaderOrFooter(inputFormula)) {
            customSeparator = "";
            separators = DEFAULT_SEPARATORS;
            return;
        }

        customSeparator = getCustomSeparatorFrom(inputFormula);
        separators = makeSeparatorsWith(customSeparator);
    }

    public static String getSeparatorFooter() {
        return SEPARATOR_FOOTER;
    }

    public boolean isCustomSeparatorEmpty() {
        return "".equals(customSeparator);
    }

    public boolean contains(char target) {
        return separators.contains(target);
    }

    @Override
    public String toString() {
        return customSeparator;
    }

    private static boolean isNotIncludedHeaderOrFooter(String inputFormula) {
        return !inputFormula.contains(SEPARATOR_HEADER) || inputFormula.indexOf(SEPARATOR_FOOTER) <= 0;
    }

    private static String getCustomSeparatorFrom(String inputFormula) {
        int startIndexOfCustomSeparator = SEPARATOR_HEADER.length();
        int nextIndexOfCustomSeparator = inputFormula.indexOf(SEPARATOR_FOOTER);
        String nowSeparator = inputFormula.substring(startIndexOfCustomSeparator, nextIndexOfCustomSeparator);
        if (nowSeparator.length() != 1) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자가 입력되었습니다.");
        }
        return nowSeparator;
    }

    private static List<Character> makeSeparatorsWith(String customSeparator) {
        List<Character> separators = new ArrayList<>(DEFAULT_SEPARATORS);
        separators.add(customSeparator.charAt(0));
        return List.copyOf(separators);
    }

}

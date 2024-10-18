package calculator.object;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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

    private static boolean isNotIncludedHeaderOrFooter(String inputFormula) {
        return !inputFormula.contains(SEPARATOR_HEADER) || inputFormula.indexOf(SEPARATOR_FOOTER) <= 0;
    }

    private static String getCustomSeparatorFrom(String inputFormula) {
        int startIndexOfCustomSeparator = SEPARATOR_HEADER.length();
        String nowSeparator = new StringTokenizer(inputFormula, SEPARATOR_FOOTER)
                .nextToken()
                .substring(startIndexOfCustomSeparator);
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

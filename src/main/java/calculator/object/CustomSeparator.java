package calculator.object;

public class CustomSeparator {

    private static final String SEPARATOR_HEADER = "//";
    private static final String SEPARATOR_FOOTER = "\\n";

    private final String customSeparator;

    public CustomSeparator(String inputFormula) {
        if (isNotIncludedHeaderOrFooter(inputFormula)) {
            this.customSeparator = "";
            return;
        }

        this.customSeparator = getSeparatorFrom(inputFormula);
    }

    public boolean isExists() {
        return "".equals(customSeparator);
    }

    public char toChar() {
        return customSeparator.charAt(0);
    }

    public static String getSeparatorFooter() {
        return SEPARATOR_FOOTER;
    }

    private static boolean isNotIncludedHeaderOrFooter(String inputFormula) {
        return !inputFormula.contains(SEPARATOR_HEADER) || inputFormula.indexOf(SEPARATOR_FOOTER) <= 0;
    }

    private static String getSeparatorFrom(String inputFormula) {
        String nowSeparator = inputFormula.substring(SEPARATOR_HEADER.length(), inputFormula.indexOf(SEPARATOR_FOOTER));
        if (nowSeparator.length() != 1) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자가 입력되었습니다.");
        }
        return nowSeparator;
    }

    @Override
    public String toString() {
        return customSeparator;
    }

}

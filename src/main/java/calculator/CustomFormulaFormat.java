package calculator;

public enum CustomFormulaFormat {
    FIRST("//"), LAST("\\n");

    CustomFormulaFormat(String format) {
        this.format = format;
    }

    private final String format;

    public static boolean hasFirstFormat(String formula) {
        return formula.startsWith(FIRST.format);
    }

    public static boolean hasLastFormat(String formula, int idx) {
        return formula.indexOf(LAST.format) == idx;
    }

}

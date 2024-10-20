package calculator.extract;

public enum ExtractSeparator {
    SEPARATOR_1("//", "\\n");

    private String startSeparators;
    private String endSeparators;

    ExtractSeparator(String startSeparators, String endSeparators) {
        this.startSeparators = startSeparators;
        this.endSeparators = endSeparators;
    }

    public String getStartSeparators() {
        return startSeparators;
    }

    public String getEndSeparators() {
        return endSeparators;
    }
}

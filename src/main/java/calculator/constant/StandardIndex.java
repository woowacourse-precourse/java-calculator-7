package calculator.constant;

public enum StandardIndex {
    FIRST_STANDARD("//"),
    SECOND_STANDARD("\\n");

    private final String standard;

    StandardIndex(String standard) {
        this.standard = standard;
    }

    public String getStandard() {
        return standard;
    }
}

package calculator;

public enum Delimiter {
    DEFAULT("[,:]"),
    CUSTOM("^(//)(.)(\\\\n).*"),
    CUSTOM_REPLACE("^(//)(.)(\\\\n)"),
    CUSTOM_DELIM("^(//)|(\\\\n).*")
    ;

    private String regex;

    Delimiter(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}

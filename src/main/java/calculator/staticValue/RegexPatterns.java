package calculator.staticValue;

public enum RegexPatterns {


    CUSTOM_SEPARATOR_PREFIX("//"),
    CUSTOM_SEPARATOR_SUFFIX("\\\\n"),

    CUSTOM_SEPARATOR("//(.*?)\\\\n"),

    BASIC_SEPARATORS(",|:"),
    INVALID_CHAR("([a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣])"),
    POSITIVE_NUMBER("([1-9]+)");

    final String stringValue;

    RegexPatterns(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getValue() {
        return stringValue;
    }


}

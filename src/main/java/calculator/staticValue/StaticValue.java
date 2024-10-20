package calculator.staticValue;

public enum StaticValue {


    CUSTOM_SEPARATOR_PREFIX("//"),
    CUSTOM_SEPARATOR_SUFFIX("\\\\n"),

    CUSTOM_SEPARATOR_REGEX("//(.*?)\\\\n"),

    BASIC_SEPARATORS_REGEX(",|:"),
    INVALID_CHAR_REGEX("([a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣])"),
    POSITIVE_NUMBER_REGEX("([1-9]+)");

    final String stringValue;

    StaticValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getValue() {
        return stringValue;
    }


}

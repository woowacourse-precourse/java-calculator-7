package calculator.domain;

public enum RegexType {
    CUSTOM_SEPERATOR("^//(.)\\\\n{1}(.*)"),
    NUMBER("[0-9]{0,}");

    String regex;

    RegexType(String regex) {
        this.regex=regex;
    }
}

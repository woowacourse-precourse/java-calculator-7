package calculator;

public class DelimiterExtractor {

    private String text;

    public DelimiterExtractor(String text) {
        this.text = text;
    }

    public static boolean hasDelimiter(String regex, String text) {
        String result = text.replaceAll(regex, " ");
        return !result.isBlank();
    }

    public DelimiterType type() {
        final String LINE_BREAK = "\\n";

        if (this.text.split(LINE_BREAK).length > 1) {
            return DelimiterType.CUSTOM;
        }

        return DelimiterType.BASIC;
    }

    public String remove(String regex) {
        if (DelimiterType.BASIC.equals(this.type())) {
            return remove(regex, this.text);
        }

        return remove(regex, "");
    }

    private String remove(String regex, String target) {
        return target.replaceAll(regex, " ");
    }
}

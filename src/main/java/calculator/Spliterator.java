package calculator;

public class Spliterator {
    private final String defaultRegex;

    public Spliterator(String regex) {
        this.defaultRegex = regex;
    }

    public String[] split(String input) {
        return input.split(defaultRegex);
    }

    public String[] split(String input, String extraRegex) {
        return input.split(extraRegex.isBlank() ? defaultRegex : defaultRegex + "|" + extraRegex);
    }
}

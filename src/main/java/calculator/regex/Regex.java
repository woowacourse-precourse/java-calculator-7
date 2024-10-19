package calculator.regex;

public class Regex {

    private final StringBuilder regex;

    public Regex(final String regex) {
        this.regex = new StringBuilder(regex);
    }

    public void add(final String value) {
        regex.append('|').append(escapeMetaCharacter(value));
    }

    private StringBuilder escapeMetaCharacter(final String letters) {
        StringBuilder value = new StringBuilder();

        for (char c : letters.toCharArray()) {
            if (MetaCharacter.isMetaCharacter(c)) {
                value.append("\\").append(c);
                continue;
            }
            value.append(c);
        }

        return value;
    }

    public String getRegex() {
        return new String(regex);
    }

}

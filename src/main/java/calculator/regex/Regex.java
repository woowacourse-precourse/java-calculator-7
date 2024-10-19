package calculator.regex;

import static java.util.regex.Pattern.quote;

public class Regex {

    public static final String OR = "|";
    
    private final StringBuilder regex;

    public Regex(final String regex) {
        this.regex = new StringBuilder(regex);
    }

    public void add(final String value) {
        regex.append(OR).append(quote(value));
    }

    public String getRegex() {
        return regex.toString();
    }

}

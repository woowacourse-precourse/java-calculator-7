package calculator.domain;

import java.util.regex.Pattern;

public class Delimiter {

    private static final Pattern DEFAULT = Pattern.compile("[\\d*,|:?]*");
    private static final Pattern CUSTOM = Pattern.compile("//(.)+\n(.)*");

    public boolean isDefault(final String input) {
        return DEFAULT.matcher(input)
                .matches();
    }

    public boolean isCustom(final String input) {
        return CUSTOM.matcher(input)
                .matches();
    }

}

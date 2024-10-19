package calculator.domain;

import java.util.regex.Pattern;

public class Delimiter {

    private static final Pattern DEFAULT = Pattern.compile("[\\d*,|:?]*");

    public boolean isDefault(final String input) {
        return DEFAULT.matcher(input)
                .matches();
    }

}

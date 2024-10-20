package calculator.util;

import calculator.domain.CalcTarget;

public class CustomSeparatorRegister {
    private static final String REGISTER_PREFIX = "//";
    private static final String REGISTER_SUFFIX = "\\n";

    public static CalcTarget registerCustomSeparator(String input) {
        if (!input.startsWith(REGISTER_PREFIX)) {
            return CalcTarget.registCustomSeparator(input, null);
        }
        int start = input.indexOf(REGISTER_PREFIX) + REGISTER_PREFIX.length();
        int end = input.indexOf(REGISTER_SUFFIX, start);

        String customSeparator = input.substring(start, end);
        String value = input.substring(end + REGISTER_SUFFIX.length());

        return CalcTarget.registCustomSeparator(value, customSeparator);
    }
}

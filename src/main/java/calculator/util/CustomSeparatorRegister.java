package calculator.util;

import calculator.domain.CalcTarget;

public class CustomSeparatorRegister {
    private static final String REGISTER_PREFIX = "//";
    private static final String REGISTER_SUFFIX = "\\n";

    public static CalcTarget registerCustomSeparator(CalcTarget input) {
        if (!input.getValue().startsWith(REGISTER_PREFIX)) {
            input.registCustomSeparator(input.getValue(), null);
            return input;
        }
        int start = input.getValue().indexOf(REGISTER_PREFIX) + REGISTER_PREFIX.length();
        int end = input.getValue().indexOf(REGISTER_SUFFIX, start);

        String customSeparator = input.getValue().substring(start, end);
        String value = input.getValue().substring(end + REGISTER_SUFFIX.length());

        if (value.isEmpty()){
            value = "0";
        }

        input.registCustomSeparator(value, customSeparator);
        return input;
    }
}

package calculator.common.util;

import static calculator.common.constant.Constants.CUSTOM_SEPARATOR_PREFIX;
import static calculator.common.constant.Constants.CUSTOM_SEPARATOR_SUFFIX;

import calculator.model.Separator;

public class CustomSeparatorParser {

    private static final int prefixSize = CUSTOM_SEPARATOR_PREFIX.length();

    public static boolean hasCustomSeparator(String message) {
        return message.startsWith(CUSTOM_SEPARATOR_PREFIX)
                && message.substring(prefixSize).contains(CUSTOM_SEPARATOR_SUFFIX);
    }

    public static Separator extractSeparator(String message) {
        return Separator.from(message.substring(prefixSize, message.indexOf(CUSTOM_SEPARATOR_SUFFIX)));
    }
}

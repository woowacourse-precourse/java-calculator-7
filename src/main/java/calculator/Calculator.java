package calculator;

public class Calculator {
    public static String execute(String value) {
        if (validation(value).isEmpty()) {
            return "0";
        }

        String separator = initSeparator(value);
        String originalText = initOriginalText(value);

        return CalculatorUtils.integerToString(sum(CalculatorUtils.split(originalText, separator)));
    }

    private static int sum(String[] strings) {
        int sum = 0;
        for (String str : strings) {
            try {
                sum += Integer.parseUnsignedInt(str);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }

        return sum;
    }

    private static String findCustomSeparator(String value) {
        int separatorIndex = value.indexOf(CalculatorUtils.SUFFIX_CUSTOM_SEPARATOR);

        return value.substring(2, separatorIndex);
    }

    private static boolean isCustomSeparator(String value) {
        return value.startsWith(CalculatorUtils.PREFIX_CUSTOM_SEPARATOR) && value.contains(
                CalculatorUtils.SUFFIX_CUSTOM_SEPARATOR);
    }

    private static String findOriginalText(String value) {
        int originalTextIndex = value.indexOf(CalculatorUtils.SUFFIX_CUSTOM_SEPARATOR) + 2;

        return value.substring(originalTextIndex);
    }

    private static String initSeparator(String value) {
        String separator = CalculatorUtils.BASIC_SEPARATOR;

        if (isCustomSeparator(value)) {
            separator = findCustomSeparator(value);
        }

        return separator;
    }

    private static String initOriginalText(String value) {
        String originalText = "";
        if (isCustomSeparator(value)) {
            originalText = findOriginalText(value);
        }

        return originalText;
    }

    private static String validation(String value) {
        if (value == null || value.trim().isEmpty()) {
            return value;
        }

        return value.trim();
    }

}

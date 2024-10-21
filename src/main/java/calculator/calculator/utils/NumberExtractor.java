package calculator.calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberExtractor {

    public static final String DEFAULT_SEPARATOR = "[,:]+";
    public static final String CUSTOM_SEPARATOR = "//(.*?)\\n";

    public int[] extractNumbersWithDefaultSeparator(String source) {
        String[] extractNumbers = source.split(DEFAULT_SEPARATOR);

        int size = extractNumbers.length;
        int[] numbers = new int[size];
        try {
            for (int i = 0; i < size; i++) {
                numbers[i] = Integer.parseInt(extractNumbers[i]);
            }
        }catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }


        return numbers;
    }


    public int[] extractNumbersWithCustomSeparator(String source) {
        Pattern pattern = Pattern.compile(CUSTOM_SEPARATOR);
        Matcher matcher = pattern.matcher(source);

        String customRegex = "[";
        if (matcher.find()) {
            customRegex += matcher.group(1);
        }
        customRegex += "]+";

        int beginIndex = matcher.group().length();
        String validSource = source.substring(beginIndex);
        String[] extractNumbers = validSource.split(customRegex);

        int size = extractNumbers.length;
        int[] numbers = new int[size];
        try {
            for (int i = 0; i < size; i++) {
                numbers[i] = Integer.parseInt(extractNumbers[i]);
            }
        }catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        return numbers;
    }
}

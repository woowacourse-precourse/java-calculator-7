package calculator.calculator.utils;

public class NumberExtractor {

    public static final String DEFAULT_SEPARATOR = "[,:]+";

    public int[] extractNumbersWithDefaultSeparator(String source) {
        String[] extractNumbers = source.split(DEFAULT_SEPARATOR);

        int size = extractNumbers.length;
        int[] numbers = new int[size];
        try {
            for (int i = 0; i < size; i++) {
                numbers[i] = Integer.parseInt(extractNumbers[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }


        return numbers;
    }


    public int[] extractNumbersWithCustomSeparator(String source) {
        int start = source.indexOf("//") + 2;
        int end = source.indexOf("\\n");

        String delimiter = "";
        if (start != -1 && end != -1) {
            delimiter = source.substring(start, end);
        }

        String customRegex = new StringBuilder().append("[").append(delimiter).append("]+").toString();

        String validSource = source.substring(end + 2);
        String[] extractNumbers = validSource.split(customRegex);

        int size = extractNumbers.length;
        int[] numbers = new int[size];
        try {
            for (int i = 0; i < size; i++) {
                numbers[i] = Integer.parseInt(extractNumbers[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        return numbers;
    }
}

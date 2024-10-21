package calculator;

public class NumberExtractor {
    private static final String DEFAULT_DELIMITER = "[,:]";
    // private static final String CUSTOM_DELIMITER_PREFIX = "//";
    // private static final String CUSTOM_DELIMITER_SUFFIX = "\n";

    public static int[] extractNumbers(String inputData) {
        /*
        if (inputData.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterEndIndex = inputData.indexOf(CUSTOM_DELIMITER_SUFFIX);
            if (delimiterEndIndex != -1) {
                String customDelimiter = inputData.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterEndIndex);
                String updatedInputData = inputData.substring(delimiterEndIndex + CUSTOM_DELIMITER_SUFFIX.length());
            }
        }
        */

        String[] splitNumbers = inputData.split(DEFAULT_DELIMITER);
        int[] extractedNumbers = new int[splitNumbers.length];

        int extractedIndex = 0;
        for (String splitNumber : splitNumbers) {
            extractedNumbers[extractedIndex++] = Integer.parseInt(splitNumber.trim());
        }

        return extractedNumbers;
    }
}

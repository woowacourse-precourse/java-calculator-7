package calculator;

public class NumberExtractor {
    private static final String DEFAULT_DELIMITER = "[,:]";

    public static int[] extractNumbers(String inputData) {
        String[] splitNumbers = inputData.split(DEFAULT_DELIMITER);
        int[] extractedNumbers = new int[splitNumbers.length];

        int extractedIndex = 0;
        for (String splitNumber : splitNumbers) {
            extractedNumbers[extractedIndex++] = Integer.parseInt(splitNumber.trim());
        }

        return extractedNumbers;
    }
}

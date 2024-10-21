package calculator;

public class StringCalculator {
    private final DelimiterExtractor delimiterExtractor;
    private final ArrayBuilder arrayBuilder;

    public StringCalculator() {
        this.delimiterExtractor = new DelimiterExtractor();
        this.arrayBuilder = new ArrayBuilder();
    }


    public int calculate(String numbers) {
        if (isEmpty(numbers)) {
            return 0;
        }
        // String[] array = delimiterExtractor.getDelimiter(numbers);

        // parsing, extract, -> 구분자 추출 및 numberPart parsing
        String delimiter = delimiterExtractor.getDelimiter(numbers);
        if (delimiterExtractor.checkDelimiter(delimiter)) {
            int delimiterEndIndex = delimiterExtractor.getDelimiterEndIndex(numbers);
            String strNumbers = arrayBuilder.getStrNumbers(numbers, delimiterEndIndex);
            String[] splitCustomNumbers = getCustomSplitNumbers(strNumbers, delimiter);
            return calculateSum(splitCustomNumbers);
        }

        String[] splitNumbers = getSplitNumbers(numbers, delimiter);
        return calculateSum(splitNumbers);
    }

    private String[] getSplitNumbers(String numbers, String delimiter) {

        return numbers.split(delimiter);
    }

    private String[] getCustomSplitNumbers(String splitArray, String delimiter) {
        return splitArray.split(delimiter);
    }

    private boolean isEmpty(String numbers) {
        return numbers.isEmpty();
    }

    private int calculateSum(String[] splitNumbers) {
        int sum = 0;
        for (String splitNum : splitNumbers) {
            int number = NumberValidator.validate(splitNum);
            sum += number;
        }
        return sum;
    }
}

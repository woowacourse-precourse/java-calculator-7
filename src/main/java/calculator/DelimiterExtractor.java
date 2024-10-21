package calculator;

public class DelimiterExtractor {
    private final ArrayBuilder arrBuilder = new ArrayBuilder();
    private final NumberCalculator numberCalculator = new NumberCalculator();

    private String delimiter = ":|,";
    private int delimiterEndIndex;

    public int getResult(String numbers) {
        if (isCustomDelimiter(numbers)) {
            this.delimiterEndIndex = getDelimiterEndIndex(numbers);
            if (delimiterEndIndex != -1) {
                this.delimiter = numbers.substring(2, delimiterEndIndex);
            }
        }
        String strNumbers = arrBuilder.getStrNumbers(numbers, delimiterEndIndex);
        String[] splitCustomNumbers = arrBuilder.getSplitNumbers(strNumbers, delimiter);
        return numberCalculator.calculateSum(splitCustomNumbers);
    }

    private boolean isCustomDelimiter(String numbers) {
        return numbers.startsWith("//");
    }

    public int getDelimiterEndIndex(String numbers) {
        return numbers.indexOf("\\n");
    }

}
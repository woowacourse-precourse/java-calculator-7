package calculator.strategy;

public class CustomDelimiterExtractionStrategy implements ExtractionStrategy {

    @Override
    public int[] extract(String input) {
        int delimiterIndex = input.indexOf("\\n");
        if (delimiterIndex > 2) {
            String delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 2);

            String[] stringArr = input.split(delimiter);
            int[] numbers = new int[stringArr.length];
            for (int i = 0; i < stringArr.length; i++) {
                int num;
                try {
                    num = Integer.parseInt(stringArr[i]);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();
                }
                if (num < 0) {
                    throw new IllegalArgumentException();
                }
                numbers[i] = num;
            }
            return numbers;
        } else {
            throw new IllegalArgumentException();
        }
    }
}

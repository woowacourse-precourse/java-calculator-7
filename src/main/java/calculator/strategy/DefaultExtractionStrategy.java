package calculator.strategy;


public class DefaultExtractionStrategy implements ExtractionStrategy {

    private static final String DEFAULT_DELIMITER = ",|:";

    @Override
    public int[] extract(String input) {
        String[] stringArr = input.split(DEFAULT_DELIMITER);
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
    }
}

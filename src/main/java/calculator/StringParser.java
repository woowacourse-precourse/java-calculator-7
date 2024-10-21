package calculator;

public class StringParser {

    public String[] parseString(String inputString) throws IllegalArgumentException {
        NumberExtractor numberExtractor = new NumberExtractor();
        String[] numbers = numberExtractor.extractNumbers(inputString);
        isMinusNumberUsed(numbers);

        return numbers;
    }

    static void isMinusNumberUsed(String[] numbers) {
        for (String number : numbers) {
            if (number.contains("-")) {
                throw new IllegalArgumentException();
            }
        }
    }
}

package calculator;

public class StringCalculator {
    private final DelimiterParser delimiterParser;

    public StringCalculator(DelimiterParser delimiterParser) {
        this.delimiterParser = delimiterParser;
    }

    public int add(String input) {
        String split = delimiterParser.parse(input);
        String numbers = delimiterParser.extractNumbers(input);
        String[] splitNumbers = delimiterParser.split(numbers, split);

        return calculateSum(splitNumbers);
    }

    private int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            try{
                int parsedNumber = Integer.parseInt(number);
                sum += parsedNumber;
            } catch (NumberFormatException e){
                throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
            }
        }
        return sum;
    }
}

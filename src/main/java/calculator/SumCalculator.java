package calculator;

public class SumCalculator {

    public int sum(String inputString) {
        int result = 0;
        StringParser stringParser = new StringParser();
        String[] numbers = stringParser.parseString(inputString);

        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}

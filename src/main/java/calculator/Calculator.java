package calculator;

public class  Calculator {
    public int calculate(String input) {

        StringFilter stringFilter = new StringFilter();

        if (input.isEmpty())
            return 0;

        if (input.length() == 1)
            return Integer.parseInt(input);

        String[] numbers = stringFilter.StringController(input);
        int sum = 0;

        for (String numberStr : numbers) {
            sum += Integer.parseInt(numberStr);
        }
        return sum;
    }
}

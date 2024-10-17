package calculator;

public class Calculator {

    public long calculate(String input) {
        if(input.equals("")) {
            return 0;
        }
        String delimiter = ",|:";
        if(input.contains("//")) {
            String[] customInput = input.split("\\\\n");
            delimiter += "|" + customInput[0].substring(2);
            input = customInput[1];
        }
        String[] numbers = input.split(delimiter);

        return performAddition(numbers);
    }
    private long performAddition(String[] numbers) {
        long result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}

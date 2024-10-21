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
            if(!isPositive(number)) {
                throw new IllegalArgumentException();
            }
            result += Integer.parseInt(number);
        }
        return result;
    }
    private boolean isPositive(String number) {
        if(number == null) {
            return false;
        }
        try {
            return Integer.parseInt(number) >= 0;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}

package calculator.model;

public class CalculatorServiceImpl implements CalculatorService {

    private String delimiter = ",|:";

    @Override
    public Integer calculate(String input) {
        boolean isCustom = input.startsWith("//");
        if (isCustom) {
            delimiter = delimiter.concat("|" + input.charAt(2));
            input = input.substring(5);
            System.out.println(delimiter);
        }
        String[] numberList = input.split(delimiter);

        int result = 0;

        for (String number : numberList) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}

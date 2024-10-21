package calculator;

public class StringCalculator {
    public static int calculate(String str){
        String[] numbers = InputParser.stringParse(str);
        Validator.validateInput(numbers);
        Validator.validateNegativeNumbers(numbers);
        return sum(numbers);
    }
    public static int sum(String[] numbers){
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i]);
        }
        return sum;
    }
}

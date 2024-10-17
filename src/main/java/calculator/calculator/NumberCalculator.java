package calculator.calculator;

public class NumberCalculator {
    public static int calc(String[] numbers){
        int sum = 0;
        for(String number : numbers){
            int parsedNumber = parseNumber(number);
            sum += parsedNumber;
        }
        return sum;
    }

    private static int parseNumber(String number){
        // TODO: num 숫자 형식 검증
        return Integer.parseInt(number);
    }
}

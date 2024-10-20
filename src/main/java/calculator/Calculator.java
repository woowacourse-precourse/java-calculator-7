package calculator;

public class Calculator {

    public int calculate(String input) {
        String delimiter = ",|:";
        String numbers = input;

        // 커스텀 구분자가 있는지 확인
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterIndex);
            numbers = input.substring(delimiterIndex + 1);
        }

        String[] tokens = numbers.split(delimiter);
        int sum = 0;

        for (String token : tokens) {
            int number = Integer.parseInt(token);
            sum += number;
        }

        return sum;
    }
}

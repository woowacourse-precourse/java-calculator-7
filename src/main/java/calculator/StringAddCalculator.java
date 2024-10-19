package calculator;

public class StringAddCalculator {
    public int calculate(String input) {
        // 입력 값이 없을 경우
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";

        String[] result = input.split(delimiter);

        int sum = 0;
        for (String token : result) {
            int number = Integer.parseInt(token);
            sum += number;
        }
        return sum;
    }

}

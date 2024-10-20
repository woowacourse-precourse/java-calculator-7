package calculator;

public class Calculator {
    public static int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        // input이 빈 문자열이 아닌 경우
        String[] parsedInput = Parser.parse(input);
        int result = 0;

        // 분할한 문자열을 숫자로 바꾸고, 정수인지 검증하기
        for (String number : parsedInput) {
            try {
                int parsedNumber = Integer.parseInt(number);
                int validatedNumber = Validator.validateNumber(parsedNumber);

                result += validatedNumber;
            } catch (NumberFormatException e) {
                Validator.use();
            }
        }

        return result;
    }
}

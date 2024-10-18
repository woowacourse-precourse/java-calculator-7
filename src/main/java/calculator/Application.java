package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private final Delimiters delimiters = new Delimiters();

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해주세요.");

        String inputString = Console.readLine();

        validateInputString(inputString);

        String numberString = delimiters.extractNumberString(inputString);

        StringBuilder delimiterExpression = new StringBuilder();
        for (char delimiter : delimiters.getDelimiters()) {
            delimiters.appendDelimiter(delimiterExpression, delimiter);
        }

        String delimiterStr = delimiterExpression.toString();

        String[] numList = numberString.split(delimiterStr);

        int sum = 0;

        for (String token : numList) {

            String trimToken = token.trim();

            sum += convertToValidInteger(trimToken);

        }

        System.out.println("결과 : " + sum);
    }

    private void validateInputString(String inputString) {
        if (inputString == null || inputString.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 공백이거나 빈 문자열입니다.");
        }
    }

    public int convertToValidInteger(String token) {
        try {
            String trimToken = (token.trim());
            int num = Integer.parseInt(trimToken);

            validateNonNegative(num);
            return num;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 입력되지 않았습니다.");
        }
    }

    private void validateNonNegative(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }


}

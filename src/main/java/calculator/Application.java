package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private Delimiters delimiters = new Delimiters();

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해주세요.");

        String inputString = Console.readLine();

        String numberString = extractNumberString(inputString);

        StringBuilder delimiterExpression = new StringBuilder();
        for (char delimiter : delimiters.getDelimiters()) {
            appendDelimiter(delimiterExpression, delimiter);
        }

        String delimiterStr = delimiterExpression.toString();

        String[] numList = numberString.split(delimiterStr);

        int sum = 0;

        for (String token : numList) {
            if (!token.isEmpty()) {
                try {
                    int num = Integer.parseInt(token.trim());

                    if (num < 0) {
                        throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                    }

                    sum += num;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자가 입력되지 않았습니다.");
                }
            }
        }

        System.out.println("결과 : " + sum);
    }

    private String extractNumberString(String inputString) {
        // 기본 구분자 추가
        delimiters.addDelimiter(':');
        delimiters.addDelimiter(',');

        if (inputString.startsWith("//")) {
            delimiters = new Delimiters();
            int index = findLastDelimiterIndex(inputString);

            extractDelimiters(inputString, index);

            validateSingleDelimiter();

            return inputString.substring(index + 2);
        }

        return inputString;
    }

    private void validateSingleDelimiter() {
        if (!delimiters.hasSingleDelimiter()) {
            throw new IllegalArgumentException("커스텀 구분자는 하나여야 합니다.");
        }
    }

    private void extractDelimiters(String inputString, int index) {
        for (int i = 2; i < index; i++) {
            delimiters.addDelimiter(inputString.charAt(i));
        }
    }

    private static int findLastDelimiterIndex(String inputString) {
        int index = 2;
        int length = inputString.length();

        while (index < length - 1) {
            char currentChar = inputString.charAt(index);
            char nextChar = inputString.charAt(index + 1);

            if (currentChar == '\\' && nextChar == 'n') {
                return index;
            }
            index++;
        }
        return index;
    }

    private void appendDelimiter(StringBuilder expression, char delimiter) {
        if (!expression.isEmpty()) {
            expression.append("|");
        }
        expression.append("\\").append(delimiter);
    }
}

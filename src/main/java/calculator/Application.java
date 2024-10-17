package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String expression = getExpression();

        validateExpression(expression);

        String[] numList = parseNumbersFromExpression(expression);
        System.out.println("결과 : " + getResult(numList));
    }

    private static void validateExpression(String expression) {
        if (expression.isEmpty() || expression == null) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        if (expression.startsWith("//")) {
            if (!expression.contains("\\n")) {
                throw new IllegalArgumentException("커스텀 구분자가 잘못되었습니다.");
            }
        }
    }

    private static int getResult(String[] list) {
        int result = 0;
        for (String num : list) {
            try {
                int number = Integer.parseInt(num);
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }
                result += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자도 구분자도 아닌 값이 포함되어 있습니다.");
            }
        }
        return result;
    }

    private static String[] parseNumbersFromExpression(String expression) {
        if (expression.startsWith("//")) { // //로 시작하는 경우 커스텀 구분자 사용
            String seperator = expression.substring(2, expression.indexOf("\\n")); // 커스텀 구분자
            String numberExpression = expression.substring(expression.indexOf("\\n") + 2); // 숫자 문자열
            return numberExpression.split(seperator); // 커스텀 구분자로 숫자 문자열 분리
        } else {
            return expression.split(",|:");
        }
    }

    private static String getExpression() {
        // 사용자 입력 후 자원 해제 및 반환
        String input = Console.readLine();
        Console.close();
        return input;
    }

}

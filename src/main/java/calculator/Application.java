package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String expression = getExpression();
        String[] numList = parseNumbersFromExpression(expression);
        System.out.println("결과 : " + getResult(numList));
    }

    private static int getResult(String[] list) {
        int result = 0;
        for (String num : list) {
            result += Integer.parseInt(num);
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

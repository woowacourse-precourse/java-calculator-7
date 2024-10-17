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
        String[] numList = expression.split(",|:");
        return numList;
    }

    private static String getExpression() {
        // 사용자 입력 후 자원 해제 및 반환
        String input = Console.readLine();
        Console.close();
        return input;
    }

}

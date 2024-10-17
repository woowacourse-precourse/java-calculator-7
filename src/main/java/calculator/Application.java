package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String expression = getExpression();

        String[] numList = getNumList(expression);
        for (String s : numList) {
            System.out.println("num = " + s);
        }
    }

    private static String[] getNumList(String expression) {
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

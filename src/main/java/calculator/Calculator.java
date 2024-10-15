package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    static boolean customDelimiters = false;    // 기본 구분자, 커스텀 구분자 인지

    // 기본 구분자 or 커스텀 구분자 구분하는 함수
    private static void isCustomDelimiters(String formula) {
        if (formula.startsWith("//")) {
            customDelimiters = true;
        }
    }

    private static String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static void run() {
        String formula = input();   // 사용자 입력
        isCustomDelimiters(formula);    // 기본 구분자, 커스텀 구분자 구분하기
    }
}

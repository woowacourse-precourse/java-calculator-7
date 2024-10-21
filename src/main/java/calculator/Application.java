package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 1. 입력을 받는다.
        String input = inputExpression();
    }

    // 문자열을 입력 받아 입력 받은 문자열을 반환하는 메소드
    private static String inputExpression(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}

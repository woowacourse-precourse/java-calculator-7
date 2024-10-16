package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static String inputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        // TODO: 예외 처리 메소드 호출 후 에러 메세지 표시
        return readLine();
    }

    private static boolean isValidPositive(String input) {
        // TODO: 음수 or 빈 문자열 or null이면 false
        return true;
    }
}

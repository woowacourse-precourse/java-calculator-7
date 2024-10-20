package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력하세요.");
        String input = Console.readLine();
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().isBlank();
    }

}

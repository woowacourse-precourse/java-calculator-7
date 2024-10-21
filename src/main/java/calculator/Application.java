package calculator;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

public class Application {
    public static void main(String[] args) {

        // 1. 문자열 입력받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String words = Console.readLine();

        // 2. 공백이 없고 값이 하나 이상 있는지 확인
        // 아니라면 유효한 값이 아니므로 IllegalArgumentException 발생시킴
        if (words == null || words.isEmpty() || StringUtils.containsWhitespace(words)) {
            throw new IllegalArgumentException();
        }
    }
}
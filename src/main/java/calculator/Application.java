package calculator;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // 문자열 값 입력
        String input = camp.nextstep.edu.missionutils.Console.readLine();

        // 문자열 파싱 (커스텀 구분자 확인)
        Set<Character> delimiters = new HashSet<>();
        delimiters.add(',');
        delimiters.add(';');

        // 커스텀 구분자가 존재할 수 있는 경우
        if (input.startsWith("//")) {
            // 커스텀 구분자가 존재할 수 있는 최소 입력 문자열의 길이는 5이다.
            // //*\n 4글자 + 숫자 문자열
            if (input.length() < 5) {
                throw new IllegalArgumentException();
            }
            // 커스텀 구분자가 정확히 1개가 아니거나 \n이 정확한 위치에 없는 경우
            if (input.charAt(4) != '\n') {
                throw new IllegalArgumentException();
            }
            if (Character.isDigit(input.charAt(3))) {
                throw new IllegalArgumentException();
            }
            char customDelimiter = input.charAt(3);
            delimiters.add(customDelimiter);
            input = input.substring(5);
        }
    }
}

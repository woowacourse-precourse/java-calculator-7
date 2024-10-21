package calculator;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

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

        // 3. 커스텀 구분자가 지정되었는지 확인
        String delimiters = ",|:";
        String regex = "^[\\D]+$";

        // 3-1. 커스텀 구분자가 지정되었다면 그 값이 유효한지 확인 후 구분자에 추가
        if (words.startsWith("//")) {
            int i = 0;
            int start = 0;

            // while문으로 여러 개의 커스텀 구분자를 탐색할 수 있도록 함
            while (i < words.length()) {
                if (words.startsWith("//", start)) {
                    int end = words.indexOf("\\n", start);
                    if (end == -1) {
                        throw new IllegalArgumentException();
                    }

                    String delimiter = words.substring(start+2, end);
                    if (delimiter.matches(regex)) {
                        delimiters += "|" + delimiter;
                    } else {
                        throw new IllegalArgumentException();
                    }

                    i += end+2;
                    start = i;

                } else {
                    break;
                }
            }

        // 3-2. 커스텀 구분자가 지정되지 않았다면 숫자로 시작하는지 확인
        // 숫자로 시작하지 않는다면 유효한 값이 아니므로
        // IllegalArgumentException 발생시킴
        } else if (words.substring(0, 1).matches(regex)) {
            throw new IllegalArgumentException();
        }
    }
}
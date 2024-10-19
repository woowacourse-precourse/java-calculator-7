package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Application {

    public static void main(String[] args) {

        // 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        String[] splitStr = str.split("");

        // 구분자 확인
        if (splitStr[0].equals("/")) {
            String delimiter = findDelimiter(splitStr);
            // 문자열 분리
        } else {
            // 문자열 분리
        }

        // 출력

    }

    public static String findDelimiter (String[] splitStr) {
        if (splitStr[1].equals("/") && splitStr[3].equals("\\") && splitStr[4].equals("n")) {
            String delimiter = splitStr[2];
            return delimiter;
        } else {
            throw new IllegalArgumentException();
        }
    }
}

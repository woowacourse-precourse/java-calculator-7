package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    static List<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));

    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        long answer = 0;

        if ((str.startsWith("//") && str.contains("\\n"))) {
            delimiters = checkDelimiter(str);
        }

        // 구분자 이용해서 문자열 나누기

        // 오류 확인
        // 나눠진 문자열 이용해 합계 계산

        System.out.println("결과 : " + answer);

    }

    private static List<String> checkDelimiter(String str) {
        String tmp = str.substring(2, str.indexOf("\\n"));
        delimiters.add(tmp);
        return delimiters;
    }

}


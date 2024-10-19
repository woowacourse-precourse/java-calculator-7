package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    // "덧셈할 문자열을 입력해주세요." 구문 출력
    private static void init_print() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    // ``Console.readLine()`` 함수를 이용하여 구분자와 양수로 구분된 문자열 입력받기
    private static String input() {
        return Console.readLine();
    }

    // 커스텀 구분자 유무를 판단하고, 커스텀 구분자 반환하기
    private static String checkCustomDelimiter(String str) {
        String regex = "//(.*?)\n";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StringBuilder delimiter = new StringBuilder();
        delimiter.append(".|:");
        init_print();
        String str = input();
        delimiter.append(checkCustomDelimiter(str));
    }
}

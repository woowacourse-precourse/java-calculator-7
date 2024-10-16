package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}


class Machine {
    static final String metaChars = ".^$*+?()[]{}|\\";

    String custom;
    String string;

    public Machine() {
    }

    private static String getString() {
        String input;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input = Console.readLine();
        return input;
    }

    private static void printResult(int data) {
        System.out.printf("결과 : %d", data);
    }

    private static String escapeMetaChars(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            // 입력 문자가 정규식 메타 언어일 때
            if (metaChars.indexOf(c) != -1) {
                result.append('\\');
            }
            result.append(c);
        }
        return result.toString();
    }

    private void setDelimiter(String string) {
        String regex = "//(.)\\\\n";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        if (matcher.find()) {
            // 커스텀 구분자 지정 문자열이 입력문자열의 앞이 아닐 때, 예외 처리
            if (matcher.start() != 0) {
                throw new IllegalArgumentException("커스텀 구분자가 문자열의 앞이 아닌 부분에서 정의됨");
            }

            this.custom = escapeMetaChars(matcher.group(1));
            this.string = string.substring(matcher.end());
        }
    }
}
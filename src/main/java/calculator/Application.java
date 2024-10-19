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

    // 커스텀 구분자 존재 시, 커스텀 구분자 부분 분리하여 구분자에 추가하기
    private static String[] getCustomDelimiter(String str) {
        String regex = "//(.*?)\\\\n";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()) {
            return new String[]{matcher.group(1), str.substring(matcher.end())};
        }
        return new String[]{"", str};
    }

    // 나머지 문자열을 구분자로 파싱하기
    private static String[] parseString(String delimiter, String str) {
        return str.split(delimiter);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StringBuilder delimiter = new StringBuilder();
        delimiter.append(".|:");
        init_print();
        String str = input();
        String[] tempResult = getCustomDelimiter(str);
        delimiter.append("|").append(tempResult[0]);
        str = tempResult[1];
        System.out.println(str);
        String[] result = parseString(delimiter.toString(), str);
    }
}

package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Application {
    // `//` 와 `\n` 사이의 하나 이상의 모든 문자들을 찾되, 최소한의 문장만 매칭하는 정규표현식
    static Pattern pattern = Pattern.compile("\\/\\/(.+?)\\\\n");

    public static void main(String[] args) {

    }
    public static String extractDelimiter(String str) {
        // 정규표현식에 인자로 주어진 str를 적용한다.
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            // 만약 해당 //와 \n이 존재하며, 해당 문자 사이에 문자열이 존재할 경우
            // 해당 문자열을 반환한다.
            return matcher.group(1);
        }
        return "";
    }
}

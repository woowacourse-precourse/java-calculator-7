package calculator.separatorParser;

import java.util.HashSet;
import java.util.Set;

public class SeparatorParser {

    // 구분자 Set을 만드는 함수
    public static Set<String> parseSeparator(String s, int endIndex) {
        Set<String> separatorSet = new HashSet<>();
        separatorSet.add(":"); // 기본 구분자
        separatorSet.add(",");

        if (endIndex < 4) { // 만약 "//\n" 정도도 없다면 커스텀 구분자 입력 없음
            return separatorSet;
        }

        for (char c : s.substring(2, endIndex - 2).toCharArray()) { // "//" 부터 "\n" 앞부분까지 한 글자씩 구분자 저장
            separatorSet.add(c + "");
        }

        return separatorSet;
    }
}

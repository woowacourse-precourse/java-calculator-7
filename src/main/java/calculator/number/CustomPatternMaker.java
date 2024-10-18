package calculator.number;

import java.util.ArrayList;
import java.util.List;

public class CustomPatternMaker {

    public static List<String> getCustomPattern(String input) {
        // 커스텀 구분자를 찾아낸다.
        String customSeparator = input.substring(input.indexOf("//") + 2, input.indexOf("\\n"));
        // 커스텀 구분자가 문자로 되어있고 여러 개 사용할 수 있으므로 분리시켜준다.
        String[] customPatterns = customSeparator.split("");
        // 특수문자로 인식하기 위해 이스케이프를 추가해준다.
        List<String> customPatternList = new ArrayList<>();
        for (String customPattern : customPatterns) {
            isSpecialCharacter(customPattern);
            customPatternList.add("\\" + customPattern);
        }
        return customPatternList;
    }

    private static void isSpecialCharacter(String pattern) {
        if (pattern.matches("[\\w]")) {
            throw new IllegalArgumentException("커스텀 구분자는 특수문자만 가능합니다.");
        }
    }
}

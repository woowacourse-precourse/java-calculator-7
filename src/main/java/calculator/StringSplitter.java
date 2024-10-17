package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    public List<String> split(String str) {
        // 구분자를 정규식으로 치환
        StringBuilder regexBuilder = new StringBuilder();
        regexBuilder.append("[,:]");

        // 커스텀 구분자 유무 확인 후, 정규식 추가
        if (str.startsWith("//") && str.contains("\\n")) {
            if (str.indexOf("\\n") - 2 > 0) {
                String customDelimiter = getCustomDelimiter(str);
                regexBuilder.insert(3, customDelimiter);
            }
            str = str.substring(str.indexOf("\\n") + 2);
        }

        String regex = regexBuilder.toString();

        return new ArrayList<>(Arrays.asList(str.split(regex)));
    }

    private String getCustomDelimiter(String str) {
        StringBuilder customDelimiterBuilder = new StringBuilder(str.substring(2, str.indexOf("\\n")));

        if (customDelimiterBuilder.toString().contains("[")) {
            customDelimiterBuilder.insert(customDelimiterBuilder.indexOf("["), "\\");
        }

        if (customDelimiterBuilder.toString().contains("]")) {
            customDelimiterBuilder.insert(customDelimiterBuilder.indexOf("]"), "\\");
        }

        return customDelimiterBuilder.toString();
    }
}

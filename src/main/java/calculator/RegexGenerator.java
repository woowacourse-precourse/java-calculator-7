package calculator;

import java.util.List;

public class RegexGenerator {
    public String create(List<String> delimiters) {
        // 구분자를 정규식으로 치환
        StringBuilder regexBuilder = new StringBuilder();
        regexBuilder.append("[");

        for (String delimiter : delimiters) {
            if (delimiter.equals("[") || delimiter.equals("]")) {
                regexBuilder.append("\\");
            }
            regexBuilder.append(delimiter);
        }

        regexBuilder.append("]");

        String regex = regexBuilder.toString();

        return regex;
    }
}

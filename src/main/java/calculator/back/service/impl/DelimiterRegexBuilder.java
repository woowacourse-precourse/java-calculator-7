package calculator.back.service.impl;

import java.util.List;

public class DelimiterRegexBuilder {
    static String buildDelimiterRegex(List<Character> delimiters) {
        StringBuilder regexBuilder = new StringBuilder();

        regexBuilder.append("[");
        for (Character delimiter : delimiters) {
            // 정규표현식에서 특별한 의미를 가지는 문자 이스케이프 처리
            if ("\\.^$|?*+()[]{}".indexOf(delimiter) != -1) {
                regexBuilder.append('\\');
            }
            regexBuilder.append(delimiter);
        }
        regexBuilder.append("]");

        return regexBuilder.toString();
    }
}

package calculator.util;

import calculator.analyzer.DelimiterAnalyzer;

import java.util.List;

public class DelimiterRegexGenerator {

    public String generateDelimiterRegex(List<String> delimiterList) {

        // or 연결로 정규식 생성
        String delimiterRegex = "";
        for(String i : delimiterList) {
            delimiterRegex += (i+"|");
        }
        // 끝 부분의 "|" 빼주기
        delimiterRegex = delimiterRegex.substring(0, delimiterRegex.length()-1);

        return delimiterRegex;
    }
}

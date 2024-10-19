package calculator.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.domain.Delimiter;

public class DelimiterController {
    private Delimiter delimiter = new Delimiter();

    // 사용자가 입력한 문자열을 전달받아 커스텀 구분자를 추출
    public void extractDelimiter(String inputString) {
        // "//.*?\\\\n" -> "//"로 시작하고 "\n"으로 끝나는 문자열을 나타내는 정규 표현식
        Pattern pattern = Pattern.compile("//.*?\\\\n");
        Matcher matcher = pattern.matcher(inputString);

        while (matcher.find()) {
            // "//"로 시작하고 "\n"으로 끝나는 문자열에서 "//"와 "\n"을 제거
            String newDelimiter = matcher.group().replaceAll("[//|\\\\n]", "").trim();

            delimiter.addDelimiter(newDelimiter);
        }
    }

    // 추출한 구분자들을 정규표현식 형태로 반환
    public String getRegex() {
        return delimiter.getDelimitersRegex();
    }
}

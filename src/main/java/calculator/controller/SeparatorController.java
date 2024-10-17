package calculator.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.domain.Separator;
import calculator.messages.ErrorMessages;

public class SeparatorController {
    private Separator separator = new Separator();

    // 사용자가 입력한 문자열을 전달받아 커스텀 구분자를 추출
    public void extractSeparator(String inputString) {
        Pattern pattern = Pattern.compile("//.*?\\\\n");
        Matcher matcher = pattern.matcher(inputString);

        while (matcher.find()) {
            String newSeparator = matcher.group().replaceAll("[//|\\\\n]", "").trim();
            if (separator.getSeparators().contains(newSeparator)) {
                throw new IllegalArgumentException(ErrorMessages.EXIST_SEPARTOR.getMessage());
            }
            separator.addSeperator(newSeparator);
        }
    }

    // 추출한 구분자들을 정규표현식 형태로 반환
    public String getRegex() {
        return separator.getSeparatorsRegex();
    }
}

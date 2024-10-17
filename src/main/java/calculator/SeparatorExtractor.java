package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {

    public String extractCustomSeparator(String value, List<String> customSeparators) {
        if (!value.contains("//")) {
            return value;
        }

        String regex = "//(.+?)\n";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);

        while (matcher.find()) {
            String separator = matcher.group(1);

            boolean isNumContains = separator.chars().anyMatch(c -> c >= '1' && c <= '9');
            if (isNumContains) {
                throw new IllegalArgumentException("커스텀 구분자에는 양수가 포함될 수 없습니다.");
            }

            customSeparators.add(separator);
        }

        // 커스텀 구분자 선언이 추출되어 삭제된 문자열 반환
        return matcher.replaceAll("").trim();
    }
}

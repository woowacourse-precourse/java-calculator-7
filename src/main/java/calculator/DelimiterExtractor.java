package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {

    public static String extractCustomDelimiter(String request) {
        if (request.startsWith("//") && request.contains("\\n")) {
            String delimiterRegex = "//(.*?)\\\\n";

            Pattern customDelimiterPattern = Pattern.compile(delimiterRegex, Pattern.DOTALL);
            Matcher matcher = customDelimiterPattern.matcher(request);

            if (matcher.find()) {
                String customDelimiter = matcher.group(1).trim();
                validateCustomDelimiter(customDelimiter);
                System.out.println("추출된 커스텀 구분자: " + customDelimiter);
                return customDelimiter;
            } else {
                throwInvalidDelimiterException("커스텀 구분자를 찾지 못했습니다.");
            }
        }

        return "";  // 커스텀 구분자가 없는 경우 기본값 반환
    }

    // 커스텀 구분자 이후의 문자열을 추출하는 함수
    public static String extractSubString(String request, String customDelimiter) {
        if (!customDelimiter.isEmpty()) {
            String subStringPattern = "//.*?\\\\n(.*)";
            Matcher matcher = Pattern.compile(subStringPattern, Pattern.DOTALL).matcher(request);

            if (matcher.find()) {
                String subString = matcher.group(1).trim();
                System.out.println("추출된 기타 문자열: " + subString);
                return subString;
            } else {
                throwInvalidDelimiterException("문자열을 분리할 수 없습니다.");
            }

        }

        return request;  // 커스텀 구분자가 없으면 전체 문자열 사용

    }

    private static void validateCustomDelimiter(String customDelimiter) {
        if (customDelimiter.isEmpty()) {
            throwInvalidDelimiterException("커스텀 구분자가 비어있습니다.");
        }
    }

    // IllegalArgumentException을 발생시키는 메서드
    private static void throwInvalidDelimiterException(String message) {
        throw new IllegalArgumentException(message);
    }
}

package calculator.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class InputService {

    private static final String INPUT_SENTENCE = "덧셈할 문자열을 입력해 주세요.";
    private static final String CUSTOM_PREFIX = "//";
    private static final String CUSTOM_SUFFIX = "\\n";

    /**
     * 사용자로부터 문자열을 입력받음
     *
     * @return 입력값
     */
    public static String input() {
        System.out.println(INPUT_SENTENCE);

        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return ""; // 입력값이 없을 경우 빈 문자열 반환
        }

    }

    /**
     * 입력된 문자열로부터 구분자 추출
     *
     * @param inputString 사용자가 입력한 문자열
     * @return Custom 구분자 선언 부분이 제외된 문자열과, 종합된 구분자 문자열
     */
    public static Map<String, String> extractCustomDelimiter(String inputString) {
        // Custom 구분자 선언이 있는지 확인
        int customDividerStartIndex = inputString.indexOf(CUSTOM_PREFIX);
        int customDividerEndIndex = inputString.indexOf(CUSTOM_SUFFIX);

        Map<String, String> extractedString = new HashMap<>();

        // 예외처리
        if (customDividerStartIndex != 0) {
            extractedString.put(
                    "customDelimiter",
                    null
            );
            extractedString.put(
                    "calculateString",
                    inputString
            );
            return extractedString;
        }

        // 구분자 추출 후 계산한 문자열과 분리 저장

        extractedString.put(
                "customDelimiter",
                inputString.substring(customDividerStartIndex + CUSTOM_PREFIX.length(), customDividerEndIndex)
        );
        extractedString.put(
                "calculateString",
                inputString.substring(customDividerEndIndex + CUSTOM_SUFFIX.length())
        );

        return extractedString;
    }

}

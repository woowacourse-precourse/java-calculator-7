package calculator.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 문자열에서 커스텀 문자를 추출하는 클래스
 */
public class DelimiterExtractor {
    static final String CUSTOM_DELIMITER_FORMAT = "//.\\n"; // 커스텀 구분자 형식
    static int customDelimiterIndex; // 구분자 문자가 존재하는 인덱스 번호
    static List<Character> defaultDelimiters = Arrays.asList(',', ':'); // 기본 구분자

    /**
     * 커스텀 구분자가 나오는 인덱스 번호 탐색
     */
    public DelimiterExtractor() {
        for (int i = 0; i < CUSTOM_DELIMITER_FORMAT.length(); i++) {
            if (CUSTOM_DELIMITER_FORMAT.charAt(i) == '.') {
                customDelimiterIndex = i;
            }
        }
    }

    /**
     * 입력된 문자열에 커스텀 문자열의 형식에 해당하는 부분이 있을 경우 제거
     * 커스텀 문자열에 해당하는 문자는 Set에 추가
     * @param input 입력된 문자열
     * @return 커스텀 문자열 형식이 제거된 문자열, 구분자 목록이 담긴 DelimiterResult 객체
     */
    public DelimiterResult getDelimiters(String input) {
        Set<Character> delimiters = new HashSet<>(defaultDelimiters); // 구분자 목록 Set
        int numberIndex = 0; // 현재 탐색중인 인덱스 번호

        while (numberIndex < input.length()) {
            if (!validateFormat(input, numberIndex)) {
                break;
            }
            delimiters.add(input.charAt(numberIndex + customDelimiterIndex));
            numberIndex += CUSTOM_DELIMITER_FORMAT.length();
        }

        numberIndex = Math.min(numberIndex, input.length() - 1); // 구분자 형식의 길이만큼 더해주는 경우, input보다 길어지는 경우가 있음

        return new DelimiterResult(input.substring(numberIndex), delimiters);
    }


    /**
     * 커스텀 구분자의 형식에 맞는지 검증
     * @param input 입력된 문자열
     * @param startIdx 검증을 시작할 문자열의 인덱스 번호
     * @return 커스텀 구분자의 형식에 맞는지 여부
     */
    private boolean validateFormat(String input, int startIdx) {
        // startIdx로 부터 한 글자씩 체크하면서 탐색

        if (input.length() - startIdx - 1 < CUSTOM_DELIMITER_FORMAT.length()) {
            return false;
        }

        for (int i = 0; i < CUSTOM_DELIMITER_FORMAT.length(); i++) {
            if (CUSTOM_DELIMITER_FORMAT.charAt(i) == '.') {
                continue;
            }
            if (input.charAt(startIdx + i) != CUSTOM_DELIMITER_FORMAT.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}

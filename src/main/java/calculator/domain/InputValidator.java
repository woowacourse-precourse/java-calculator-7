package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputValidator {

    private static final String SEPARATOR_START = "//";
    private static final String SEPARATOR_END = "\\n";

    /**
     * 커스텀 구분자가 존재하는지 확인
     */
    public static boolean isExistCustomSeparator(String input) {
        if (input.contains(SEPARATOR_START) && input.contains(SEPARATOR_END)) {
            return true;
        }
        return false;
    }

    /**
     * 문자열에서 커스텀 구분자 리스트를 반환
     * - 커스텀 구분자가 여러 개 존재할 수 있기 때문
     */
    public static List<String> getCustomSeparator(String input) {
        boolean isSeparator = false;
        List<String> separators = new ArrayList<>();

        // 구분자 없이 "//\n"만 존재하는 경우
        if (input.length() == 4) {
            return separators;
        }

        for (int i = 0; i < input.length(); i++) {
            // 커스텀 구분자 표시인 "//"일 경우
            if (input.charAt(i) == SEPARATOR_START.charAt(0) && input.charAt(i + 1) == SEPARATOR_START.charAt(1)) {
                isSeparator = true;
                i += 1;
                continue;
            }

            if (isSeparator) {
                separators.add(String.valueOf(input.charAt(i)));
                if (input.charAt(i + 1) == SEPARATOR_END.charAt(0) && input.charAt(i + 2) == SEPARATOR_END.charAt(1)) {
                    break;
                }
            }
        }
        return separators;
    }

    /**
     * 문자열에서 커스텀 구분자 정보를 제거
     */
    public static String removeSeparatorInfo(String input) {
        String splitedString = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i + 1) == SEPARATOR_END.charAt(0) && input.charAt(i + 2) == SEPARATOR_END.charAt(1)) {
                splitedString = input.substring(i + 3, input.length());
                break;
            }
        }
        return splitedString;
    }

    /**
     * 구분자로 숫자 분리
     */
    public static List<Integer> separate(String input, List<String> separators) {
        List<Integer> numbers = new ArrayList<>();

        String separator = convertString(separators);
        StringTokenizer tokenizer = new StringTokenizer(input, separator);
        while (tokenizer.hasMoreTokens()) {
            try {
                numbers.add(Integer.parseInt(tokenizer.nextToken()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }

        return numbers;
    }

    /**
     * 구분자 리스트를 1개의 문자열로 변환
     */
    public static String convertString(List<String> separators) {
        String result = "";
        for (String separator : separators) {
            result += separator;
        }
        return result;
    }
}

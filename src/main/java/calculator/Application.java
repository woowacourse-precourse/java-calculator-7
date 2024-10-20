package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Application {

    private static final String START_DELIMITER = "//";
    private static final String END_DELIMITER = "\\n";
    private static final char[] DEFAULT_DELIMITERS = {',', ':'};

    private static String numberInputString = null;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputValue = Console.readLine();
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            Set<Character> delimiters = extractDelimiter(inputValue);
            long result = calcNumbers(delimiters);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException expected) {
            throw expected;
        } finally {
            Console.close();
        }

    }

    /**
     * 사용자가 입력한 문자열에서 커스텀 구분자를 추출하여 Set에 저장합니다.
     *
     * @param inputValue 사용자가 입력한 문자열
     * @throws IllegalArgumentException 올바르지 않는 형식의 문자열의 경우, 오류를 발생시킵니다.
     * @return Set<Character> 기본 및 커스텀 구분자 Set
     *
     */
    private static Set<Character> extractDelimiter(String inputValue) {
        Set<Character> delimiterSet = new HashSet<>();

        // 기본 구분자를 Set에 미리 추가합니다.
        for (char defaultDelimiter : DEFAULT_DELIMITERS) {
            delimiterSet.add(defaultDelimiter);
        }

        int startIdx = inputValue.indexOf(START_DELIMITER);
        int endIdx = inputValue.indexOf(END_DELIMITER);

        // 구분자를 정의하지 않는 문자열 양식인 경우, 더 이상 작업을 수행하지 않는다.
        if (startIdx == -1 && endIdx == -1) {
            numberInputString = inputValue;
            return delimiterSet;
        } else if (startIdx > 0) {
            // 구분자 정의를 시작하는 "//"의 위치가 0이 아닌 경우.
            // 즉, "//"의 앞에 다른 문자가 있는 경우 에러를 반환한다.
            throw new IllegalArgumentException("올바르지 않는 형식의 문자열 입력입니다.");
        } else if ((startIdx != -1 && endIdx == -1) || (startIdx == -1 && endIdx != -1)) {
            // 구분자의 시작과 끝을 정의하는 문자가 둘 중 하나만 있는 경우 에러를 반환한다.
            throw new IllegalArgumentException("올바르지 않는 형식의 문자열 입력입니다.");
        }

        String delimiterString = inputValue.substring(startIdx + START_DELIMITER.length(), endIdx);
        numberInputString = inputValue.substring(endIdx + END_DELIMITER.length());

        for (int i = 0; i < delimiterString.length(); i++) {
            char delimiter = delimiterString.charAt(i);

            // 구분자로 숫자가 입력되었을 경우
            if (Character.isDigit(delimiter)) {
                throw new IllegalArgumentException("올바르지 않는 형식의 문자열 입력입니다.");
            } else {
                delimiterSet.add(delimiter);
            }
        }

        return delimiterSet;
    }

    /**
     * 사용자가 입력한 문자열에서 설정한 구분자를 기준으로 분리한 각 숫자의 합을 반환합니다.
     *
     * @param delimiters 구분자를 저장한 Set
     * @throws IllegalArgumentException 올바르지 않은 문자가 입력된 경우 오류를 발생시킵니다.
     * @return long 계산 결과
     *
     */
    private static long calcNumbers(Set<Character> delimiters) throws IllegalArgumentException {
        if (numberInputString == null || numberInputString.isEmpty()) {
            return 0;
        }

        long result = 0;
        List<Long> numberList = extractNumbers(delimiters, numberInputString);

        for (Long number: numberList) {
            result += number;
        }

        return result;
    }

    private static StringBuilder initStringBuilder() {
        return new StringBuilder();
    }

    /**
     * 사용자가 입력한 문자열을 설정된 구분자를 활용하여 수를 분리합니다.
     * 분리한 수들을 List로 반환합니다.
     *
     * @param delimiters 구분자를 저장한 Set
     * @param InputString 사용자가 입력한 문자열
     * @throws IllegalArgumentException 숫자 및 설정된 구분자가 아닌 경우 오류를 반환합니다.
     * @return List<Long> 분리한 수 List
     */
    private static List<Long> extractNumbers(Set<Character> delimiters, String InputString) {
        List<Long> resultList = new ArrayList<>();
        StringBuilder stringBuilder = initStringBuilder();

        for (int i = 0; i < InputString.length(); i++) {
            char character = InputString.charAt(i);
            if (Character.isDigit(character)) {
                stringBuilder.append(character);
            } else if (delimiters.contains(character)) {
                // 구분자 문자를 만났을 때 stringBuilder의 내용이 있을 경우, 수로 변환하여 List에 추가한다.
                if (!stringBuilder.toString().isEmpty()) {
                    resultList.add(Long.parseLong(stringBuilder.toString()));
                }
                stringBuilder = initStringBuilder();
            } else {
                throw new IllegalArgumentException("올바르지 않는 형식의 문자열 입력입니다.");
            }
        }

        // stringBuilder의 내용이 남아 있을 경우, 수로 변환하여 List에 추가한다.
        if (!stringBuilder.toString().isEmpty()) {
            resultList.add(Long.parseLong(stringBuilder.toString()));
        }

        return resultList;
    }
}

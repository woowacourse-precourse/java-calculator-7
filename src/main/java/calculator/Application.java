package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Application {
    private static Console inputConsole;
    private static final String START_DELIMITER = "//";
    private static final String END_DELIMITER = "\\n";

    private static String numberInputString = null;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputValue = inputConsole.readLine();
        try {
            char[] delimiters = extractDelimiter(inputValue);
        } catch (IllegalArgumentException expected) {
            throw expected;
        } finally {
            inputConsole.close();
        }

    }

    /**
     * 구분자 추출 함수
     *
     * @param inputValue 사용자가 입력한 문자열
     * @throws IllegalArgumentException 올바르지 않는 형식의 문자열 입력입니다.
     * @return 구분자 문자 배열 혹은 null
     */
    private static char[] extractDelimiter(String inputValue) {
        Set<Character> delimiterSet = new HashSet<>();
        int startIdx = inputValue.indexOf(START_DELIMITER);
        int endIdx = inputValue.indexOf(END_DELIMITER);

        // 구분자를 정의하지 않는 문자열 양식인 경우, null을 반환한다.
        if (startIdx == -1 && endIdx == -1) {
            numberInputString = inputValue;
            return null;
        } else if (startIdx > 0) {
            // 구분자 정의를 시작하는 "//"의 위치가 0이 아닌 경우. 즉, "//"의 앞에 다른 문자가 있는 경우.
            throw new IllegalArgumentException("올바르지 않는 형식의 문자열 입력입니다.");
        } else if ((startIdx != -1 && endIdx == -1) || (startIdx == -1 && endIdx != -1)) {
            // 구분자의 시작과 끝을 정의하는 문자가 둘 다 있지 않는 경우.
            throw new IllegalArgumentException("올바르지 않는 형식의 문자열 입력입니다.");
        }

        String delimiterString = inputValue.substring(startIdx + START_DELIMITER.length(), endIdx);
        numberInputString = inputValue.substring(endIdx + END_DELIMITER.length());

        for (int i = 0; i < delimiterString.length(); i++) {
            delimiterSet.add(delimiterString.charAt(i));
        }

        int index = 0;
        char[] returnArray = new char[delimiterSet.size()];

        for (Character character : delimiterSet) {
            returnArray[index++] = character;
        }

        return returnArray;
    }
}

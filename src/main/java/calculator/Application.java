package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = readLine();

        HashSet<String> separators = fetchSeparator(input);

    }

    // Helper
    private static String readLine() {
        return Console.readLine();
    }
    private static HashSet<String> fetchSeparator(String input) throws IllegalArgumentException {
        HashSet<String> separators = new HashSet<>();
        separators.add(",");
        separators.add(";");

        int startIndex = input.indexOf('\\');
        int endIndex = input.indexOf('\n');

        if (startIndex == -1 && endIndex == -1) { // 커스텀 구분자가 없음
            return separators;
        }
        if (startIndex != 0 || endIndex == -1) { // 시작점이 처음이 아님 or 끝이 없음
            throw new IllegalArgumentException("커스텀 입력 형식이 올바르지 않음");
        }

        String separatorCandidate = input.substring(startIndex + 1, endIndex);

        for (int i = startIndex + 1; i < endIndex; i++) {
            char candidate = separatorCandidate.charAt(i);
            if ('0' <= candidate && candidate <= '9') {
                throw new IllegalArgumentException("숫자는 구분자가 될 수 없음");
            }
            separators.add(String.valueOf(candidate));
        }

        return separators;
    }
}

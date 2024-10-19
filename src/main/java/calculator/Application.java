package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = readLine();
        HashSet<String> separators = fetchSeparator(input);

        ArrayList<Integer> extractedNumbers = extractNumbers(input, separators);

        Integer result = addAllNumbers(extractedNumbers);

        System.out.printf("결과 : %d%n", result);
    }

    // Helper
    private static String readLine() {
        return Console.readLine();
    }
    private static HashSet<String> fetchSeparator(String input) throws IllegalArgumentException {
        HashSet<String> separators = new HashSet<>();
        separators.add(",");
        separators.add(":");

        int startIndex = input.indexOf("//");
        int endIndex = input.indexOf("\\n");

        if (startIndex == -1 && endIndex == -1) { // 커스텀 구분자가 없음
            return separators;
        }
        if (startIndex != 0 || endIndex == -1) { // 시작점이 처음이 아님 or 끝이 없음
            throw new IllegalArgumentException("커스텀 입력 형식이 올바르지 않음");
        }

        String separatorCandidate = input.substring(startIndex + 2, endIndex);

        for (int i = 0; i < separatorCandidate.length(); i++) {
            char candidate = separatorCandidate.charAt(i);
            if ('0' <= candidate && candidate <= '9') {
                throw new IllegalArgumentException("숫자는 구분자가 될 수 없음");
            }
            separators.add(String.valueOf(candidate));
        }

        return separators;
    }
    private static ArrayList<Integer> extractNumbers(String input, HashSet<String> separators) throws IllegalArgumentException {
        ArrayList<Integer> numbers = new ArrayList<>();
        int startIndex = input.indexOf("\\n");
        startIndex = startIndex == -1 ? 0 : startIndex + 2;
        int endIndex = startIndex;
        for ( ; endIndex < input.length(); endIndex++) {
            if ('0' <= input.charAt(endIndex) && input.charAt(endIndex) <= '9') {
                continue;
            }

            String numberCandidate = input.substring(startIndex, endIndex);
            if (separators.contains(String.valueOf(input.charAt(endIndex)))) {
                numbers.add(Integer.parseInt(numberCandidate));
                startIndex = endIndex+1;
            } else {
                throw new IllegalArgumentException("구분자 목록에 없는 문자임");
            }
        }
        if (endIndex == input.length()) {
            String numberCandidate = input.substring(startIndex, endIndex);
            if (!numberCandidate.isEmpty()) {
                numbers.add(Integer.parseInt(numberCandidate));
            }
        }

        return numbers;
    }
    private static Integer addAllNumbers(ArrayList<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}

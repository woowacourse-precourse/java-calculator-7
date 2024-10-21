package calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    static List<String> getNumbers(String input, Set<Character> delimiters) {
        List<String> numbers = new ArrayList<>();
        StringBuilder tempNumber = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (delimiters.contains(c)) {
                // 구분자로 시작하거나, 구분자가 두개 붙어있는 경우
                if (tempNumber.isEmpty()) {
                    throw new IllegalArgumentException();
                }
                numbers.add(tempNumber.toString());
                tempNumber.setLength(0);
                continue;
            }
            if (Character.isDigit(c)) {
                tempNumber.append(c);
                continue;
            }
            throw new IllegalArgumentException();
        }
        if (tempNumber.isEmpty()) {
            throw new IllegalArgumentException();
        }
        numbers.add(tempNumber.toString());
        return numbers;
    }

    public static void main(String[] args) {
        // 문자열 값 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = camp.nextstep.edu.missionutils.Console.readLine();

        // 문자열 파싱 (커스텀 구분자 확인)
        Set<Character> delimiters = new HashSet<>();
        delimiters.add(',');
        delimiters.add(':');

        // 커스텀 구분자가 존재할 수 있는 경우
        if (input.startsWith("//")) {
            // 커스텀 구분자가 존재할 수 있는 최소 입력 문자열의 길이는 5이다.
            // //*\n 4글자 + 숫자 문자열
            if (input.length() < 5) {
                throw new IllegalArgumentException();
            }
            // 커스텀 구분자가 정확히 1개가 아니거나 \n이 정확한 위치에 없는 경우
            if (input.charAt(3) != '\\' && input.charAt(4) != 'n') {
                throw new IllegalArgumentException();
            }
            if (Character.isDigit(input.charAt(2))) {
                throw new IllegalArgumentException();
            }
            char customDelimiter = input.charAt(2);
            delimiters.add(customDelimiter);
            input = input.substring(5);
        }

        long result = 0;
        if (!input.isEmpty()) {
            // 문자열 파싱 (숫자 추출)
            List<String> numbers = getNumbers(input, delimiters);

            // 구분점으로 구분된 숫자들의 합계 계산
            for (String i : numbers) {
                result += Long.parseLong(i);
            }
        }

        // 결과 출력
        System.out.println("결과 : " + result);
    }

}

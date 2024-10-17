package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String str = Console.readLine();
        List<Character> separatorList = new ArrayList<>();

        // 구분자 추가
        addSeparator(str, separatorList);

        // 숫자 추출
        List<Integer> numbers = extractNumbers(str, separatorList);

        // 숫자 합계 계산
        long sum = sumNumbers(numbers);
        System.out.println("합계: " + sum);
    }

    // 숫자 추출 함수
    public static List<Integer> extractNumbers(String str, List<Character> separatorList) {
        List<Integer> numberList = new ArrayList<>();

        if (str.isEmpty()) {
            numberList.add(0);
        } else {
            StringBuilder regexBuilder = new StringBuilder();
            regexBuilder.append("[");

            for (Character character : separatorList) {
                regexBuilder.append(character);
            }
            regexBuilder.append("]");

            String[] parts = str.split(regexBuilder.toString());
            for (String part : parts) {
                if (!part.isEmpty()) {
                    try {
                        int number = Integer.parseInt(part);
                        // 음수 처리
                        if (number < 0 && !separatorList.contains('-')) {
                            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + part);
                        }
                        numberList.add(number);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("잘못된 입력: " + part);
                    }
                }
            }
        }
        return numberList;
    }

    public static long sumNumbers(List<Integer> numberList) {
        long sum = 0;
        for (Integer i : numberList) {
            sum += i;
        }
        return sum;
    }

    // "//" 와 "\n" 사이에 있는 문자를 커스텀 구분자로 추가
    public static void addSeparator(String str, List<Character> separatorList) {
        int startIdx = -1;

        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1 && str.charAt(i) == '/' && str.charAt(i + 1) == '/') {
                startIdx = i + 2;
                continue;
            }
            if (str.charAt(i) == '\n' && startIdx != -1) {
                for (int j = startIdx; j < i; j++) {
                    separatorList.add(str.charAt(j));
                }
                startIdx = -1;
            }
        }

        // '//'로 시작하고 '\n'으로 끝나지 않는 경우 예외 발생
        if (startIdx != -1) {
            throw new IllegalArgumentException("잘못된 입력: '//'로 시작하지만 '\\n'으로 끝나지 않습니다.");
        }

        // 구분자가 없고 문자열에 숫자가 포함된 경우 예외 발생
        if (separatorList.isEmpty() && str.contains(",")) {
            throw new IllegalArgumentException("구분자가 추가되지 않았습니다.");
        }
    }
}

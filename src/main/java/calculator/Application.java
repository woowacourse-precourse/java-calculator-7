package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        String str = Console.readLine();
        Set<Character> separatorSet = new HashSet<>();

        String numbersPart = processInput(str, separatorSet);

        List<Integer> numbers = extractNumbers(numbersPart, separatorSet);
        long sum = sumNumbers(numbers);
        System.out.println("결과 : " + sum);
    }

    public static List<Integer> extractNumbers(String str, Set<Character> separatorSet) {
        List<Integer> numberList = new ArrayList<>();

        if (str.isEmpty()) {
            numberList.add(0);
        } else {
            StringBuilder regexBuilder = new StringBuilder();
            regexBuilder.append("[");

            // separatorSet에서 구분자를 가져와서 정규 표현식 생성
            for (Character character : separatorSet) {
                regexBuilder.append(character);
            }
            regexBuilder.append("]");

            // 문자열을 구분자로 나눔
            String[] parts = str.split(regexBuilder.toString());

            for (String part : parts) {
                if (!part.isEmpty()) {
                    try {
                        int number = Integer.parseInt(part);
                        if (number < 0) {
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

    public static String processInput(String str, Set<Character> separatorSet) {
        // 기본 구분자 추가
        separatorSet.add(':');
        separatorSet.add(',');

        // 커스텀 구분자 부분 확인
        if (str.startsWith("//")) {
            String[] parts = str.split("n"); // "\n"으로 문자열을 나누기

            // 커스텀 구분자가 있는 경우
            if (parts.length > 0 && parts[0].startsWith("//")) {
                String customSeparatorPart = parts[0].substring(2); // "//" 이후 부분

                // 커스텀 구분자들을 separatorSet에 추가
                for (int i = 0; i < customSeparatorPart.length(); i++) {
                    char ch = customSeparatorPart.charAt(i);
                    // 맨 마지막 문자가 '\'일 경우 추가하지 않음
                    if (i == customSeparatorPart.length() - 1 && ch == '\\') {
                        continue;
                    }
                    separatorSet.add(ch);
                }

                // 커스텀 구분자 설정 이후 부분을 반환 (두 번째 부분)
                return parts.length > 1 ? parts[1] : ""; // 두 번째 부분 반환
            }
        }

        // "//"가 없을 경우 전체 문자열 반환
        return str;
    }
}

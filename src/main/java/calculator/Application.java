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

            // 정규 표현식 생성
            for (Character character : separatorSet) {
                regexBuilder.append(character);
            }
            regexBuilder.append("]");

            // 문자열을 구분자로 나눈다.
            String[] parts = str.split(regexBuilder.toString());

            for (String part : parts) {
                if (!part.isEmpty()) {
                    try {
                        int number = Integer.parseInt(part);
                        if (number < 0) {
                            throw new IllegalArgumentException("음수는 허용되지 않습니다.: " + part);
                        }
                        numberList.add(number);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("잘못된 입력입니다.: " + part);
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
        // 기본 구분자
        separatorSet.add(':');
        separatorSet.add(',');

        // 커스텀 구분자
        if (str.startsWith("//")) {
            String[] parts = str.split("n");

            // 커스텀 구분자 있는 경우
            if (parts.length > 0 && parts[0].startsWith("//")) {
                String customSeparatorPart = parts[0].substring(2);

                for (int i = 0; i < customSeparatorPart.length(); i++) {
                    char ch = customSeparatorPart.charAt(i);
                    if (i == customSeparatorPart.length() - 1 && ch == '\\') {
                        continue;
                    }
                    separatorSet.add(ch);
                }

                return parts.length > 1 ? parts[1] : ""; // 두 번째 부분 반환
            }
        }

        return str;
    }
}
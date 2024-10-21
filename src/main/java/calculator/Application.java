package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> integers = extractNumbers(input);
        int result = sumValues(integers);
        System.out.println("결과 : " + result);
    }
    private static List<Integer> extractNumbers(String input) {
        String delimiter = ",|:";
        String numbers = input;
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex != -1) {
                String customDelimiters = input.substring(2, delimiterEndIndex); // //과 \n 사이의 구분자들 추출
                numbers = input.substring(delimiterEndIndex + 2); // 실제 숫자 부분

                // 구분자를 순회하여 각 구분자를 delimiter에 추가
                for (int i = 0; i < customDelimiters.length(); i++) {
                    String customDelimiter = String.valueOf(customDelimiters.charAt(i));
                    delimiter += "|" + customDelimiter; // 각 구분자를 추가
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        return Arrays.stream(numbers.split(delimiter))
                .map(Application::validateAndParse)
                .collect(Collectors.toList());
    }

    private static Integer validateAndParse(String value) {
        int result = 0;
        for (int i = 0; i < value.length(); i++) {
            char curChar = value.charAt(i);
            if (curChar < '0' || curChar > '9')
                throw new IllegalArgumentException();

            result *= 10;
            result += curChar - '0';
        }

        return result;
    }
    private static Integer sumValues(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}

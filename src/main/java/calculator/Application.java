package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        List<String> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1 || delimiterEndIndex == 2) {
                throw new IllegalArgumentException("커스텀 구분자는 공백 또는 \n가 될 수 없습니다.");
            }
            String customDelimiter = input.substring(2, delimiterEndIndex);
            delimiters.add(customDelimiter);

            input = input.substring(delimiterEndIndex + 2);
        }

        String delimiterPattern = String.join("|", delimiters.stream()
                .map(Pattern::quote)
                .toArray(String[]::new));

        List<String> numbers = List.of(input.split(delimiterPattern));

        for (String number : numbers) {
            String trimmedNumber = number.trim();
            if (!trimmedNumber.matches("-?\\d+")) {
                throw new IllegalArgumentException("잘못된 입력 값입니다.");
            }

            int parsedNumber = Integer.parseInt(trimmedNumber);
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
        }

        int result = numbers.stream()
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println("결과 : " + result);
    }
}

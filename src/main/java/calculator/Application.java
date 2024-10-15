package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        input = input.replace("\\n", "\n");
        int result = 0;
        if(inputIsNotEmpty(input)) {
            List<String> delimiters = new ArrayList<>(List.of(",", ":"));

            boolean hasCustomDelimiter = false;
            if(isContainsCustomDelimiter(input)) {
                int delimiterIdx = input.indexOf("\n");
                String delimiter = input.substring(2, delimiterIdx);
                delimiters.add(delimiter);
                hasCustomDelimiter = true;
            }

            String numbersWithDelimiter;
            if(hasCustomDelimiter) {
                 numbersWithDelimiter = input.substring(input.indexOf("\n") + 1);
            } else {
                numbersWithDelimiter = input;
            }
            String[] splitNumbers = numbersWithDelimiter.split(buildDelimiterRegex(delimiters));

            for (String number : splitNumbers) {
                int parsedNumber = Integer.parseInt(number);
                if(parsedNumber < 0) {
                    throw new IllegalArgumentException("입력값은 양수만 가능합니다.");
                }
                result += parsedNumber;
            }
        }
        System.out.println("결과 : " + result);
    }

    private static String buildDelimiterRegex(List<String> delimiters) {
        return String.join("|", delimiters);
    }

    private static boolean isContainsCustomDelimiter(String input) {
        return input.startsWith("//") && input.contains("\n");
    }

    private static boolean inputIsNotEmpty(String input) {
        return input != null && !input.isEmpty();
    }
}

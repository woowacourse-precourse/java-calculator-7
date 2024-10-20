package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        System.out.println("덧셈할 문자열을 입력해 주세요 (커스텀 구분자 사용 시 '//구분자\\n숫자' 형식):");

        String firstInput = Console.readLine();
        String delimiter = "[,:]";
        String numbersInput;

        if (firstInput.startsWith("//")) {
            int delimiterEndIndex = firstInput.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자가 미완성되었습니다. 형식: '//구분자\\n숫자'");
            }
            String customDelimiter = firstInput.substring(2, delimiterEndIndex);
            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자를 입력해주세요.");
            }
            delimiter = Pattern.quote(customDelimiter) + "|,|:";
            numbersInput = firstInput.substring(delimiterEndIndex + 2);
        } else {
            numbersInput = firstInput;
        }

        String[] tokens = numbersInput.split(delimiter);
        List<Integer> numbers = convertToIntegers(tokens);

        int sum = calculateSumWithForLoop(numbers);
        System.out.println("결과 : " + sum);

    }

    private static List<Integer> convertToIntegers(String[] tokens) {
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            String trimmedToken = token.trim();
            if (trimmedToken.isEmpty()) {
                continue;
            }
            try {
                int number = Integer.parseInt(trimmedToken);
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: '" + trimmedToken + "'");
            }
        }
        return numbers;
    }

    private static int calculateSumWithForLoop(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
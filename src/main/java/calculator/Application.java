package calculator;

import java.math.BigInteger;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String input = getInput();

        input = delimiterCheck(input);

        String[] numbers = getNumbers(input);

        String answer = calculateNumbers(numbers);

        System.out.println("결과 : " + answer);
    }

    private static String calculateNumbers(String[] numbers) {
        String answer = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            String nowNumber = numbers[i];

            answer = new BigInteger(answer).add(new BigInteger(nowNumber)).toString();
        }
        return answer;
    }

    private static String[] getNumbers(String rest) {
        String[] numbers = separateNumbers(rest);

        emptyCheck(numbers);

        for (String number : numbers) {
            onlyZeroCheck(number);
            positiveNumberCheck(number);
        }
        return numbers;
    }

    private static String[] separateNumbers(String input) {
        return Arrays.stream(input.split("[:,]")).map(String::trim)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
    }

    private static void emptyCheck(String[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("숫자가 없습니다.");
        }
    }

    private static void positiveNumberCheck(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!(number.charAt(i) >= '0' && number.charAt(i) <= '9')) {
                throw new IllegalArgumentException("양수가 아니거나, 올바른 숫자가 아닙니다.");
            }
        }
    }

    private static void onlyZeroCheck(String number) {
        if (number.length() == 1 && number.charAt(0) == '0') {
            throw new IllegalArgumentException("0값은 올 수 없습니다.");
        }
    }

    private static String delimiterCheck(String input) {
        boolean isDelimiterOpened = false;

        StringBuilder customDelimiterString = new StringBuilder();
        String refinedInput = input;

        for (int i = 0; i < input.length() - 1; i++) {
            if (!isDelimiterOpened) {
                if (input.startsWith("//", i)) {
                    isDelimiterOpened = true;
                    customDelimiterString = new StringBuilder("//");
                    i += 1;
                }
            } else {
                if (input.startsWith("\\n", i)) {
                    isDelimiterOpened = false;
                    customDelimiterString.append(input, i, i + 2);
                    refinedInput = refinedInput.replace(customDelimiterString, ":");
                    i += 1;
                } else {
                    customDelimiterString.append(input.charAt(i));

                }
            }
        }

        if (isDelimiterOpened) {
            throw new IllegalArgumentException("커스텀 구분자가 닫혀 있지 않습니다.");
        }
        return refinedInput;
    }

    private static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}

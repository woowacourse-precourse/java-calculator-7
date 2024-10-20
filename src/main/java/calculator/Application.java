package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();

        List<String> parsedInput = parseInput(userInput);

        String delimiter = parsedInput.get(0);
        String expression = parsedInput.get(1);

        // 문자열 파트가 공백이라면 0 출력
        if (expression.isEmpty()){
            System.out.println("결과 : " + 0);
        } else {
            int sum = calculate(splitExpression(delimiter, expression));
            System.out.println("결과 : " + sum);
        }
    }

    // 입력을 구분자 파트와 숫자식으로 분리하는 메서드
    public static List<String> parseInput(String input) {
        int delimiterStartIndex = input.indexOf("//");
        int expressionStartIndex = input.indexOf("\\n");

        // 구분자 파트가 없는 경우
        if (delimiterStartIndex == -1 && expressionStartIndex == -1) {
            return Arrays.asList("", input);
        }
        // 구분자 파트가 잘 들어온 경우
        else if (delimiterStartIndex == 0 && expressionStartIndex == 3) {
            String delimiter = String.valueOf(input.charAt(2));
            String expression = input.substring(expressionStartIndex + 2);

            return Arrays.asList(delimiter, expression);
        }

        throw new IllegalArgumentException("올바른 입력값을 넣어주세요.");
    }

    // 문자열을 구분자로 분리하는 메서드
    private static List<Integer> splitExpression(String delimiter, String expression) {
        String[] operandStrings = expression.split("[" + Pattern.quote(delimiter) + ",:]");
        return convertToIntegerList(operandStrings);
    }

    // 합을 구하는 메서드
    public static int calculate(List<Integer> operands) {
        int sum = 0;
        for (Integer operand : operands) {
            sum += operand;
        }
        return sum;
    }

    // 문자열 배열을 정수 리스트로 변환하는 메서드
    private static List<Integer> convertToIntegerList(String[] operandStrings) {
        List<Integer> numbers = convertToDigits(operandStrings);
        validatePositiveNumbers(numbers);
        return numbers;
    }

    // 문자열 배열을 숫자로 변환하는 메서드
    private static List<Integer> convertToDigits(String[] operandStrings) {
        List<Integer> numbers = new ArrayList<>();

        for (String operandString : operandStrings) {
            try {
                numbers.add(Integer.valueOf(operandString));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("피연산자는 숫자만 가능합니다.");
            }
        }
        return numbers;
    }

    // 양수 검증 메서드
    private static void validatePositiveNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number <= 0) {
                throw new IllegalArgumentException("양수만 가능합니다.");
            }
        }
    }
}

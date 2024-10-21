package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String input = Input();

        String customIdentifier = FindCustomIdentifier(input);

        String[] nums = GetSplitNumbers(input, customIdentifier);

        Double sum = CalculateSum(nums);
        System.out.printf("결과 : %.15f", sum);
    }

    private static String Input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        if (input == null || input.length() < 1) {
            throw new IllegalArgumentException("Invalid input(null)");
        }

        return input;
    }

    private static String FindCustomIdentifier(String input) {
        int identifierStartIdx = input.indexOf("//");
        int m_CustomIdentifierEndIdx = input.indexOf("\\n");
        String customIdentifier = "";

        if (identifierStartIdx == 0 && m_CustomIdentifierEndIdx > 0) {
            customIdentifier = input.substring(identifierStartIdx + 2, m_CustomIdentifierEndIdx);
            if (customIdentifier.compareTo("-") == 0) {
                throw new IllegalArgumentException("Invalid custom identifier('-')");
            }
        }

        return customIdentifier;
    }

    private static String[] GetSplitNumbers(String input, String customIdentifier) {
        String[] numbers = null;
        if (customIdentifier.isEmpty()) {
            numbers = input.split("[,:]");
        } else {
            int headerLength = 2 + customIdentifier.length() + 2;
            numbers = input.substring(headerLength, input.length()).split(customIdentifier);
        }

        return numbers;
    }

    private static Double CalculateSum(String[] numbers) {
        if (numbers == null || numbers.length < 1) {
            throw new IllegalArgumentException("Invalid input(no valid numbers)");
        }

        Double sum = 0.0;
        for (String elem : numbers) {
            try {
                Double doubleNum = Double.parseDouble(elem);
                if (doubleNum < 0.0) {
                    throw new IllegalArgumentException("Invalid input(negative num)");
                }
                sum += doubleNum;
            }
            catch(NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input(number format exception)");
            }
        }

        return sum;
    }
}

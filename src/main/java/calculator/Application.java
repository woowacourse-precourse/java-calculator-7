package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("문자열을 입력하시오(예: //;\\n1;2;3) : ");
        try {
            String input = Console.readLine();
            int result = processInput(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("입력 오류: " + e.getMessage());
            throw e;
        }
    }

    // 입력을 처리하는 메서드
    private static int processInput(String input) {
        String[] numbers = extractNumbers(input);
        return sumNumbers(numbers);
    }

    // 입력에서 숫자를 추출하는 메서드
    private static String[] extractNumbers(String input) {
        if (input.startsWith("//")) {
            return extractWithCustomDelimiter(input);
        }
        return input.split("[,:]");
    }

    // 커스텀 구분자를 처리하는 메서드
    private static String[] extractWithCustomDelimiter(String input) {
        int delimiterEnd = input.indexOf("\\n");
        if (delimiterEnd == -1) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다. '\\n'이 포함된 올바른 입력을 제공해주세요.");
        }

        String customDelimiter = input.substring(2, delimiterEnd); // "//" 이후부터 구분자 추출
        String numbersPart = input.substring(delimiterEnd + 2); // 구분자 이후 숫자 부분

        return numbersPart.split(customDelimiter);
    }

    // 음수 숫자가 있는지 확인하는 메서드
    private static void validateNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("양수를 입력해주십시오.");
        }
    }

    // 숫자 배열을 더하는 메서드
    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int parsedNumber = parseNumber(number.trim());
            sum += parsedNumber;
        }
        return sum;
    }

    // 숫자를 파싱하고 음수 여부를 확인하는 메서드
    private static int parseNumber(String number) {
        int parsedNumber = Integer.parseInt(number);
        validateNegative(parsedNumber);
        return parsedNumber;
    }
}

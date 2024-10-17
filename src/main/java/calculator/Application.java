package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("문자열을 입력하시오(예: //;\\n1;2;3) : ");
        try {
            String input = Console.readLine();
            int result = validateInput(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("입력 오류: " + e.getMessage());
            throw e;
        }
    }

    // input 상태보고 판단
    private static int validateInput(String input) {
        // 문자열 앞부분에 // 있으면 커스텀 구분자 특정
        if (input.startsWith("//")) {
            // 커스텀 구분자가 있는 경우 처리
            return sumNumbers(customizeSeparator(input));
        } else {
            String[] numbers;
            numbers = input.split("[,:]");
            return sumNumbers(numbers);
        }
    }

    //커스텀 구분자로 문자열 분리
    private static String[] customizeSeparator(String input) {
        int separatorStartIndex = input.indexOf("//");
        int separatorEndIndex = input.indexOf("\\n");
        if (separatorEndIndex == -1) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다. '\\n'이 포함된 올바른 입력을 제공해주세요.");
        }
        String customDelimiter = "";
        if (separatorStartIndex < separatorEndIndex) {
            customDelimiter = input.substring(separatorStartIndex+2, separatorEndIndex);
        } else {
            throw new IllegalArgumentException("유효한 입력이 아닙니다.");
        }
        String numbersPart = input.substring(separatorEndIndex + 2);
        return numbersPart.split(customDelimiter);
    }

    //문자열에서 추출한 숫자들이 모두 양수인지 확인
    private static void validateNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("양수를 입력해주십시오.");
        }
    }

    //추출한 문자열 형태의 숫자들을 더함
    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int parsedNumber = Integer.parseInt(number.trim());
            validateNegative(parsedNumber);
            sum += parsedNumber;
        }
        return sum;
    }
}
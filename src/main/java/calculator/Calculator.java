package calculator;

public class Calculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] numbers;
        // 문자열 앞부분에 // 있으면 커스텀 구분자 특정
        if (input.startsWith("//")) {
            // 커스텀 구분자가 있는 경우 처리
            numbers = customizeSeparator(input);
        } else {
            // 기본 구분자 (쉼표, 콜론) 사용
            numbers = input.split("[,:]");
        }
        return sumNumbers(numbers);
    }

    private static String[] customizeSeparator(String input) {
        int delimiterStartIndex = input.indexOf("//");
        int delimiterEndIndex = input.indexOf("\\n");
        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다. '\\n'이 포함된 올바른 입력을 제공해주세요.");
        }
        // "//"와 "\n" 사이에 있는 커스텀 구분자를 추출
        String customDelimiter = "";

        // 유효한 인덱스 확인 후 문자열 추출
        if (delimiterStartIndex < delimiterEndIndex) {
            customDelimiter = input.substring(delimiterStartIndex+2, delimiterEndIndex);
        } else {
            throw new IllegalArgumentException("유효한 입력이 아닙니다.");
        }
        // "\n" 이후의 숫자 부분을 추출하고 커스텀 구분자로 분리
        String numbersPart = input.substring(delimiterEndIndex + 2);
        // 커스텀 구분자로 문자열을 분리
        return numbersPart.split(customDelimiter);
    }

    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}

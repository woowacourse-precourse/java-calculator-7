package calculator;

public class stringAddCalculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers;
        String customDelimiter = "[,:]"; // 기본 구분자 쉼표와 콜론

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {

            int delimiterEndIndex = input.indexOf("\n");

            if (delimiterEndIndex != -1) {
                customDelimiter = input.substring(2, delimiterEndIndex);
                input = input.substring(delimiterEndIndex + 1);
            } else {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
            }
        }

        // 구분자 기준으로 문자열 분리
        numbers = input.split(customDelimiter);

        int sum = 0;
        for (String number : numbers) {
            sum += CheckInt.toPositiveInt(number); // 분리된 메서드 호출
        }

        return sum;
    }
}

package calculator;

public class StringAddCalculator {
    public static int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";  // 기본 구분자 선언

        // 커스텀 구분자가 있는 경우 처리
        if (text.startsWith("//")) {
            int delimiterEndIndex = text.indexOf("\n");
            delimiter = text.substring(2, delimiterEndIndex);  // 커스텀 구분자 설정
            text = text.substring(delimiterEndIndex + 1);  // 숫자 부분 추출
        }

        String[] numbers = text.split(delimiter);  // 구분자로 숫자 분리

        int sum = 0;
        for (String number : numbers) {
            int parsedNumber = Integer.parseInt(number.trim());

            // 첫 번째 음수 값이 있으면 예외 발생
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed: " + parsedNumber);
            }

            sum += parsedNumber;
        }

        return sum;
    }
}

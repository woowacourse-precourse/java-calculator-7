package calculator;

public class Calculator {
    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = splitNumbers(input); // 문자열 숫자로 나누기
        validateNumbers(numbers);  // 유효한 문자인지 검사
        return sumNumbers(numbers);
    }

    private String[] splitNumbers(String input) {
        String customDelimiter = extractCustomDelimiter(input); // 커스텀 구분자 추출
        String numbersPart = extractNumbersPart(input); // 커스텀 구분자 지정 문자 제외한 부분 추출

        String regex;
        if (customDelimiter != null) {
            regex = "[," + customDelimiter + ":]";
        } else {
            regex = "[,:]";
        }
        return numbersPart.split(regex);
    }

    private String extractCustomDelimiter(String input) {
        // 첫 2글자가 "//"로 시작하는지 확인
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            //커스텀 구분자가  존재한다면 추출
            if (delimiterEndIndex != -1 && delimiterEndIndex > 2) {
                return input.substring(2, delimiterEndIndex);
            }
        }
        // 커스텀 구분자가 없으면 null 반환
        return null;
    }

    private String extractNumbersPart(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex != -1 && delimiterEndIndex > 2) {
                return input.substring(delimiterEndIndex + 2);
            }
        }
        return input;
    }

    private void validateNumbers(String[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            String number = numbers[i].trim();

            // 빈 문자열일 경우 0으로 치환
            if (number.isEmpty()) {
                numbers[i] = "0";
            }
            // 숫자 && 0 이상인지 검사
            if (!numbers[i].matches("\\d+")) {
                throw new IllegalArgumentException("유효한 숫자가 아닙니다: " + number);
            }
        }
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number.trim());
        }
        return sum;
    }
}

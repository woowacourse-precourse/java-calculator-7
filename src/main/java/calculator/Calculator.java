package calculator;

public class Calculator {
    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String customDelimiter = extractCustomDelimiter(input); // 커스텀 구분자 추출
        String numbersPart = extractNumbersPart(input); // 커스텀 구분자 지정 문자 제외한 부분 추출

        String regex;
        if (customDelimiter != null) {
            regex = "[," + customDelimiter + ":]";
        } else {
            regex = "[,:]";
        }
        String[] numbers = numbersPart.split(regex);

        validateNumbers(numbers);  // 유효한 문자인지 검사
        return sumNumbers(numbers);
    }

    public String extractCustomDelimiter(String input) {
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

    public String extractNumbersPart(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex != -1 && delimiterEndIndex > 2) {
                return input.substring(delimiterEndIndex + 2);
            }
        }
        return input;
    }

    public void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            number = number.trim();
            // 숫자 && 양수 검사
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException("유효한 숫자가 아닙니다: " + number);
            }
        }
    }

    public int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number.trim());
        }
        return sum;
    }
}

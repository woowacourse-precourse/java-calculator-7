package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String customDelimiter = extractCustomDelimiter(input); // 커스텀 구분자 추출
        String numbersPart = extractNumbersPart(input); // 커스텀 구분자 지정 문자 제외한 부분 추출
        System.out.println(numbersPart);

        String regex = "[," + customDelimiter + ":]";
        String[] numbers = numbersPart.split(regex);
        for (String s : numbers) {
            System.out.println(s);
        }

        validateNumbers(numbers);
        int sum = sumNumbers(numbers);
        System.out.println("결과 : " + sum);
    }

    public static String extractNumbersPart(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex != -1 && delimiterEndIndex > 2) {
                return input.substring(delimiterEndIndex + 2);
            }
        }
        return input;
    }

    public static String extractCustomDelimiter(String input) {
        // 첫 2글자가 "//"로 시작하는지 확인
        if (input.startsWith("//")) {
            // \n 이전의 부분에서 커스텀 구분자를 추출
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex != -1 && delimiterEndIndex > 2) {
                return input.substring(2, delimiterEndIndex);
            }
        }
        // 커스텀 구분자가 없으면 빈 문자열 반환
        return "";
    }

    public static void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            number = number.trim(); // 공백 제거
            // 숫자가 아닌지 검사
            if (!isNumeric(number)) {
                throw new IllegalArgumentException("Invalid number: " + number);
            }
            // 양수인지 검사
            if (!isPositive(number)) {
                throw new IllegalArgumentException("Invalid number: " + number);
            }
        }
    }

    public static boolean isNumeric(String number) {
        // 문자열이 숫자인지 확인
        return number.matches("\\d+");
    }

    public static boolean isPositive(String number) {
        int parsedNumber = Integer.parseInt(number);
        return parsedNumber >= 0;
    }

    public static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number.trim()); // 합산
        }
        return sum; // 합계 반환
    }
}

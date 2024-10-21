package calculator;

import calculator.Exception.CustomDelimiterException;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int add(String input) {

        StringBuilder delimiters = new StringBuilder(",:");
        String numbers;

        if (input.startsWith("//")) {
            int newLineIndex = input.indexOf("\\n");
            
            if (newLineIndex == -1) {
                throw new CustomDelimiterException("잘못된 입력입니다: '\\n'을 찾을 수 없습니다.");
            }
            // 커스텀 구분자 추출
            String customDelimiter = input.substring(2, newLineIndex);
            // 구분자가 두 개 이상인 경우 예외 발생
            if (customDelimiter.length() > 1) {
                throw new CustomDelimiterException("구분자는 하나의 문자여야 합니다.");
            }

            // 커스텀 구분자의 입력으로 기본 구분자 ",|:" (쉼표, 콜론) 가 들어온 경우.
            if (customDelimiter.equals(",") || customDelimiter.equals(":")) {
                throw new CustomDelimiterException("커스텀 구분자의 입력으로 기본 구분자가 들어왔습니다.");
            }

            if (customDelimiter.isEmpty()) {
                throw new CustomDelimiterException("커스텀 구분자가 지정되지 않았습니다.");
            }
            // 구분자가 숫자인 경우 예외 발생,
            if (Character.isDigit(customDelimiter.charAt(0))) {
                throw new CustomDelimiterException("숫자는 구분자로 사용할 수 없습니다.");
            }

            delimiters.append(customDelimiter); // 기본 구분자에 커스텀 구분자 추가
            numbers = input.substring(newLineIndex + 2); // 커스텀 구분자와 분리.
        } else {
            numbers = input; // 기본 구분자만 있는 경우
        }

        return sum(numbers, delimiters.toString());
    }

    public static int sum(String numbers, String delimiters) {
        int total = 0;
        StringBuilder currentNumber = new StringBuilder();

        for (char ch : numbers.toCharArray()) {
            if (isDelimiter(ch, delimiters)) {
                // 현재 사용하는 구분자인지 확인.
                total += parseAndValidate(currentNumber.toString());
                currentNumber.setLength(0);
            } else {
                currentNumber.append(ch);
                // 구분자가 아니면 현재 숫자에 이어 붙임.
            }
        }

        // 마지막 숫자 뒤에는 구분자가 없기 때문에 따로 처리해줘야함.
        if (currentNumber.length() > 0) {
            total += parseAndValidate(currentNumber.toString());
        }

        return total;
    }

    public static boolean isDelimiter(char ch, String delimiters) {
        for (char delimiter : delimiters.toCharArray()) {
            if (ch == delimiter) {
                return true;
            }
        }
        return false;
    }

    public static int parseAndValidate(String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + number);
        }

        // 예외 처리 기능 수정 ..
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c) && c != '-') {
                throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + number);
            }
        }

        int value = Integer.parseInt(number);

        if (value < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + value);
        }

        return value;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 프로그램의 시작 지점 .
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();
        // 입력은 구분자와 양수로 구성된 문자열임 .. 음수가 들어오면 안됨.
        int answer = add(input);

        System.out.println("결과 : " + answer);
    }
}


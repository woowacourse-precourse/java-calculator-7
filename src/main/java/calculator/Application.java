package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static int add(String input) {

        // 올바른 input인지 확인 ..하고 예외처리 해주는 단계..
        // 커스텀 구분자 예외 처리 ..
        // 커스텀 구분자가 있으면 .. 커스텀 구분자를 기본 구분자에 추가해줌 .
        // 구분자는 혼용해서 쓸 수 있다..

        StringBuilder delimiters = new StringBuilder(",:");
        String numbers;

        if (input.startsWith("//")) {
            int newLineIndex = input.indexOf("\\n");
            if (newLineIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력입니다: '\\n'을 찾을 수 없습니다.");
            }

            // 커스텀 구분자 추출
            String customDelimiter = input.substring(2, newLineIndex);
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
                total += parseAndValidate(currentNumber.toString());
                currentNumber.setLength(0); // 현재 숫자 초기화
            } else {
                currentNumber.append(ch);
            }
        }

        // 마지막 숫자 처리
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
        try {
            int value = Integer.parseInt(number);
            if (value < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + value);
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + number);
            // 여기서 잡지 말고 .. 바깥으로 던진 다음에 한꺼번에 잡는걸로 수정.
        }
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

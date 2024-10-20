package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();

        long result = calculate(userInput);
        System.out.println("결과 : " + result);
    }

    // 계산 로직
    public static long calculate(String userInput) {
        String value = userInput;
        char customDelimiter = ',';

        // 커스텀 구분자 사용 여부 확인
        if (userInput.startsWith("//") && userInput.indexOf("\\n") == 3) {
            customDelimiter = userInput.charAt(2);
            if (Character.isDigit(customDelimiter)) {
                throw new IllegalArgumentException("숫자는 커스텀 문자로 사용 할 수 없습니다.");
            }
            value = userInput.substring(userInput.indexOf("\\n") + 2);
        }

        // 유효성 검사
        if (!Character.isDigit(value.charAt(0)) && Character.isDigit(value.charAt(value.length() - 1))) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }

        // 계산 후 결과 반환
        String delimiters = String.format("[%s,:]", customDelimiter);
        String[] numbers = value.split(delimiters);
        long result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }

        return result;
    }

}
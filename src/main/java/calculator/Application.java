package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();

        double result = calculate(userInput);
        System.out.println("결과 : " + result);
    }

    // 계산 로직
    public static double calculate(String userInput) {
        String value = userInput;
        String customDelimiter = ",";  // 기본 구분자 ','

        // 커스텀 구분자 사용 여부 확인
        if (userInput.startsWith("//") && userInput.indexOf("\\n") == 3) {
            customDelimiter = String.valueOf(userInput.charAt(2));  // 사용자가 지정한 커스텀 구분자
            if (Character.isDigit(customDelimiter.charAt(0))) {
                throw new IllegalArgumentException("숫자는 커스텀 구분자로 사용할 수 없습니다.");
            } else if (customDelimiter.equals(".") || customDelimiter.equals("π") || customDelimiter.equals("e")) {
                throw new IllegalArgumentException("소수점(.), 파이(π), 자연상수(e) 등의 기호는 구분자로 사용할 수 없습니다.");
            }
            value = userInput.substring(userInput.indexOf("\\n") + 2);  // 입력에서 실질적인 값 추출
        }

        // 유효성 검사
        if (!isValidInput(value, customDelimiter)) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }

        // 여러 구분자를 함께 처리할 수 있도록 정규식으로 split
        String[] numbers = value.split("[,:;" + escapeRegex(customDelimiter) + "]");  // 기본 구분자와 커스텀 구분자를 모두 처리
        double result = 0;
        for (String number : numbers) {
            result += parseNumberWithConstant(number.trim());  // 숫자 및 상수 처리
        }

        return result;
    }

    // 숫자 및 상수 처리 로직
    private static double parseNumberWithConstant(String input) {
        double constantValue = 1;
        double numberValue;

        // 파이(π) 처리
        if (input.contains("π")) {
            String[] parts = input.split("π");
            if (parts[0].isEmpty()) {
                numberValue = 1;  // 앞에 아무 숫자가 없으면 1로 처리 (예: "π" = 1π)
            } else {
                numberValue = Double.parseDouble(parts[0]);  // 앞에 숫자가 있으면 해당 값 사용 (예: "2π" = 2)
            }
            constantValue = 3.14;  // π 상수
            return numberValue * constantValue;
        }

        // 자연상수 e 처리
        if (input.contains("e")) {
            String[] parts = input.split("e");
            if (parts[0].isEmpty()) {
                numberValue = 1;  // 앞에 아무 숫자가 없으면 1로 처리 (예: "e" = 1e)
            } else {
                numberValue = Double.parseDouble(parts[0]);  // 앞에 숫자가 있으면 해당 값 사용 (예: "12e" = 12)
            }
            constantValue = 2.72;  // e 상수
            return numberValue * constantValue;
        }

        // 숫자만 입력된 경우
        return Double.parseDouble(input);
    }

    // 입력 유효성 검사 (커스텀 구분자도 포함해서 검사)
    private static boolean isValidInput(String value, String customDelimiter) {
        return value.matches("[0-9eπ.]+([" + escapeRegex(customDelimiter) + ",:][0-9eπ.]+)*");
        // 동적으로 커스텀 구분자를 포함하여 유효성 검사
    }

    // 정규식에서 메타문자 처리 (커스텀 구분자가 메타문자일 경우 이스케이프)
    private static String escapeRegex(String delimiter) {
        if ("^$.|?*+[](){}".contains(delimiter)) {
            return "\\" + delimiter;
        }
        return delimiter;
    }
}

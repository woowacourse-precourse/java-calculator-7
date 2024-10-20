package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {

    // 유효한 커스텀 구분자 갖고 있는지 확인하는 메서드
    public static boolean validCustomDelimiter(String input) {
        // 최소 길이 검사
        if (input.length() < 6) { // 커스텀 구분자가 없거나 잘못된 경우
            return false;
        }

        // "//"로 시작하는지 확인
        if (!input.startsWith("//")) {
            return false;
        }

        // "\n"가 3번째와 4번째 문자에 위치하는지 확인
        if (!(input.charAt(3) == '\\' && input.charAt(4) == 'n')) {
            throw new IllegalArgumentException("올바르지 않은 커스텀 구분자 형식입니다.");
        }

        // 구분자를 확인하는 부분
        char delimiter = input.charAt(2);
        if (Character.isDigit(delimiter)) { // 구분자가 숫자인지 확인
            throw new IllegalArgumentException("숫자는 구분자로 설정할 수 없습니다.");
        }

        return true; // 모든 검사 통과 시 true 반환
    }


    // 구분자가 특수문자인지 확인하는 메서드
    public static boolean isSpecialRegexChar(char delimiter) {
        String specialChars = ".^$*+?()[]{}\\|/";
        return specialChars.indexOf(delimiter) != -1;
    }

    // 커스텀 구분자 찾는 메서드, 커스텀 구분자 형식이 아닐 시 기본 구분자 반환
    public static String findCustomDelimiter(String input) {
        String delimiter = ",|:";

        if (validCustomDelimiter(input)) {
            delimiter += "|";
            if (isSpecialRegexChar(input.charAt(2))) {
                delimiter += "\\";
            }
            delimiter += input.charAt(2);
        }
        return delimiter;
    }


    // 문자열 더하는 메서드(number가 숫자가 아닌 경우 예외처리 필요)
    public static int addString(String[] numbers) {

        int sum = 0;
        try {
            for (String number : numbers) {
                if (number.isEmpty()) {
                    continue;
                }
                int num = stringToInt(number);
                if (sum > Integer.MAX_VALUE - num) {
                    throw new IllegalArgumentException("합계가 int 범위를 초과했습니다.");
                }
                sum += num;
            }
        } catch (IllegalArgumentException e) {
//            System.out.println("Error: " + e.getMessage());
        }
        return sum;
    }

    // 문자열을 숫자로 변환하는 메서드
    public static int stringToInt(String number) {
        if (number.charAt(0) == '0') {
            throw new IllegalArgumentException("숫자는 0으로 시작할 수 없습니다.");
        }

        for (int i = 0; i < number.length(); i++) {
            if (!(number.charAt(i) >= '0' && number.charAt(i) <= '9'))
                throw new IllegalArgumentException("양수와 구분자로만 입력하세요.");
        }
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 int 범위를 초과했습니다.");
        }
    }

    // 숫자만 더하는 메서드
    public static int StringCalculator(String input) {
        if (input.isEmpty() || input == null) // 빈문자열 입력 시 0을 출력한다.
            return 0;

        String delimiter = ",|:";

        try {
            delimiter = findCustomDelimiter(input); // 커스텀 구분자 찾기
        } catch (IllegalArgumentException e) {
//            System.out.println("Error: " + e.getMessage());
        }

        if (!delimiter.equals(",|:")) { // 커스텀 구분자 사용 시, 5번째 문자부터 읽기
            if (input.length() < 6) { // 길이가 6보다 짧은 경우 예외 처리
                return 0;
            }
            input = input.substring(5);
        }
        // 구분자를 기준으로 문자열 자르기
        String[] numbers = input.split(delimiter);

        if (numbers.length == 0) // 구분자로만 이루어져있는 경우
            return 0;

        return addString(numbers);
    }


    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        int sum = 0;

        try {
            sum = StringCalculator(input);
        } catch (IllegalArgumentException e) {
//            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("결과 : " + sum);
    }
}

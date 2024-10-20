package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {

    // 유효한 커스텀 구분자 갖고 있는지 확인하는 메서드
    public static boolean validCustomDelimiter(String input) {
        if (input.length() < 5) { // 커스텀 구분자 없는 것으로 간주
            return false;
        }
        if (!input.startsWith("//")) { // 커스텀 구분자 없는 것으로 간주
            return false;
        }
        if (!(input.charAt(3) == '\\' && input.charAt(4) == 'n')) {
            throw new IllegalArgumentException("올바르지 않은 커스텀 구분자 형식입니다.");
        }
        // 구분자가 숫자면 에러
        if (input.charAt(2) >= '0' && input.charAt(2) <= '9')
            throw new IllegalArgumentException("숫자는 구분자로 설정할 수 없습니다.");

        return true;
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

                sum += num;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return sum;
    }

    // 문자열을 숫자로 변환하는 메서드
    public static int stringToInt(String number) {
        if(number.charAt(0) == '0') {
            throw new IllegalArgumentException("숫자는 0으로 시작할 수 없습니다.");
        }

        for (int i = 0; i < number.length(); i++) {
            if (!(number.charAt(i) >= '0' && number.charAt(i) <= '9'))
                throw new IllegalArgumentException("양수와 구분자로만 입력하세요.");
        }
        return Integer.parseInt(number);
    }

    // 숫자만 더하는 메서드
    public static int StringCalculator(String input) {
        if (input.isEmpty()) // 빈문자열 입력 시 0을 출력한다.
            return 0;
        int sum = 0;

        String delimiter = ",|:";

        try {
            delimiter = findCustomDelimiter(input); // 커스텀 구분자 찾기
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        if (delimiter != ",|:") { // 커스텀 구분자 사용 시, 5번째 문자부터 읽기
            input = input.substring(5);
        }
        // 구분자를 기준으로 문자열 자르기
        String[] numbers = input.split(delimiter);

        if (numbers.length == 0) // 구분자로만 이루어져있는 경우
            throw new IllegalArgumentException("계산할 숫자가 없습니다.");

        sum = addString(numbers);

        return sum;
    }


    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        int sum = 0;

        try {
            sum = StringCalculator(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("결과 : " + sum);
    }
}

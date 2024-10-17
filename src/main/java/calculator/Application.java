package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Application {

    public static void main(String[] args) {
        String input = Input();

        if (input == null || input.isEmpty()) { // 입력이 null 인 경우
            ResultMessage(0);
            return;
        }

        String[] inputArr = InputArr(input);

        int[] inputIntArr = IntArr(inputArr);

        int sum = Sum(inputIntArr);

        ResultMessage(sum);
    }

    static String Input() { // 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            String input = Console.readLine();
            System.out.println("입력된 값: " + input);  // 디버깅을 위한 출력
            return input;
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    static char CustomSeparator(String input) {
        if (!input.startsWith("//") || input.length() < 5) {
            return 0; // 기본 구분자
        }

        char separator = extractSeparator(input);

        validateSeparator(separator);

        return separator;
    }

    static char extractSeparator(String input) {
        if (input.charAt(3) == '\\' && input.charAt(4) == 'n') {
            return input.charAt(2); // 사용자 지정 구분자 추출
        }
        throw new IllegalArgumentException("구분자를 정확하게 입력해주세요.");
    }

    static void validateSeparator(char separator) {
        if (separator == ',' || separator == ';') {
            throw new IllegalArgumentException("기본 구분자입니다.");
        }
        if (Character.isDigit(separator)) {
            throw new IllegalArgumentException("숫자는 구분자로 사용할 수 없습니다.");
        }
    }

    static String[] InputArr(String input) { // 입력 문자열을 배열로 변환
        String[] inputArr;
        char separator = CustomSeparator(input);

        if (separator == '\\') { // 역슬래시 구분자에 대한 처리
            input = input.substring(5);
            inputArr = input.split("[;, \\\\]");
        } else if (separator != 0) {
            input = input.substring(5);
            inputArr = input.split("[;, " + separator + "]");
        } else {
            inputArr = input.split("[;,]");
        }

        InputException(inputArr);
        return inputArr;
    }

    static void InputException(String[] inputArr) {
        for (String Num : inputArr) {

            if (Num.isEmpty()) {  // 구분자의 앞뒤에 값이 없는 경우 처리
                throw new IllegalArgumentException("숫자 입력이 제대로 되지 않았습니다.");
            }

            if (Num.matches("0+")) {  // 한 개 이상의 연속된 0이 있을 경우
                throw new IllegalArgumentException("0은 입력할 수 없습니다.");
            }

            if (Num.contains("-")) {  // 음수인 경우 예외 처리
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }

            if (!Num.matches("[0-9]+")) { // 숫자, 구분자 이외의 문자가 들어왔는지 확인
                throw new IllegalArgumentException("숫자, 구분자 이외의 문자가 들어왔습니다.");
            }

            try {
                if (Integer.parseInt(Num) > Integer.MAX_VALUE - 1) { // 너무 큰 숫자를 입력할 경우
                    throw new IllegalArgumentException("너무 큰 숫자는 입력할 수 없습니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("너무 큰 숫자는 입력할 수 없습니다.");
            }
        }
    }

    static int[] IntArr(String[] inputArr) { // String에서 int로 형 변환
        int[] inputIntArr = new int[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            inputIntArr[i] = Integer.parseInt(inputArr[i]);
        }
        return inputIntArr;
    }

    static int Sum(int[] inputIntArr) { // 실수 전부 다 더하기
        int sum = 0;
        for (int Num : inputIntArr) {
            sum += Num;
        }
        return sum;
    }

    static void ResultMessage(int sum) { // 결과 값 출력
        System.out.printf("결과 : %d", sum);
    }
}

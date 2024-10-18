package calculator;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다: " + e.getMessage());
        }
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String delimiter = ",|:";  // 기본 구분자는 쉼표와 콜론
        input = input.replace("\\n", "\n");

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterEndIndex);  // 커스텀 구분자 처리
            input = input.substring(delimiterEndIndex + 1);
        }

        String[] tokens = input.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            sum += parseAndValidateNumber(token);
        }
        return sum;
    }

    private static int parseAndValidateNumber(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 잘못되었습니다.");
        }
    }
}
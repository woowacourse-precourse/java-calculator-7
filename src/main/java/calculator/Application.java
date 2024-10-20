package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        splitAndSum(input);
    }

    public static void splitAndSum(String input) {
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        if ((!input.startsWith("//") && !input.matches("^\\d.*"))) {
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }

        String delimiter = ",|:";

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            if (newlineIndex > 2) {
                String customDelimiter = input.substring(2, newlineIndex);
                if (customDelimiter.length() == 1) {
                    delimiter = customDelimiter;
                    input = input.substring(newlineIndex + 2);
                } else {
                    throw new IllegalArgumentException("잘못된 입력 형식입니다. 구분자는 한 개만 허용됩니다.");
                }
            } else {
                throw new IllegalArgumentException("잘못된 입력 형식입니다. '\\n'이 필요합니다.");
            }
        }

        String[] strArr = input.split(delimiter);
        int sum = 0;
        for (String str : strArr) {
            // 숫자 이외의 값 처리
            if (!str.isEmpty()) {
                try {
                    int number = Integer.parseInt(str);
                    if (number < 0) {
                        throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                    }
                    sum += number;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("유효하지 않은 숫자가 포함되어 있습니다: " + str);
                }
            }
        }
        System.out.println("결과 : " + sum);
    }
}

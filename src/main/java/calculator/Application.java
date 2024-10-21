package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (input.trim().isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        // 입력 문자열에서 "\\n"을 "\n"으로 변환
        input = input.replace("\\n", "\n");

        String splitter = "[,:]";

        if (input.startsWith("//")) {
            int index = input.indexOf("\n");
            splitter = Pattern.quote(input.substring(2, index));
            input = input.substring(index + 1);
        }

        String[] numbers = input.split(splitter);
        int sum = 0;

        try {
            try {
                for (String number : numbers) {
                    int num = Integer.parseInt(number.trim());

                    if (num < 0) {
                        throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                    }
                    sum += num;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } catch (NumberFormatException e) {
            System.out.println("유효하지 않은 입력입니다. 숫자만 포함해야 합니다.");
            return;
        }

        System.out.println("결과 : " + sum);
    }
}

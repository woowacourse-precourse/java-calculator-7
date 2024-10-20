package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static String[] extraction(String input) {

        List<String> delimiters = new ArrayList<>();

        delimiters.add(",");
        delimiters.add(":");

        if (input.startsWith("//") && input.contains("\\n")) {
            String temp = input.substring(2, input.indexOf("\\n"));
            delimiters.add(temp);
            input = input.substring(input.indexOf("\\n") + 2);
        }

        String finalDelimiters = String.join("|", delimiters);
        String[] numbers = input.split(finalDelimiters);

        validData(numbers, input);

        return numbers;
    }

    private static void validData(String[] numbers, String input) {
        for (String num : numbers) {
            num = num.trim();

            if (Objects.equals(num, input)) {
                throw new IllegalArgumentException("구분자가 포함되어있지 않습니다. 다시 입력해주세요.");
            }

            if (!num.matches("\\d+")) {
                throw new IllegalArgumentException("입력 형태가 잘못되었습니다. 다시 입력해주세요.");
            }

            int n = Integer.parseInt(num);
            if (n < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다. 다시 입력해주세요.");
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            String[] numbers = extraction(input);

            for (String num : numbers) {
                System.out.println(num);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("예외: " + e.getMessage());
        }
    }
}

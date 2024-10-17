package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Application {

    public static String createSepRegex(String separators) {
        String[] sep = separators.split("");
        StringBuilder builder = new StringBuilder("[");

        Arrays.stream(sep)
                .map(Pattern::quote)
                .forEach(builder::append);

        builder.append("]");

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        String customSeparator = "";
        if (input.startsWith("//")) {
            String[] split = input.split(Pattern.quote("\\n"));
            customSeparator = split[0].substring(2);
            input = split[1];
        }

        String regex = createSepRegex(",:" + customSeparator);
        String[] numbers = input.split(regex);

        int sum = 0;
        for (String number : numbers) {
            try {
                int num = number.isEmpty() ? 0 : Integer.parseInt(number);

                if (num < 0) {
                    throw new IllegalArgumentException("음수는 입력 불가능");
                }

                sum += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 문자열 형식 - input: " + input);
            }
        }

        System.out.println("결과 : " + sum);
    }
}

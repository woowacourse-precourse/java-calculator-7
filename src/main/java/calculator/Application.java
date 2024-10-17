package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Pattern;

record InputSliceResult(String input, String delimiters) {

}

public class Application {
    private static InputSliceResult getCustomDelimiters(String input, String delimiters) {
        String[] inputSliced = input.split("//", 2)[1].split("\\\\n", 2);

        delimiters += Pattern.quote(inputSliced[0]);
        input = inputSliced[1];

        return new InputSliceResult(input, delimiters);
    }

    private static boolean isPositive(String[] numbers) {
        return Arrays.stream(numbers).allMatch(n -> Double.parseDouble(n) > 0);
    }

    public static void main(String[] args) {
        String delimiters = ",:";

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        try {
            String input = Console.readLine();

            if (input.startsWith("//")) {
                InputSliceResult slices = getCustomDelimiters(input, delimiters);
                input = slices.input();
                delimiters = slices.delimiters();
            }

            String[] numbers = input.split("[" + delimiters + "]+");

            if (!isPositive(numbers)) {
                throw new IllegalArgumentException("모든 숫자는 양수여야 합니다.");
            }

            double sum = Arrays.stream(numbers).mapToDouble(Double::parseDouble).sum();
            System.out.println("결과 : " + sum);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            throw new IllegalArgumentException("잘못된 값입니다. 원래의 예외: " + e);
        } finally {
            Console.close();
        }
    }
}

package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

record StringSliceResult(String input, String delimiters) {

}

public class Application {
    private static StringSliceResult getCustomDelimiters(String input, String delimiters) {
        String[] input_separated = input.split("//", 2)[1].split("\\\\n", 2);

        delimiters += input_separated[0];
        delimiters = delimiters.replace("\\", "\\\\"); // 역슬래시(\)를 custom delimiter로 쓸때의 버그 수정

        input = input_separated[1];

        return new StringSliceResult(input, delimiters);
    }

    private static boolean isPositive(String[] numbers) {
        for (String number:numbers){
            if (Integer.parseInt(number) <= 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String delimiters = ",:";

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        Console.close();

        try {
            if (input.startsWith("//")) {
                StringSliceResult slices = getCustomDelimiters(input, delimiters);
                input = slices.input();
                delimiters = slices.delimiters();
            }

            String[] numbers = input.split("[" + delimiters + "]+");

            if (!isPositive(numbers)) {
                throw new IllegalArgumentException("모든 숫자는 양수여야 합니다.");
            }

            int sum = Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
            System.out.println("결과 : " + sum);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            throw new IllegalArgumentException("잘못된 값입니다. 원래의 예외: " + e);
        }
    }
}

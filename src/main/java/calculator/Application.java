package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {

    public static void main(String[] args) {
        String delimiters = ",:";

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        Console.close();

        try {
            if (input.startsWith("//")) {
                String[] input_separated = input.split("//", 2)[1].split("\\\\n", 2);

                delimiters += input_separated[0];
                input = input_separated[1];
            }

            delimiters = delimiters.replace("\\", "\\\\"); // 역슬래시(\)를 custom delimiter로 쓸때의 버그 수정

            String[] numbers = input.split("[" + delimiters + "]+");

            for (String number:numbers){
                if (Integer.parseInt(number) <= 0) {
                    throw new IllegalArgumentException("모든 숫자는 양수여야 합니다.");
                }
            }

            int sum = Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
            System.out.println("결과 : " + sum);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            throw new IllegalArgumentException("잘못된 값입니다. 원래의 예외: " + e);
        }
    }
}

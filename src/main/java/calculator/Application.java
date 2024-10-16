package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {

    public static void main(String[] args) {
        String delimiters = ",:";

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        Console.close();

        if (input.startsWith("//")){
            String[] input_separated = input.split("//", 2)[1].split("\\\\n", 2);

            delimiters += input_separated[0];
            input = input_separated[1];
        }

        String[] numbers = input.split("[" + delimiters + "]+");

        int sum = Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();

        System.out.println("결과 : " + sum);
    }
}

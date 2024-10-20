package calculator;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String input;
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("덧셈할 문자열을 입력해주세요. ");
            input = scanner.nextLine();
        }
        String[] numbers = input.split("[,:]");

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;

        int sum = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println("결과 : " + sum);
    }
}
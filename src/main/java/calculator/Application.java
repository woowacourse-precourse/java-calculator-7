package calculator;

import calculator.tool.JavaCalculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        JavaCalculator calculator = new JavaCalculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();
        int result = calculator.solution(input);
        System.out.println("결과 : " + result);
    }
}


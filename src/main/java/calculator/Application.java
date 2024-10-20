package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the numeric string to add");
        String input = scanner.nextLine();

        Calculator sentence = new Calculator(input);
        sentence.calculate();
    }
}

package calculator;

import calculator.controller.InputController;
import calculator.parser.InputParser;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputParser inputParser = new InputParser();
        InputController inputController = new InputController(inputParser);
        Scanner scanner = new Scanner(System.in);

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();

        inputController.processInput(input);
    }
}

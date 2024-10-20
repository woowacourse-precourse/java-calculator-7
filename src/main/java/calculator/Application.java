package calculator;

import calculator.controller.CalculateController;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();

        CalculateController calculateController = new CalculateController();

        System.out.println("결과 : " + calculateController.insertUserInput(userInput));


    }
}

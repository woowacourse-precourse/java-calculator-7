package calculator;

import calculator.controller.CaculatorController;
import camp.nextstep.edu.missionutils.Console;

public class Application {

  public static void main(String[] args) {
    CaculatorController caculatorController = new CaculatorController();

    System.out.println("덧셈할 문자열을 입력해 주세요.");
    String input = Console.readLine();
    caculatorController.input(input);
  }
}

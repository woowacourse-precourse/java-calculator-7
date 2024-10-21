package calculator;

import calculator.controller.CalculatorController;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Application {

  public static void main(String[] args) {
    CalculatorController caculatorController = new CalculatorController();

    System.out.println("덧셈할 문자열을 입력해 주세요.");
    String input;
    try {
      input = Console.readLine().trim();
    } catch (NoSuchElementException e) {
      System.out.println("입력 과정에서 오류가 발생했습니다. 빈 문자열을 처리합니다.");
      input = "";
    }
    caculatorController.run(input);
  }
}

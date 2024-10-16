package calculator.views;

import camp.nextstep.edu.missionutils.Console;


public class calculatorInputView {

    public static String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

  public static void displayResult(long result) {
    System.out.println("결과: " + result);
  }

}

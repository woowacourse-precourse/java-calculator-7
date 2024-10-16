package calculator.views;

import java.util.Scanner;

public class calculatorInputView {

  private static final Scanner sc = new Scanner(System.in);

  public static String readInput() {
    System.out.println("덧셈할 문자열을 입력해 주세요.");
    return sc.nextLine();
  }

  public static void displayResult(long result) {
    System.out.println("결과: " + result);
  }

}

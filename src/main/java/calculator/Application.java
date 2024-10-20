package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
  public static void main(String[] args) {
    // TODO: 프로그램 구현

    System.out.println("덧셈할 문자열을 입력해 주세요.");
    System.out.flush();


    Calculator calculator = new Calculator(Console.readLine().trim());

    try {
      calculator.inputValidator();

      int[] numbersArray = calculator.allPositiveNumber().getNumbers();
      System.out.println("결과 : " + Calculator.add(numbersArray));

    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());

      throw e;

    } finally {
      Console.close();
    }
  }

}

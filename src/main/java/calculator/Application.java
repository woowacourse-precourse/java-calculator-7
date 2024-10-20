package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
  public static void main(String[] args) {
    // TODO: 프로그램 구현

    System.out.println("덧셈할 문자열을 입력해 주세요.");
    System.out.flush();


    Calculator calculator = new Calculator(Console.readLine().trim());

    try {
      if (calculator.inputValidator()) {

        calculator.matchesAndInsert();

        int[] numbersArray = calculator.allPositiveNumber().getNumbers();
        System.out.println("결과 : " + Calculator.add(numbersArray));

      } else {
        throw new IllegalArgumentException("입력을 잘못하였습니다.");
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());

      throw e;

    } finally {
      Console.close();
    }
  }

}

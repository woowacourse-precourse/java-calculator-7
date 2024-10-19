package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {
  public static void main(String[] args) {
    // TODO: 프로그램 구현

    System.out.println("덧셈할 문자열을 입력해 주세요.");

    String input = Console.readLine().trim();

    try {

      Calculator calculator = new Calculator(input);

      if (calculator.inputValidator()) {

        calculator.matchesAndInsert();

        int[] numbersArray = calculator.allPositiveNumber().getNumbers();


        int result=Calculator.add(numbersArray);

        System.out.println("결과 : " + result);

      } else {
        throw new IllegalArgumentException("입력을 잘못하였습니다.");
      }

    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    } finally {
      Console.close();
    }

  }
}

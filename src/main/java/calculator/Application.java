package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {
  public static void main(String[] args) {
    // TODO: 프로그램 구현
    final String SORT = "(//([^0-9])\\\\n)?(([0-9]+[^0-9]+)*[0-9]*)$";


    int sum = 0;


    System.out.println("덧셈할 문자열을 입력해 주세요.");

    Calculator calculator = new Calculator(Console.readLine().trim());

    try {

      if (calculator.isValidInput(SORT)) {

        calculator = calculator.splitValues().matchesRegex();

        System.out.println(calculator.getNumericString());

        System.out.println("결과 : " + calculator.add(new int[]{1, 2, 3}));

      } else {
        throw new IllegalArgumentException("양식에 맞게 입력했는지 확인해 주세요");
      }

    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }


  }
}

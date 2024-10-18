package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {
  public static void main(String[] args) {
    // TODO: 프로그램 구현
//    final String SORT = "^//([^0-9\\\\n])\\\\n([^\\\\n]+)$";
    final String SORT="(//([^0-9]+)\\\\n?)?([0-9]+|[^0-9]+)+";
    int sum = 0;
    System.out.println("양수를 ,와:으로 구분해 작성해주세요 다른구분자를 원하시면 \"//[구분자]\\n[작성]\"으로 작성해 주세요 (ex://;\\n1;2;3)");

    Calculator calculator = new Calculator(Console.readLine().trim());

    if (calculator.isCorrect(SORT)) {
      calculator.division();
      calculator.check();
    }else{
      throw new IllegalArgumentException("양식에 맞게 입력했는지 확인해 주세요");
    }

    System.out.println(calculator.getStrNumber());
    System.out.println("결과 : " + calculator.add(new int[]{1, 2, 3}));
  }
}

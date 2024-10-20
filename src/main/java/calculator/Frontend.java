package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Frontend {
  // 출력 테스트 작성을 위한 로직 작성
  private Calculator calculator;
  private String readLine;
  public Frontend(String readLine) {

    calculator = new Calculator();
  }

  // 전달받은 계산 결과를 출력한다
  public void printResult() {
    System.out.println("결과 :" + accessTarget());
  }

  // 계산된 결과값에 접근한다
  public int accessTarget() {
    return calculator.calculating(this.readLine);
  }

}

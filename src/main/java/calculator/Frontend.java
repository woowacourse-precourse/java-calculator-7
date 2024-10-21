package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Frontend {
  // 출력 테스트 작성을 위한 로직 작성
  private int target;
  public Frontend(int target) {

    target = this.target;
  }

  // 전달받은 계산 결과를 출력한다
  public void printResult() {
    System.out.println("결과 :" + target);
  }

  public int getTarget() {
    return target;
  }
}

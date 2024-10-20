package calculator;

public class Frontend {
  // 출력 테스트 작성을 위한 로직 작성

  // 전달받은 계산 결과를 출력한다
  public static void printResult() {
    System.out.println("결과 :" + accessTarget());
  }

  // 계산된 결과값에 접근한다
  private int accessTarget() {
    return calculator.target();
  }

}

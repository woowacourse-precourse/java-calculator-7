package calculator;

public class Frontend {
  // 계산 결과를 출력하기 위한 로직
  private int target;
  private static final String MESSAGE = "결과 : ";

  public Frontend(int target) {
    this.target = target;
  }

  // 전달받은 계산 결과를 출력한다
  public void printCalculationResult() {
    System.out.println(MESSAGE + target);
  }
}

package calculator;
import calculator.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
  public static void run() {
    String input = Console.readLine();

    Validator.checkEmptyInput(input);
    if (!Validator.checkDefaultDelimterFormat(input) && !Validator.checkCustomDelimiterFormat(input)){
      throw new IllegalArgumentException("(기본 구분자를 활용한 입력 포맷) 또는 (커스텀 구분자 지정 포맷)이 잘못되었습니다.");
    }

    int result = PlusCalculator.calculateSum(input);

    OutputView.printResult(result);
  }
}

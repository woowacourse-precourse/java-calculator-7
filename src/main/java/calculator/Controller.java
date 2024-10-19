package calculator;
import calculator.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
  public static void run() {
    String input = Console.readLine();

    int result = PlusCalculator.calculateSum(input);

    OutputView.printResult(result);
  }
}

package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
  public static void run() {
    String input = Console.readLine();

    int result = PlusCalculator.calculateSum(input);

    System.out.println(result);
  }
}

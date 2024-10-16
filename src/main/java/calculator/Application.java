package calculator;

import calculator.io.InputHandler;
import calculator.io.OutputHandler;

public class Application {

  private static final InputHandler INPUT_HANDLER = new InputHandler();
  private static final OutputHandler OUTPUT_HANDLER = new OutputHandler();

  public static void main(String[] args) {
    String input = INPUT_HANDLER.consoleInput();

    int result = 1;

    OUTPUT_HANDLER.printOutput(result);
  }

}

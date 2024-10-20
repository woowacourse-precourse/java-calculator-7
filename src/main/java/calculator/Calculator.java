package calculator;

import calculator.inputDevice.InputDevice;
import calculator.outputDevice.OutputDevice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

      private final String EXPLAIN_TEXT = "덧셈할 문자열을 입력해주세요.";
      private final InputDevice inputDevice = new InputDevice();
      private final OutputDevice outputDevice = new OutputDevice();
      private String readInput;
      private int result;

      private List<String> separator = new ArrayList<>(Arrays.asList(",", ":"));

      public void run() {
          printExplainText(EXPLAIN_TEXT);

          readInput = inputDevice.readInput();
          calculateLogic();
          outputDevice.printResult(result);
      }

      private void printExplainText(String text) {
          System.out.println(text);
      }

      private void calculateLogic() {
          checkAndAddCustomSeparator();
          removeSeparators();
          summationAndSetResult();
      }

      private void summationAndSetResult() {
          result = readInput.chars().map(Character::getNumericValue).sum();
      }

      private void removeSeparators() {
          String separatorPattern = String.join("|", separator);
          readInput = readInput.replaceAll(separatorPattern, "");
      }

    private void checkAndAddCustomSeparator() {
        if (readInput.contains("//") && readInput.contains("\\n")) {
          String customSeparator = readInput.substring(2, readInput.indexOf("\\n"));
          separator.add(customSeparator);
          readInput = readInput.substring(5);
        }
    }

    public static Calculator getCalculator() {
        return new Calculator();
    }
}

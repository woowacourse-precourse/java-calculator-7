package calculator;

import java.util.List;

public class PlusCalculator {
  private static int sumSplitValues(List<String> splitValues) {
    int sumResult = 0;
    for (String part : splitValues) {
      Validator.checkNagativeInt(Integer.parseInt(part));
      sumResult += Integer.parseInt(part);
    }
    return sumResult;
  }
}

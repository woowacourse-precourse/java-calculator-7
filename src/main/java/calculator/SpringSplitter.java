package calculator;

import java.util.Arrays;
import java.util.List;

public class SpringSplitter {
  public static List<String> SplitbyDefaultDelimiter(String inputString) {
    List<String> defaultSplitValues = Arrays.asList(inputString.split(",|:"));
    return defaultSplitValues;
  }
}

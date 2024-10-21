package calculator.utils;

import java.util.*;

public class CalculationUtils {

  private static final List<String> separators = new ArrayList<>();

  static {
    separators.add(",");
    separators.add(":");
  }

  private static String getSeparatorPattern() {
    return String.join("|", separators);
  }

  public static String[] inputDataToArray(String inputData) {

    inputData = inputData.trim();

    if (inputData.startsWith("//")) {
      inputData = inputDataToArrayByCustomSeparator(inputData);
    }

    return inputData.split(getSeparatorPattern());
  }

  private static String inputDataToArrayByCustomSeparator(String inputData) {

    int separatorEndIndex = inputData.indexOf("\\n");

    String customSeparator = inputData.substring(2, separatorEndIndex);

    addSeparator(escapeSpecialCharacters(customSeparator));
    inputData = inputData.substring(separatorEndIndex + 2);

    return inputData;
  }

  public static String escapeSpecialCharacters(String separator) {
    return separator.replaceAll("([\\[\\]{}()\\\\*+?.^$|])", "\\\\$1");
  }

  public static void addSeparator(String newSeparator) {

    if (!separators.contains(newSeparator)) {
      separators.add(0, escapeSpecialCharacters(newSeparator));
    }
  }
}

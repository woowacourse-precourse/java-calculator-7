package calculator.utils;

public class CalculationUtils {
  private static String separator = ",|:";

  public static String[] inputDataToArray(String inputData) {

    inputData = inputData.trim();

    if (inputData.startsWith("//")) {
      inputData = inputDataToArrayByCustomSeparator(inputData);
    }

    return inputData.split(separator);
  }

  private static String inputDataToArrayByCustomSeparator(String inputData) {

    int separatorEndIndex = inputData.indexOf("\\n");

    String customSeparator = inputData.substring(2, separatorEndIndex);
    
    separator = escapeSpecialCharacters(customSeparator) + "|" + separator;
    inputData = inputData.substring(separatorEndIndex + 2);

    return inputData;
  }

  public static String escapeSpecialCharacters(String separator) {
    return separator.replaceAll("([\\[\\]{}()\\\\*+?.^$|])", "\\\\$1");
  }
}

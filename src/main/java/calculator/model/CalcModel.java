package calculator.model;

import java.util.List;

public class CalcModel {
    private final static String DEFAULT_DELIMITER_PREFIX = "[,:]";
    private final static String CUSTOM_DELIMITER_START_PREFIX = "//";

    public int calcResult(String inputString) {
        if (inputString == null || inputString.isBlank())
            return 0;

        if (inputString.startsWith(CUSTOM_DELIMITER_START_PREFIX))
            return sumWithCustomDelimiter(inputString);

        return sumNumbers(parseByDelimiter(inputString, DEFAULT_DELIMITER_PREFIX));
    }

    private int sumNumbers(List<String> numbersList) {
        return numbersList.stream().mapToInt(Integer::parseInt).sum();
    }

    public int sumWithCustomDelimiter(String inputString) {
        String customDelimiter = "[" + inputString.charAt(2) + "]";
        List<String> numbersList = parseByDelimiter(inputString, customDelimiter);
        return sumNumbers(numbersList);
    }

    public List<String> parseByDelimiter(String inputString, String delimiter) {
        if (inputString.startsWith(CUSTOM_DELIMITER_START_PREFIX)) {
            return List.of(inputString.substring(5).split(delimiter));
        } else {
            return List.of(inputString.split(delimiter));
        }
    }
}

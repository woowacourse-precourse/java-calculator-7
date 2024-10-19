package calculator.model;

import java.util.List;

public class CalcModel {
    private final static String DEFAULT_DELIMITER_PREFIX = "[,:]";

    public int calcResult(String inputString) {
        if (inputString == null || inputString.isBlank())
            return 0;

        return sumNumbers(parseByDelimiter(inputString, DEFAULT_DELIMITER_PREFIX));
    }

    private int sumNumbers(List<String> numbersList) {
        return numbersList.stream().mapToInt(Integer::parseInt).sum();
    }

    public List<String> parseByDelimiter(String inputString, String delimiter) {
        return List.of(inputString.split(delimiter));
    }
}

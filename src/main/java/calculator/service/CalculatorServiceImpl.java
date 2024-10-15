package calculator.service;

import java.util.Arrays;
import java.util.List;

public class CalculatorServiceImpl implements CalculatorService {

    private static final String START_CUSTOM_DELIMITER = "//";
    private static final String END_CUSTOM_DELIMITER = "\\n";
    private static final String BASIC_DELIMITER = ",|:";

    @Override
    public List<String> findValidNumber(String userInput) {

        List<String> numbers;
        String customDelimiter = findCustomDelimiter(userInput);
        if (customDelimiter == null || customDelimiter.isEmpty()) {
            numbers = Arrays.asList(userInput.split(BASIC_DELIMITER));
            return numbers;
        }
        String changedUserInput = userInput.substring(userInput.lastIndexOf(END_CUSTOM_DELIMITER) + 2,
                userInput.length());
        numbers = Arrays.asList(changedUserInput.split(BASIC_DELIMITER + "|" + customDelimiter));
        return numbers;
    }

    private String findCustomDelimiter(String userInput) {
        if (userInput.contains(START_CUSTOM_DELIMITER) && userInput.contains(END_CUSTOM_DELIMITER)) {
            int idx1 = userInput.indexOf(START_CUSTOM_DELIMITER) + 2;
            int idx2 = userInput.lastIndexOf(END_CUSTOM_DELIMITER);

            StringBuilder sb = new StringBuilder();
            for (int i = idx1; i < idx2; i++) {
                sb.append(userInput.charAt(i));
            }
            return sb.toString();
        }
        return null;
    }

}

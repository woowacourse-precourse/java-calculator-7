package calculator.service;

import java.util.Arrays;
import java.util.List;

public class CalculatorServiceImpl implements CalculatorService {

    private final String startCustomDelimiter = "//";
    private final String endCustomDelimiter = "\\n";
    private final String basicDelimiter = ",|:";

    @Override
    public List<String> findValidNumber(String userInput) {

        List<String> numbers;
        String customDelimiter = findCustomDelimiter(userInput);
        if (customDelimiter == null || customDelimiter.isEmpty()) {
            numbers = Arrays.asList(userInput.split(basicDelimiter));
            return numbers;
        }
        String changedUserInput = userInput.substring(userInput.lastIndexOf(endCustomDelimiter) + 2,
                userInput.length());
        numbers = Arrays.asList(changedUserInput.split(basicDelimiter + "|" + customDelimiter));
        return numbers;
    }

    private String findCustomDelimiter(String userInput) {
        if (userInput.contains(startCustomDelimiter) && userInput.contains(endCustomDelimiter)) {
            int idx1 = userInput.indexOf(startCustomDelimiter) + 2;
            int idx2 = userInput.lastIndexOf(endCustomDelimiter);

            StringBuilder sb = new StringBuilder();
            for (int i = idx1; i < idx2; i++) {
                sb.append(userInput.charAt(i));
            }
            return sb.toString();
        }
        return null;
    }

}

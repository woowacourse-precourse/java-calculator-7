package calculator.service;

import java.util.Arrays;
import java.util.List;

public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public List<String> findValidNumber(String userInput) {

        List<String> numbers;
        String customDelimiter = findCustomDelimiter(userInput);
        if (customDelimiter == null || customDelimiter.isEmpty()) {
            numbers = Arrays.asList(userInput.split(",|\\:"));
            return numbers;
        }
        String changedUserInput = userInput.substring(userInput.lastIndexOf("\\n") + 2,
                userInput.length());
        numbers = Arrays.asList(changedUserInput.split(",|\\:|\\"+ customDelimiter));
        return numbers;
    }

    private String findCustomDelimiter(String userInput) {
        if (userInput.contains("//") && userInput.contains("\\n")) {
            int idx1 = userInput.indexOf("//")+2;
            int idx2 = userInput.lastIndexOf("\\n");

            StringBuilder sb = new StringBuilder();
            for (int i = idx1; i < idx2; i++) {
                sb.append(userInput.charAt(i));
            }
            return sb.toString();
        }
        return null;
    }

}

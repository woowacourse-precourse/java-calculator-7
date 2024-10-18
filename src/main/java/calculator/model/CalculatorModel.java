package calculator.model;

import java.util.ArrayList;

public class CalculatorModel {

    public Boolean CustomDiscrimination(String input) {
        if (input.startsWith("//") && input.contains("\\n")) {
            return true;
        } else if (!input.startsWith("//") && !input.contains("\\n")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String CustomExtraction(String customInput) {
        String extraction = customInput.substring(customInput.indexOf("//") + 2, customInput.indexOf("\\n"));
        if (extraction.length() > 1 || extraction.matches("\\d+")) {
            throw new IllegalArgumentException();
        } else if (extraction.isEmpty()) {
            return null;
        }
        return extraction;
    }

    public String[] operationSetting(String operationInput, ArrayList<String> separate) {
        String separatorPattern = java.lang.String.join("|", separate);
        return operationInput.split(separatorPattern);
    }

    public int sumCalculator(String operationInput, ArrayList<String> separateList) {
        int result = 0;
        for (String number : operationSetting(operationInput, separateList)) {
            if (number.matches("[1-9]\\d*")) {
                result += Integer.parseInt(number);
            } else if (number.isEmpty()) {
                result += 0;
            } else {
                throw new IllegalArgumentException();
            }
        }
        return result;
    }
}

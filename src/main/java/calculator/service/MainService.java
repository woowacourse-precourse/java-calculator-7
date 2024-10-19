package calculator.service;

import calculator.exception.Exceptions;
import calculator.model.InputString;
import calculator.model.ResultNumbers;

import java.util.List;

public class MainService {

    Exceptions exceptions = new Exceptions();

    public void getCustomDelimiter(InputString inputString) {

        String input = inputString.getInputString();

        exceptions.validateCustomDelimiterSize(inputString.getCustomDelimiter().size());

        if (input.startsWith("//")) { //
            int customLastMark = input.indexOf("\\n");
            if (customLastMark != -1) {

                String customDelimiter = input.substring(2, customLastMark);
                inputString.addCustomDelimiter(customDelimiter);

                String refiendString = input.substring(customLastMark + 2);
                inputString.setInputString(refiendString);

                getCustomDelimiter(inputString);

            }
        }
    }

    public void extractSlashFromString(InputString inputString) {
        if (inputString.getInputString().startsWith("/")) {
            String refinedString = inputString.getInputString().replaceFirst("^/+", "");
            inputString.setInputString(refinedString);
        }
    }

    public void extractNumbersFromString(InputString input, ResultNumbers resultNumbers) {

        List<String> customDelimiter = input.getCustomDelimiter();
        StringBuilder defaultRegex = new StringBuilder("[,|:]");

        StringBuilder combinedRegex = appendCustomDelimiter(defaultRegex, customDelimiter);

        String[] numberList = input.getInputString().split(combinedRegex.toString());

        exceptions.isInvalidStringInList(numberList);

        for (String num : numberList) {
            resultNumbers.addNumberList(Integer.parseInt(num));
        }

    }

    private StringBuilder appendCustomDelimiter(StringBuilder defaultRegex, List<String> customDelimiter) {
        if (customDelimiter.isEmpty()) {
            return defaultRegex;
        }
        for(String delimiter : customDelimiter) {
            defaultRegex.append("|").append(delimiter);
        }
        return defaultRegex;
    }

    public int getResultNumber(ResultNumbers resultNumbers) {
        int result = 0;

        for(int num : resultNumbers.getNumberList()) {
            result += num;
        }
        return result;
    }

}

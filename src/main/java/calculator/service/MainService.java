package calculator.service;

import calculator.exception.Exceptions;
import calculator.model.InputString;
import calculator.model.ResultNumbers;

import java.util.List;

public class MainService {

    Exceptions exceptions = new Exceptions();

    public String getCustomDelimiter(InputString inputString) {

        String input = inputString.getInputString();

        exceptions.validateCustomDelimiterSize(inputString.getCustomDelimiter().size());

        if (input.startsWith("//")) { //
            int customLastMark = input.indexOf("\\n");
            if (customLastMark != -1) {

                String customDelimiter = input.substring(2, customLastMark);
                inputString.addCustomDelimiter(customDelimiter);

                String refiendString = input.substring(customLastMark + 2);
                inputString.setInputString(refiendString);

                return getCustomDelimiter(inputString);

            }
        }
        return input;
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

        if (!customDelimiter.isEmpty()) {
            for (String delimiter : customDelimiter) {
                defaultRegex.append("|").append(delimiter);
            }
        }

        String[] numberList = input.getInputString().split(defaultRegex.toString());

        exceptions.isInvalidStringInList(numberList);

        for (String num : numberList) {
            resultNumbers.addNumberList(Integer.parseInt(num));
        }

    }

    public void setResultNumbers(ResultNumbers resultNumbers) {

        int result = resultNumbers.getResult();

        for (int num : resultNumbers.getNumberList()) {
            result += num;
        }

        resultNumbers.setResult(result);

    }


}

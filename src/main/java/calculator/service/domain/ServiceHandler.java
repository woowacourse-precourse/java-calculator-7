package calculator.service.domain;

import java.util.List;

public class ServiceHandler {
    private final NumberHandler numberHandler = new NumberHandler();
    private final DelimiterHandler delimiterHandler = new DelimiterHandler();

    public String calculate(String userInput) {
        setDelimiterHandler(userInput);
        setNumberHandler(userInput, delimiterHandler);
        return numberHandler.calculatePlus();
    }

    private void setNumberHandler(String userInput, DelimiterHandler delimiterHandler) {
        List<Double> numbers = UserInputParser.parseNumber(userInput, delimiterHandler);
        for (Double each : numbers) {
            numberHandler.addNumber(each);
        }
    }

    private void setDelimiterHandler(String userInput) {
        List<Character> customDelimiter = UserInputParser.parseCustomDelimiter(userInput);
        for (Character each : customDelimiter) {
            delimiterHandler.addDelimiter(each);
        }
    }
}

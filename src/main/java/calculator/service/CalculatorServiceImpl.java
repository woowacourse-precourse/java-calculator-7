package calculator.service;

import java.util.List;

public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public List<String> findValidNumber(String userInput) {
        List<String> numbers = List.of(userInput.split(",|\\:"));
        return numbers;
    }
}

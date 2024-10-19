package calculator.application;

import calculator.domain.CalculatorPrompt;

public class CalculateService {

    private final ExtractService extractService;

    public CalculateService(ExtractService extractService) {
        this.extractService = extractService;
    }

    public int splitAndSum(String command) {
        CalculatorPrompt calculatorPrompt = new CalculatorPrompt(command);

        return extractService.extractNumbers(calculatorPrompt.getData())
                .stream()
                .reduce(0, Integer::sum);
    }

}

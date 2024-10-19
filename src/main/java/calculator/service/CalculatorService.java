package calculator.service;

import calculator.parser.InputParser;
import calculator.repository.CalculatorRepository;
import java.math.BigDecimal;
import java.util.List;

public class CalculatorService {

    private final CalculatorRepository calculatorRepository;
    private final InputParser inputParser;

    public CalculatorService() {
        this.calculatorRepository = new CalculatorRepository();
        this.inputParser = new InputParser();
    }

    public int parseInputAndCalculate(String input) {
        String[] splitInput = inputParser.parseInput(input);
        String delimiterPart = splitInput[0];
        String calculationPart = splitInput[1];

        if (delimiterPart != null) {
            Character customDelimiter = inputParser.parseCustomDelimiterPart(delimiterPart);
            calculatorRepository.createCustomDelimiter(customDelimiter);
        }

        List<Character> delimiters = calculatorRepository.getDelimiters();
        List<BigDecimal> numbers = inputParser.splitCalculationPartByDelimiters(calculationPart, delimiters);

        // TODO : 계산 수행 로직 작성

        return 1;
    }
}

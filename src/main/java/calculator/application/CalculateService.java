package calculator.application;

import calculator.domain.Calculator;
import java.math.BigInteger;
import java.util.List;

public class CalculateService {

    private final SeparateService separatorService;
    private final ExtractService extractService;

    public CalculateService(
            SeparateService separatorService,
            ExtractService extractService
    ) {
        this.separatorService = separatorService;
        this.extractService = extractService;
    }

    public BigInteger splitAndSum(String command) {
        List<String> separated = separatorService.separate(command);
        List<BigInteger> numbers = extractService.extractNumbers(separated);

        return new Calculator().sum(numbers);
    }

}

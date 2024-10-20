package calculator.application;

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

    public int splitAndSum(String command) {
        List<String> separated = separatorService.separate(command);

        return extractService.extractNumbers(separated)
                .stream()
                .reduce(0, Integer::sum);
    }

}

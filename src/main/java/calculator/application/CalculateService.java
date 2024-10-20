package calculator.application;

import calculator.domain.Separator;

public class CalculateService {

    private final ExtractService extractService;

    public CalculateService(ExtractService extractService) {
        this.extractService = extractService;
    }

    public int splitAndSum(String command) {
        Separator separator = new Separator();
        separator.separate(command);

        return extractService.extractNumbers(separator.getResult())
                .stream()
                .reduce(0, Integer::sum);
    }

}

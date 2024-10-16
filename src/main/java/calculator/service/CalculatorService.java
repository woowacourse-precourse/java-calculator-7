package calculator.service;

import calculator.domain.data.DataManager;
import calculator.util.extractor.NumberExtractor;

public class CalculatorService {
    private final DataManager dataManager;
    private final NumberExtractor numberExtractor;
    public CalculatorService(final DataManager dataManager, final NumberExtractor numberExtractor) {
        this.dataManager = dataManager;
        this.numberExtractor = numberExtractor;
    }

    public void printResultOfSum() {
        Long result = numberExtractor.extractNumbers(dataManager.getRawData()).stream()
                .reduce(0L, Long::sum);
        System.out.println("result = " + result);
    }

}

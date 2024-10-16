package calculator.presentation;

import calculator.domain.data.DataManager;
import calculator.domain.data.RawDataType;
import calculator.util.extractor.CustomNumberExtractor;
import calculator.util.extractor.NormalNumberExtractor;
import calculator.util.extractor.NumberExtractor;
import calculator.service.CalculatorService;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CalculatorRunner {
    public static void run() {
        System.out.println("type the string");
        final String rawData = readLine();

        final DataManager dataManager = new DataManager(rawData);
        final NumberExtractor numberExtractor = getProperExtractor(dataManager.getDataType());

        CalculatorService calculatorService = new CalculatorService(dataManager, numberExtractor);
        calculatorService.printResultOfSum();
    }
    private static NumberExtractor getProperExtractor(final RawDataType dataType) {
        if (dataType == RawDataType.NORMAL) {
            return new NormalNumberExtractor();
        }
        return new CustomNumberExtractor();
    }
}

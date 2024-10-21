package calculator.fixture;

import calculator.model.implement.DelimiterChecker;
import calculator.model.implement.DelimiterExtractor;
import calculator.model.implement.DelimiterManager;
import calculator.model.implement.DelimiterStore;
import calculator.model.implement.StringParser;
import calculator.model.service.StringSumCalculator;

public class CalculatorAppFixture {

    public static StringParser createStringParser() {
        return new StringParser(getDelimiterStore());
    }

    public static StringSumCalculator createStringSumCalculator() {
        return new StringSumCalculator(createDelimiterManager(), createStringParser());
    }

    public static DelimiterManager createDelimiterManager() {
        return new DelimiterManager(new DelimiterChecker(), getDelimiterExtractor(), DelimiterStore.getInstance());
    }

    public static DelimiterStore getDelimiterStore() {
        return DelimiterStore.getInstance();
    }

    public static DelimiterExtractor getDelimiterExtractor() {
        return new DelimiterExtractor();
    }
}

package calculator.fixture;

import calculator.model.DelimiterChecker;
import calculator.model.DelimiterExtractor;
import calculator.model.DelimiterManager;
import calculator.model.DelimiterStore;
import calculator.model.StringParser;
import calculator.model.StringSumCalculator;

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

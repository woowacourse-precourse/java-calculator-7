package calculator.extractorProvider;

import calculator.delimiterExtractor.DelimiterExtractor;
import calculator.numberExtractor.NumberExtractor;
import java.util.HashMap;

public class ExtractorMappingMap {
    private final static HashMap<String, DelimiterExtractor> delimiterExtractorMappingMap = new HashMap<>();
    private final static HashMap<String, NumberExtractor> numberExtractorMappingMap = new HashMap<>();

    public static void putDelimiterExtractor(String extractorName, DelimiterExtractor delimiterExtractor) {
        delimiterExtractorMappingMap.put(extractorName, delimiterExtractor);

    }

    public static void putNumberExtractor(String extractorName, NumberExtractor numberExtractor) {
        numberExtractorMappingMap.put(extractorName, numberExtractor);

    }

    public static HashMap<String, DelimiterExtractor> getDelimiterExtractorMappingMap() {
        return delimiterExtractorMappingMap;
    }

    public static HashMap<String, NumberExtractor> getNumberExtractorMappingMap() {
        return numberExtractorMappingMap;
    }
}

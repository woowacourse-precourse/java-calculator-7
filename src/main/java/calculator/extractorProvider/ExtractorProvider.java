package calculator.extractorProvider;

import calculator.delimiterExtractor.CustomDelimiterExtractor;
import calculator.delimiterExtractor.DefaultDelimiterExtractor;
import calculator.delimiterExtractor.DelimiterExtractor;
import calculator.numberExtractor.CustomNumberExtractor;
import calculator.numberExtractor.DefaultNumberExtractor;
import calculator.numberExtractor.NumberExtractor;
import java.util.HashMap;

public class ExtractorProvider {

    private final static HashMap<String, DelimiterExtractor> delimiterExtractorMappingMap = new HashMap<>();
    private final static HashMap<String, NumberExtractor> numberExtractorMappingMap = new HashMap<>();

    static {
        initExtractorMappingMap();
    }

    public static void initExtractorMappingMap() {
        delimiterExtractorMappingMap.put("CustomInput", new CustomDelimiterExtractor());
        delimiterExtractorMappingMap.put("DefaultInput", new DefaultDelimiterExtractor());
        numberExtractorMappingMap.put("CustomInput", new CustomNumberExtractor());
        numberExtractorMappingMap.put("DefaultInput", new DefaultNumberExtractor());
    }

    public static DelimiterExtractor getDelimiterExtractor(String type) {
        return delimiterExtractorMappingMap.get(type);

    }


    public static NumberExtractor getNumberExtractor(String type) {
        return numberExtractorMappingMap.get(type);

    }
}

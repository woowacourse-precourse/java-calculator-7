package calculator.extractorProvider;

import calculator.constants.StringConst;
import calculator.delimiterExtractor.CustomDelimiterExtractor;
import calculator.delimiterExtractor.DefaultDelimiterExtractor;
import calculator.delimiterExtractor.DelimiterExtractor;
import calculator.numberExtractor.CustomNumberExtractor;
import calculator.numberExtractor.DefaultNumberExtractor;
import calculator.numberExtractor.NumberExtractor;
import calculator.validator.Validator;
import java.util.HashMap;

public class ExtractorProvider {


    private Validator validator;


    public ExtractorProvider(Validator validator) {
        this.validator = validator;
        initExtractorMappingMap(validator);
    }

    public void initExtractorMappingMap(Validator validator) {
        ExtractorMappingMap.putDelimiterExtractor(StringConst.CUSTOM_START_STRING,
                new CustomDelimiterExtractor(validator));
        ExtractorMappingMap.putDelimiterExtractor(StringConst.DEFAULT_INPUT, new DefaultDelimiterExtractor());
        ExtractorMappingMap.putNumberExtractor(StringConst.CUSTOM_START_STRING, new CustomNumberExtractor(validator));
        ExtractorMappingMap.putNumberExtractor(StringConst.DEFAULT_INPUT, new DefaultNumberExtractor(validator));

    }

    public DelimiterExtractor getDelimiterExtractor(String type) {
        HashMap<String, DelimiterExtractor> delimiterExtractorMappingMap = ExtractorMappingMap.getDelimiterExtractorMappingMap();
        return delimiterExtractorMappingMap.get(type);

    }


    public NumberExtractor getNumberExtractor(String type) {
        HashMap<String, NumberExtractor> numberExtractorMappingMap = ExtractorMappingMap.getNumberExtractorMappingMap();
        return numberExtractorMappingMap.get(type);

    }
}

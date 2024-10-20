package calculator.extractorProvider;

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
        ExtractorMappingMap.putDelimiterExtractor("CustomInput", new CustomDelimiterExtractor());
        ExtractorMappingMap.putDelimiterExtractor("DefaultInput", new DefaultDelimiterExtractor());
        ExtractorMappingMap.putNumberExtractor("CustomInput", new CustomNumberExtractor(validator));
        ExtractorMappingMap.putNumberExtractor("DefaultInput", new DefaultNumberExtractor(validator));

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

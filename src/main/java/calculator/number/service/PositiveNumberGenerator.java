package calculator.number.service;

import calculator.number.domain.Number;
import calculator.number.domain.PositiveNumber;
import calculator.sentence.domain.Sentence;
import calculator.separator.domain.Separator;

public class PositiveNumberGenerator {
    private final NumberExtractService extractor;
    private final NumberCrateService createService;

    public PositiveNumberGenerator(NumberExtractService extractor, NumberCrateService createService) {
        this.extractor = extractor;
        this.createService = createService;
    }

    public Number create(Sentence sentence, Separator separator) {
        return createService.createNumber(sentence,
                this::extractorPositiveNumber,
                PositiveNumber::of,
                separator);
    }

    private String extractorPositiveNumber(String sentence) {
        return extractor.extractorNumber(sentence);
    }
}

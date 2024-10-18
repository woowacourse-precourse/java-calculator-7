package calculator.number.service;

import calculator.number.domain.Number;
import calculator.number.domain.impl.PositiveNumber;
import calculator.sentence.domain.Sentence;
import calculator.separator.domain.Separator;

public class NumberGenerator {
    private final NumberExtractService extractor;
    private final NumberCreateService createService;

    public NumberGenerator(NumberExtractService extractor, NumberCreateService createService) {
        this.extractor = extractor;
        this.createService = createService;
    }

    public Number create(Sentence sentence, Separator separator) {
        return createService.createNumber(
                sentence,
                this::extractorPositiveNumber,
                PositiveNumber::of,
                separator);
    }

    public String extractorPositiveNumber(String sentence) {
        return extractor.extractorNumber(sentence);
    }
}

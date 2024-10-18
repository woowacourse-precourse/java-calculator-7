package calculator.generator.number;

import calculator.number.domain.Number;
import calculator.number.domain.impl.PositiveNumber;
import calculator.sentence.domain.Sentence;

import java.util.List;

public class NumberGenerator {
    private final NumberExtractService extractor;
    private final NumberCreateService createService;

    public NumberGenerator(NumberExtractService extractor, NumberCreateService createService) {
        this.extractor = extractor;
        this.createService = createService;
    }

    public Number create(Sentence sentence) {
        return createService.createNumber(
                sentence,
                this::extractorPositiveNumber,
                PositiveNumber::of);
    }

    private List<String> extractorPositiveNumber(String sentence) {
        return extractor.extractorNumber(sentence);
    }
}

package calculator.service.generator.number;

import calculator.number.domain.NumberService;
import calculator.number.util.NumberConvertorService;
import calculator.sentence.dto.Sentence;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class NumberGenerator {
    private final NumberExtractService extractor;
    private final NumberCreateService createService;

    public NumberGenerator(NumberExtractService extractor, NumberCreateService createService) {
        this.extractor = extractor;
        this.createService = createService;
    }

    public NumberService create(Sentence sentence,
                                Supplier<NumberConvertorService> convertorServiceSupplier,
                                Function<List<Number>, NumberService> function) {

        return createService.createNumber(sentence, this::extractorPositiveNumber, convertorServiceSupplier, function);
    }

    private List<String> extractorPositiveNumber(String sentence) {
        return extractor.extractorNumber(sentence);
    }
}

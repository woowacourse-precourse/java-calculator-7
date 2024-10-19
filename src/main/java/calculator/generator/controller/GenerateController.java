package calculator.generator.controller;

import calculator.number.domain.NumberService;
import calculator.generator.number.NumberGenerator;
import calculator.number.util.NumberConvertorService;
import calculator.sentence.domain.Sentence;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class GenerateController {
    private final NumberGenerator numberGenerator;

    public GenerateController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public NumberService createNumber(
            Sentence sentence,
            Supplier<NumberConvertorService> convertorServiceSupplier,
            Function<List<Number>, NumberService> function) {
        return numberGenerator.create(sentence, convertorServiceSupplier, function);
    }
}

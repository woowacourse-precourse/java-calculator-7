package calculator.generator.controller;

import calculator.number.domain.Number;
import calculator.generator.number.NumberGenerator;
import calculator.sentence.domain.Sentence;

public class GenerateController {
    private final NumberGenerator numberGenerator;
    public GenerateController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }
    public Number createNumber(Sentence sentence) {
        return numberGenerator.create(sentence);
    }
}

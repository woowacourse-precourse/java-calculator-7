package calculator.generator.controller;

import calculator.number.domain.Number;
import calculator.generator.number.NumberGenerator;
import calculator.sentence.domain.Sentence;
import calculator.separator.domain.Separator;
import calculator.generator.separator.SeparatorGenerator;

public class GenerateController {
    private final SeparatorGenerator separatorGenerator;
    private final NumberGenerator numberGenerator;
    public GenerateController(SeparatorGenerator separatorGenerator,
                              NumberGenerator numberGenerator) {
        this.separatorGenerator = separatorGenerator;
        this.numberGenerator = numberGenerator;
    }
    public Separator createSeparator(Sentence sentence) {
        return separatorGenerator.create(sentence);
    }
    public Number createNumber(Sentence sentence, Separator separator) {
        return numberGenerator.create(sentence, separator);
    }
}

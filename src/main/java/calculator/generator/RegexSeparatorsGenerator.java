package calculator.generator;

import calculator.domain.RegexSeparators;
import calculator.domain.Separators;
import calculator.extractor.CustomSeparatorExtractor;

public class RegexSeparatorsGenerator implements SeparatorsGenerator {
    private final CustomSeparatorExtractor extractor;

    public RegexSeparatorsGenerator(CustomSeparatorExtractor extractor) {
        this.extractor = extractor;
    }

    @Override
    public Separators create(String input) {
        Separators separators = RegexSeparators.createWithDefault();

        return extractor.run(input)
                .map(separators::add)
                .orElse(separators);
    }

}

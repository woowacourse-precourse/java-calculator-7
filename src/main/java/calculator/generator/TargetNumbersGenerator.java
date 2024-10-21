package calculator.generator;

import calculator.domain.Separators;
import calculator.domain.TargetNumbers;
import calculator.extractor.TargetNumbersExtractor;
import calculator.remover.CustomSeparatorRemover;
import java.util.List;

public class TargetNumbersGenerator {

    private final CustomSeparatorRemover customSeparatorRemover;
    private final TargetNumbersExtractor extractor;

    public TargetNumbersGenerator(CustomSeparatorRemover customSeparatorRemover, TargetNumbersExtractor extractor) {
        this.customSeparatorRemover = customSeparatorRemover;
        this.extractor = extractor;
    }

    public TargetNumbers create(Separators separators, String input) {
        input = customSeparatorRemover.run(input);
        List<Integer> targetNumbers = extractor.run(separators, input);
        return new TargetNumbers(targetNumbers);
    }

}

package calculator.service.generator;

import calculator.sentence.domain.Sentence;
import calculator.separator.domain.Separator;
import calculator.separator.service.SeparatorCreateService;
import calculator.separator.service.SeparatorExtractService;

public class SeparatorGenerator {
    private final SeparatorExtractService extractor;
    private final SeparatorCreateService createService;
    public SeparatorGenerator(SeparatorExtractService extractor, SeparatorCreateService createService) {
        this.extractor = extractor;
        this.createService = createService;
    }
    private String extractorCustomSeparator(String sentence) {
        return extractor.extractorSeparator(sentence);
    }
    public Separator create(Sentence sentence) {
        return createService.createSeprator(sentence, this::extractorCustomSeparator, Separator::new);
    }
}

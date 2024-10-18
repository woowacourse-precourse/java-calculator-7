package calculator.generator.separator.impl;

import calculator.sentence.domain.Sentence;
import calculator.generator.separator.SeparatorCreateService;

import java.util.function.Function;

public class SeparatorCreateProcess implements SeparatorCreateService{

    @Override
    public <R> R createSeprator(Sentence sentence,
                                Function<String, String> transFunction,
                                Function<String, R> constructor) {
        String extractedValue = transFunction.apply(sentence.getSentence());
        return constructor.apply(extractedValue);
    }
}

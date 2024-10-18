package calculator.generator.number.impl;

import calculator.generator.number.NumberCreateService;
import calculator.sentence.domain.Sentence;

import java.util.List;
import java.util.function.Function;

public class NumberCreateProcess implements NumberCreateService {
    @Override
    public <R> R createNumber(Sentence sentence,
                              Function<String, List<String>> transFunction,
                              Function<List<String>, R> constructor) {
        List<String> stringToSplitBySeparator = transFunction.apply(sentence.getSentence());
        return constructor.apply(stringToSplitBySeparator);
    }
}

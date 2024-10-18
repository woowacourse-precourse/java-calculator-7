package calculator.separator.service;


import calculator.sentence.domain.Sentence;

import java.util.function.Function;

public interface SeparatorCreateService {
    <R> R createSeprator(Sentence sentence, Function<String, String> transFunction, Function<String, R> constructor);
}

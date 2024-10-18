package calculator.generator.number;

import calculator.sentence.domain.Sentence;

import java.util.List;
import java.util.function.Function;

public interface NumberCreateService {
    <R> R createNumber(
            Sentence sentence,
            Function<String, List<String>> transFunction,
            Function<List<String>, R> constructor);
}

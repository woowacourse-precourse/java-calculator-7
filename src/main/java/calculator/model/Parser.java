package calculator.model;

import java.util.List;
import java.util.function.Function;

public interface Parser<E> {

    List<E> parse(Function<String, E> valueType);     // 문자열 파싱
    boolean checkIncorrectGrammar();                        // 문법 검사
}

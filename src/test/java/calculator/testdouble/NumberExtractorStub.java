package calculator.testdouble;

import calculator.numberExtractor.NumberExtractor;
import java.util.List;
import java.util.Set;

public class NumberExtractorStub implements NumberExtractor {

    @Override
    public List<Integer> extract(String str, Set<Character> separators) {
        return List.of(1, 2, 3);
    }
}

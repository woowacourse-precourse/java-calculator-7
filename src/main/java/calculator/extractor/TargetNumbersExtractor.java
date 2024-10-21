package calculator.extractor;

import calculator.domain.Separators;
import java.util.List;

public interface TargetNumbersExtractor {
    List<Integer> run(Separators separators, String input);

}

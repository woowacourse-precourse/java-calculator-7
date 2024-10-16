package calculator.domain.extractor;

import java.util.List;

public interface NumberExtractor {
    List<Long> extractNumbers(String data);

    Long calculateSum();
}

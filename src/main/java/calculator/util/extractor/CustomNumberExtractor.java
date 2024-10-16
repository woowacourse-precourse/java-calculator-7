package calculator.domain.extractor;

import java.util.ArrayList;
import java.util.List;

public class CustomNumberExtractor implements NumberExtractor{
    @Override
    public List<Long> extractNumbers(String data) {
        final List<Long> numbers = new ArrayList<>();
        return numbers;
    }
    @Override
    public Long calculateSum() {
        return null;
    }
}

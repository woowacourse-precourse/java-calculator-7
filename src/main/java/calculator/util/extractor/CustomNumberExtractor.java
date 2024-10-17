package calculator.util.extractor;

import java.util.ArrayList;
import java.util.List;

public class CustomNumberExtractor implements NumberExtractor{
    private static final NumberExtractor instance = new CustomNumberExtractor();
    private CustomNumberExtractor(){

    }

    public static NumberExtractor getInstance() {
        return instance;
    }
    @Override
    public List<Long> extractNumbers(String data) {
        final List<Long> numbers = new ArrayList<>();
        return numbers;
    }
}

package calculator.fake;

import calculator.application.ExtractService;
import java.util.List;

public class FakeExtractService implements ExtractService {

    @Override
    public List<Long> extractNumbers(List<String> data) {
        return List.of(1L, 2L, 3L);
    }

}

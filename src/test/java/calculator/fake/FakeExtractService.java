package calculator.fake;

import calculator.application.ExtractService;
import java.util.List;

public class FakeExtractService implements ExtractService {

    @Override
    public List<Integer> extractNumbers(List<String> data) {
        return List.of();
    }

}

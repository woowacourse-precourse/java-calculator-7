package calculator.fake;

import calculator.application.SeparateService;
import java.util.List;

public class FakeSeparateService implements SeparateService {

    @Override
    public List<String> separate(String command) {
        return List.of("1", "2", "3");
    }

}

package calculator.service;

import calculator.model.separate.SeparateManager;
import java.util.List;

public class SeparateService {

    public SeparateService() {
    }

    public List<Integer> separateInput(String input) {
        SeparateManager separateManager = SeparateManager.initiate();
        if (separateManager.canParseCustomDelimiter(input)) {
            separateManager.extractCustomDelimiter(input);
        }
        return separateManager.separate(input);
    }
}

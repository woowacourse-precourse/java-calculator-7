package calculator.application.impl;

import calculator.application.SeparateService;
import calculator.domain.Separator;
import java.util.List;

public class StringCalculatorSeparateService implements SeparateService {

    @Override
    public List<String> separate(String command) {
        Separator separator = new Separator();
        separator.separate(command);

        return separator.getResult();
    }

}

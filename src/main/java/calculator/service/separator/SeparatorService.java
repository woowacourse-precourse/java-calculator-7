package calculator.service.separator;

import calculator.domain.number.Numbers;
import calculator.domain.separator.Separator;

public class SeparatorService {

    public Numbers separate(Separator separator, String input) {
        return separator.separate(input);
    }
}

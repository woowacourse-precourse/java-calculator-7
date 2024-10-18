package calculator.view;

import java.util.List;

public class InputValidator {
    public void validatingSeparator(List<String> separated, List<String> separators) {
        for (int i = 0; i < separated.size(); i++) {
            if (i % 2 == 1) { // 구분자
                if (!separators.contains(separated.get(i))) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}

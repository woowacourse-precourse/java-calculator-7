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

    public void lastElement(List<String> separated) {
        // 마지막 요소의 첫글자가 숫자가 아닐경우 exception
        // 첫글자가 숫자면 나머지 글자도 숫자임
        if (!Character.isDigit(separated.getLast().charAt(0))) {
            throw new IllegalArgumentException();
        }
    }
}

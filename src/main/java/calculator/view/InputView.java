package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String receiveValue() {
        System.out.println("덧셈할 문자열을 입력해 주세요. Ex)1,2,3 ");
        String value = Console.readLine();
        extracted(value);
        return value;
    }

    private void extracted(final String value) {
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("값을 입력하지 않으면 안됩니다.");
        }
    }

}

package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String getNumberWithSeparator() {
        String numberWithSeparator = Console.readLine();
        checkNull(numberWithSeparator);
        return numberWithSeparator;
    }

    private void checkNull(String numberWithSeparator) {
        if (numberWithSeparator == null) {
            throw new IllegalArgumentException("문자열을 입력해야 합니다.");
        }
    }
}

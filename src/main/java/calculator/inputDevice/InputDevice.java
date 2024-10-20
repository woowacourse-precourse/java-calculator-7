package calculator.inputDevice;

import camp.nextstep.edu.missionutils.Console;

public class InputDevice {

    public String readInput() {

        String inputString = Console.readLine();

        if (inputString.matches(".*-\\d.*")) {
          throw new IllegalArgumentException("음수는 계산에 포함될 수 없습니다.");
        }

        return inputString;
    }
}

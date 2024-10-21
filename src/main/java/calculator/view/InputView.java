package calculator.view;

import calculator.dto.CalculatorRequestDto;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static CalculatorRequestDto beginInput() {
        System.out.println(ViewMessages.INPUT_MESSAGE.getMessage());

        String input = Console.readLine();
        Console.close();

        return new CalculatorRequestDto(input);
    }

}

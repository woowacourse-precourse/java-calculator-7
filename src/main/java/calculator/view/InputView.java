package calculator.view;

import calculator.dto.UserInputDTO;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static UserInputDTO getOperandInput(){
        return new UserInputDTO(Console.readLine());
    }
}
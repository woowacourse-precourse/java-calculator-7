package calculator.io;

import calculator.dto.InputDTO;
import calculator.validation.IOValidation;
import camp.nextstep.edu.missionutils.*;

public class CalculatorIO {
    public static InputDTO getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        return new InputDTO( input );
    }

    public static void loggingRes( int res ) {
        System.out.printf("결과 : %d\n", res );
        Console.close();
    }
}

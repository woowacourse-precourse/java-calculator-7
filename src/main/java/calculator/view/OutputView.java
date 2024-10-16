package calculator.view;

import calculator.helper.InputHelper;
import calculator.helper.OutputHelper;
import camp.nextstep.edu.missionutils.Console;

public class OutputView {

    public static void outputResult(int result){
        System.out.println(OutputHelper.getFormattedOutputStr(result));
    }

    public static void requestCalStr() {
        System.out.println(InputHelper.INPUT_CALCULATE_STR);
    }

    public static void invalidInputError(){
        System.out.println(InputHelper.INVALID_INPUT);
    }
}

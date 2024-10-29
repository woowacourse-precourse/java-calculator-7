package calculator.view;

import calculator.model.domain.Separator;
import calculator.validation.CustomSeparatorValidation;
import calculator.validation.NotAllowedInputValidation;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {
    }

    public static String inputString() {
        String inputString = Console.readLine();
        CustomSeparatorValidation.validate(inputString);
        String processedInputString = Separator.separatorGenerator(inputString);
        NotAllowedInputValidation.validate(processedInputString);
        return processedInputString;
    }
}
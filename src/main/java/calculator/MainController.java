package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class MainController {

    public static void run() {
        String inputString = InputView.readString();
        int sumResult = calculateSum(inputString);
        OutputView.printResult(sumResult);
    }
    
    private static int calculateSum(String inputString) {
        List<String> splitValues;

        if(Validator.checkDefaultDelimterFormat(inputString)){
            splitValues = StringSplitter.SplitbyDefaultDelimiter(inputString);
            return sumsplitValues(splitValues);
        }

        if (Validator.checkCustomDelimiterFormat(inputString)){
            splitValues = StringSplitter.SplitbyCustomDelimiter(inputString);
            return sumsplitValues(splitValues);
        }
        return 0;
    }
    private static int sumsplitValues(List<String> splitValues) {
        int sumResult = 0;
        for (String part : splitValues) {
            Validator.checkNagativeInt(Integer.parseInt(part));
            sumResult += Integer.parseInt(part);
        }
        return sumResult;
    }
}

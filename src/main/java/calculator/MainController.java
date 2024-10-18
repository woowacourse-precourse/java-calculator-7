package calculator;

import calculator.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {

    public static void run() {
        String inputString = InputView.readString();
        int sumResult = getSplittedValuesSum(inputString);
        printResult(sumResult);
    }

    private static void printResult(int sumResult) {
         System.out.printf("결과 : %d", sumResult);
    }

    private static int getSplittedValuesSum(String inputString) {
        List<String> splittedValues;
        int sumResult = 0 ;

        if(Validator.checkDefaultDelimterFormat(inputString)){
            splittedValues = SplitbyDefaultDelimiter(inputString);
            return getSumResult(splittedValues);
        }

        if (Validator.checkCustomDelimiterFormat(inputString)){
            splittedValues = SplitbyCustomDelimiter(inputString);
            sumResult = getSumResult(splittedValues);
        }
        return sumResult;
    }
    private static int getSumResult(List<String> splittedValues) {
        int sumResult = 0;
        for (String part : splittedValues) {
            Validator.checkNagativeInt(Integer.parseInt(part));
            sumResult += Integer.parseInt(part);
        }
        return sumResult;
    }

    private static List<String> SplitbyDefaultDelimiter(String inputString) {
        List<String> defaultSplitValues = Arrays.asList(inputString.split(",|:"));
        return defaultSplitValues;
    }

    private static List<String> SplitbyCustomDelimiter(String inputString) {
        String customDelimiter = String.valueOf(inputString.charAt(2));
        String remainingInput = inputString.substring(5);

        if (Validator.checkRemainStringFormat(remainingInput, customDelimiter)) {
            List<String> customSplitValues = Arrays.asList(remainingInput.split(customDelimiter));
            return customSplitValues;
        }
        throw new IllegalArgumentException("커스텀 구분자 지정형식 뒤의 계산할 문자열 형식을 확인해주세요");
    }



}

package calculator.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static List<String> getInput(){
        List<String> ret = new ArrayList<String>();
        String input = Console.readLine();

        String customSeparator = extractCustomSeparator(input);
        String customFormula = extractFormula(input);

        ret.add(customSeparator);
        ret.add(customFormula);

        return ret;
    }

    private static String extractCustomSeparator(String input) {
        String subStr = input.substring(0, 5);

        if (subStr.startsWith("//")) {
            if(subStr.endsWith("\\n"))
                return "" + subStr.charAt(2);
        }

        return null;
    }

    private static String extractFormula(String input){
        String formula = input;

        if (input.startsWith("//"))
            formula = input.substring(5);

        return formula;
    }
}

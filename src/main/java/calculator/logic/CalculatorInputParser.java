package calculator.logic;

import calculator.util.ValidationUtil;
import java.util.ArrayList;
import java.util.List;

public class CalculatorInputParser {
    private final ValidationUtil validationUtil = new ValidationUtil();

    public List<Integer> splitInitialString(String initialString) {
        String separators = ",|:";

        if (initialString.startsWith("//")) {
            validationUtil.isValidSeparatorType(initialString);
            separators = separators + "|" + setExtraSeparator(initialString);
            initialString = initialString.substring(5);
        }

        String[] numList = initialString.split(separators);
        List<Integer> integerList = new ArrayList<>();

        for (String s : numList) {
            if (s.isEmpty()) {
                integerList.add(0);
                continue;
            }
            validationUtil.isValidNumber(s);
            integerList.add(Integer.valueOf(s));
        }
        return integerList;
    }

    private String setExtraSeparator(String initialString) {
        char extraSeparator = initialString.charAt(2);
        return "\\" + extraSeparator;
    }
}

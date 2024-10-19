package calculator.logic;

import calculator.util.ValidationUtil;
import java.util.ArrayList;
import java.util.List;

public class CalculatorInputParser {
    private final ValidationUtil validationUtil = new ValidationUtil();

    public List<Integer> splitInitialString(String initialString) {
        String separators = ",|:";

        if (initialString.startsWith("//")) {
//          구분자가 //<문자>\n 형태인가
            validationUtil.isValidSeparatorType(initialString);
            separators = separators + "|" + setExtraSeparator(initialString);
            initialString = initialString.substring(5);
        }
        System.out.println(separators);

        String[] numList = initialString.split(separators);
        List<Integer> integerList = new ArrayList<>();

        for (String s : numList) {
            if (s.isEmpty()) {
                integerList.add(0);
                continue;
            }
            validationUtil.isValidNumber(s);
            integerList.add(Integer.valueOf(s));
//            System.out.println(Integer.valueOf(s));
        }
        return integerList;

    }

    private String setExtraSeparator(String initialString) {
//      구분자가 특수문자일 경우 처리
//      !@#$%^&* 특수문자 고려
        char extraSeparator = initialString.charAt(2);
        if (validationUtil.isSpecialSeparator(extraSeparator)) {
            return "\\" + extraSeparator;
        }
        return initialString.substring(2, 3);

    }

}

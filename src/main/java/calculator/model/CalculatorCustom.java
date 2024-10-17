package calculator.model;

import java.util.Arrays;
import java.util.regex.Pattern;

public class CalculatorCustom implements Calculator{

    private final String string;

    public CalculatorCustom(String string) {
        this.string = string;
    }

    @Override
    public int calculate() {
        int calcResult = 0;

        String[] firstSplit = string.split("\\\\n");
        String customDelim = firstSplit[0].split("//")[1].trim();
        String[] calcList = firstSplit[1].split(Pattern.quote(customDelim));

        for (String eachList : calcList) {
            calcResult += Integer.parseInt(eachList);
        }

        return calcResult;
    }

}

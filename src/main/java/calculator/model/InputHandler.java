package calculator.model;

import static calculator.model.Calculator.getSum;
import static calculator.model.InputValidator.validateExtractedNumbers;

import camp.nextstep.edu.missionutils.Console;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {
    private String inputString;
    private String customDelimiter = null;
    private Vector<Integer> extractedNumbers = new Vector<>();


    public void setInputString() {
        this.inputString = Console.readLine();
    }


    public void ensureCustomDelimiter() {
        String regExp = "^//(.)\\\\n";

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            customDelimiter = matcher.group(1);
        }

    }


    public void extractNumbers() {
        String target = inputString;
        String regExp = "[" + customDelimiter + ",:]+";

        target = removeDelimiterCreator(target);

        String[] extractedStrings = target.split(regExp);
        validateExtractedNumbers(extractedStrings);

        for (String extractedString : extractedStrings) {
            int extractedNumber = Integer.parseInt(extractedString);
            extractedNumbers.add(extractedNumber);
        }
    }

    public String removeDelimiterCreator(String target) {
        if (customDelimiter != null) {
            String targetToDelete = "^//" + customDelimiter + "\\\\n";
            target = target.replaceFirst(targetToDelete, "");
        }
        return target;
    }


    public int getResult() {
        return getSum(extractedNumbers);
    }


}

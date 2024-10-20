package calculator.domain;

import static calculator.domain.Calculator.getSum;
import static calculator.domain.InputValidator.validateExtractedNumbers;

import calculator.domain.constants.DefaultDelimiter;
import camp.nextstep.edu.missionutils.Console;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {
    private String inputString;
    private String customDelimiter = "";
    private Vector<Integer> extractedNumbers = new Vector<>();


    public void setInputString() {
        this.inputString = Console.readLine();
    }


    public void ensureCustomDelimiter() {
        Pattern pattern = Pattern.compile("^//(.)\\\\n");
        Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            customDelimiter = matcher.group(1);
        }

    }


    public void extractNumbers() {
        String target = inputString;
        target = removeDelimiterCreator(target);

        String regExp = generateRegex();
        String[] extractedStrings = target.split(regExp);

        validateExtractedNumbers(extractedStrings);

        for (String extractedString : extractedStrings) {
            int extractedNumber = Integer.parseInt(extractedString);
            extractedNumbers.add(extractedNumber);
        }
    }

    public String generateRegex() {
        String colon = DefaultDelimiter.COLON.getValue();
        String comma = DefaultDelimiter.COMMA.getValue();

        return "[" + String.join(customDelimiter, colon, comma) + "]+";

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

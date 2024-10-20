package calculator.domain;

import static calculator.domain.InputValidator.validateExtractedNumbers;
import static calculator.domain.MathOperator.getSum;

import calculator.domain.constants.DefaultDelimiter;
import camp.nextstep.edu.missionutils.Console;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputProcessor {
    private String inputString;
    private String customDelimiter = "";
    private int result = 0;
    private Vector<Integer> extractedNumbers = new Vector<>();

    public void setInputString() {
        this.inputString = Console.readLine();
    }

    public void processInputString() {
        if (!inputString.isEmpty()) {
            ensureCustomDelimiter();
            extractNumbers();
            result = getSum(extractedNumbers);
        }

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
        addToExtractedNumbers(extractedStrings);
    }

    public void addToExtractedNumbers(String[] extractedStrings) {
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
        if (!customDelimiter.isEmpty()) {
            String targetToDelete = "^//" + customDelimiter + "\\\\n";
            target = target.replaceFirst(targetToDelete, "");
        }
        return target;
    }


    public int getResult() {
        return result;
    }
}

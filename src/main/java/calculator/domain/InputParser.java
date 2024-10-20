package calculator.domain;

import static calculator.domain.InputValidator.validateExtractedNumbers;

import calculator.domain.constants.DefaultDelimiter;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    private String inputString;
    private String customDelimiter = "";

    public void parseInput(String inputString, Vector<Integer> extractedNumbers) {
        this.inputString = inputString;
        ensureCustomDelimiter();
        extractNumbers(extractedNumbers);
    }


    public void ensureCustomDelimiter() {
        Pattern pattern = Pattern.compile("^//(.)\\\\n");
        Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            customDelimiter = matcher.group(1);
        }
    }

    public void extractNumbers(Vector<Integer> extractedNumbers) {
        String target = inputString;
        target = removeDelimiterCreator(target);

        String regExp = generateRegex();
        String[] extractedStrings = target.split(regExp);

        validateExtractedNumbers(extractedStrings);
        addToExtractedNumbers(extractedStrings, extractedNumbers);
    }

    public void addToExtractedNumbers(String[] extractedStrings, Vector<Integer> extractedNumbers) {
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

}

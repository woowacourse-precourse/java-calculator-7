package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringSpliter {
    private String userInput;
    private String customDel;

    public StringSpliter(String userInput) {
        this.userInput = userInput;
    }

    public StringSpliter(String userInput, String customDel) {
        this.userInput = userInput;
        this.customDel = customDel;
    }

    public List<String> splitUserInput() {
        List<String> splitUserInputs = new ArrayList<>();
        StringTokenizer halfSplitUserInput = new StringTokenizer(userInput, COMMA);
        while (halfSplitUserInput.hasMoreTokens()) {
            StringTokenizer lastSplit = new StringTokenizer(halfSplitUserInput.nextToken(), COLON);
            while (lastSplit.hasMoreTokens()) {
                splitUserInputs.add(lastSplit.nextToken());
            }
        }
        return splitUserInputs;
    }

    public List<String> splitCustomDelUserInput() {
        List<String> splitUserInputs = new ArrayList<>();
        StringTokenizer firstSplit = new StringTokenizer(userInput, customDel);
        while (firstSplit.hasMoreTokens()) {
            StringTokenizer secondSplit = new StringTokenizer(firstSplit.nextToken(), COMMA);
            while (secondSplit.hasMoreTokens()) {
                StringTokenizer lastSplit = new StringTokenizer(secondSplit.nextToken(), COLON);
                while (lastSplit.hasMoreTokens()) {
                    splitUserInputs.add(lastSplit.nextToken());
                }
            }
        }
        return splitUserInputs;
    }

    private final String COMMA = ",";
    private final String COLON = ":";

}

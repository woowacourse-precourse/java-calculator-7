package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Splitter {
    private String userInput;
    private String DELIMITER = ",|:";

    public Splitter(String userInput) {
        this.userInput = userInput;
    }

    public List<String> splitString() throws IllegalArgumentException {
        if (hasCustomSpliter()) {
            DELIMITER += ("|" + getCustomSpliter());
        }
        if (isEmptyString()) {
            return Collections.emptyList();
        }
        return Arrays.stream(userInput.split(DELIMITER)).toList();
    }

    private boolean isEmptyString() {
        return userInput.isEmpty();
    }

    private boolean hasCustomSpliter() {
        if (userInput.length() >= 5 && userInput.startsWith("//")) {
            return true;
        } else {
            return false;
        }
    }

    private String getCustomSpliter() {
        int delimiterIndex = userInput.indexOf("\\n");
        String newDelimiter = userInput.substring(2, delimiterIndex);
        userInput = userInput.substring(delimiterIndex + 2);
        return newDelimiter;
    }
}

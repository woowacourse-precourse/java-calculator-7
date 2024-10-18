package calculator.basic;

import calculator.io.InputHandler;

public class BasicHandler {
    private static final String DELIMITERS = "[,:]";
    private static final String DELIMITER_COMMAS = ",";
    private static final String DELIMITERS_COLON = ":";
    private final InputHandler inputHandler;

    private BasicHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public static BasicHandler of(InputHandler inputHandler) {
        return new BasicHandler(inputHandler);
    }

    public String[] convertValidInputList(String userInput) {
        inputHandler.lastIndexIsInteger(userInput);

        checkDelimiterDuplicate(userInput);

        String[] separatorInput = userInput.split(DELIMITERS);
        for (String s : separatorInput) {
            inputHandler.isPositiveInteger(s);
        }

        return separatorInput;
    }

    public void checkDelimiterDuplicate(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (DELIMITER_COMMAS.equals(String.valueOf(userInput.charAt(i)))
                    || DELIMITERS_COLON.equals(String.valueOf(userInput.charAt(i)))
            ) {
                if (
                        (i + 1 < userInput.length())
                                && (DELIMITER_COMMAS.equals(String.valueOf(userInput.charAt(i + 1)))
                                || DELIMITERS_COLON.equals(String.valueOf(userInput.charAt(i + 1))))
                ) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}

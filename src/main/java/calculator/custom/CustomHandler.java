package calculator.custom;

import calculator.io.InputHandler;

public class CustomHandler {
    private static final String CUSTOM_START = "//";
    private static final String CUSTOM_END = "\\n";
    private final InputHandler inputHandler;

    private CustomHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public static CustomHandler of(InputHandler inputHandler) {
        return new CustomHandler(inputHandler);
    }

    public boolean checkInputIsCustom(String userInput) {
        return userInput.startsWith(CUSTOM_START)
                && (userInput.indexOf(CUSTOM_END, 3) != -1);
    }

    public String[] convertValidInputListCustom(String userInput) {
        String delimiter = userInput.substring(CUSTOM_START.length(), CUSTOM_START.length() + 1);
        String extractInputs = userInput.substring(CUSTOM_START.length() + CUSTOM_END.length() + 1);

        inputHandler.lastIndexIsInteger(extractInputs);

        checkDelimiterDuplicateCustom(extractInputs, delimiter);

        String[] separatorInput = extractInputs.split(delimiter);
        for (String s : separatorInput) {
            inputHandler.isPositiveInteger(s);
        }

        return separatorInput;
    }

    public void checkDelimiterDuplicateCustom(String extractInput, String delimiter) {
        for (int i = 0; i < extractInput.length(); i++) {
            if (delimiter.equals(String.valueOf(extractInput.charAt(i)))
            ) {
                if (
                        (i + 1 < extractInput.length())
                                && (delimiter.equals(String.valueOf(extractInput.charAt(i + 1))))
                ) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}

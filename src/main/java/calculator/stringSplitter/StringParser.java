package calculator.stringSplitter;

public class StringParser {

    private final SeparatorManager separatorManager;
    private final InputValidator inputValidator;

    public StringParser(SeparatorManager separatorManager, InputValidator inputValidator) {
        this.separatorManager = separatorManager;
        this.inputValidator = inputValidator;
    }

    public String[] parse(String input) {
        validateInput(input);
        String numberPart = extractNumberPart(input);
        return splitNumbers(numberPart);
    }

    private void validateInput(String input) {
        inputValidator.checkLastCharIsDigit(input);
        if (input.startsWith("//")) {
            validateCustomSeparatorInput(input);
        }
    }

    private void validateCustomSeparatorInput(String input) {
        inputValidator.validateCustomSeparatorInput(input);
        int endPoint = input.lastIndexOf("\\n");
        String customParts = input.substring(2, endPoint);
        inputValidator.validateSeparators(customParts);
        separatorManager.addSeparator(customParts);
    }

    private String extractNumberPart(String input) {
        if (input.startsWith("//")) {
            int endPoint = input.lastIndexOf("\\n");
            return input.substring(endPoint + 2);
        }
        return input;
    }

    private String[] splitNumbers(String numberPart) {
        inputValidator.validateInput(separatorManager.getSeparators(), numberPart);
        String separatorPattern = separatorManager.createSeparatorPattern();
        return numberPart.split(separatorPattern);
    }
}

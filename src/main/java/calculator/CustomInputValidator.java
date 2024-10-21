package calculator;

public class CustomInputValidator extends InputValidator {
    private final int delimiterLength;

    public CustomInputValidator(String input, String delimiter) {
        super(input, delimiter);
        this.delimiterLength = delimiter.length();
    }

    @Override
    public boolean isValidInput() {
        int i = delimiter.length() + 4;
        if (recursivelyIterateInput(input.substring(i))) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    private boolean recursivelyIterateInput(String input) {
        if (input.isEmpty()) {
            return true;
        }
        if (Character.isDigit(input.charAt(0))) {
            return recursivelyIterateInput(input.substring(1));
        }
        if (input.startsWith(this.delimiter)) {
            return recursivelyIterateInput(input.substring(this.delimiterLength));
        }
        return false;
    }
}

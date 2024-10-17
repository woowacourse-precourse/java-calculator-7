package calculator.service;

public class UserInputNumbers {

    private final String numbers;

    private UserInputNumbers(final String inputNumbers) {
        this.numbers = inputNumbers;
    }

    public static UserInputNumbers of(final String message) {
        if (message.startsWith("//")) {
            final int index = message.lastIndexOf("\\n");
            return new UserInputNumbers(message.substring(index + 2));
        }
        return new UserInputNumbers(message);
    }

    public Tokenizer getTokenizer(final SeparatorFactory separatorFactory) {
        return new Tokenizer(this.numbers, separatorFactory);
    }

    public Tokenizer getTokenizer() {
        return new Tokenizer(this.numbers);
    }

    @Override
    public String toString() {
        return numbers;
    }
}

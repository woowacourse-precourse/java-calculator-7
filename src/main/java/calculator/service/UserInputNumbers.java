package calculator.service;

public class UserInputNumbers {

    private final String numbers;

    public UserInputNumbers(final String inputNumbers) {
        this.numbers = inputNumbers;
    }

    public Tokenizer getTokenizer(final SeparatorFactory separatorFactory) {
        return new Tokenizer(this.numbers, separatorFactory);
    }

    public Tokenizer getTokenizer() {
        return new Tokenizer(this.numbers);
    }
}

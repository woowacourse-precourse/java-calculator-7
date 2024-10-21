package calculator.service;

public class UserInputNumbers {

    private final String numbers;

    private UserInputNumbers(final String inputNumbers) {
        this.numbers = inputNumbers;
    }

    String getNumbers() {
        return this.numbers;
    }

    public static UserInputNumbers of(final String message) {
        if (message.startsWith("//")) {
            final int index = message.lastIndexOf("\\n");
            return new UserInputNumbers(message.substring(index + 2));
        }
        return new UserInputNumbers(message);
    }

    @Override
    public String toString() {
        return "UserInputNumbers{" +
                "numbers='" + numbers + '\'' +
                '}';
    }
}

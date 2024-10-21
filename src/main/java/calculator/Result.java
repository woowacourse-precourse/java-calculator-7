package calculator;

public class Result {
    boolean isCorrect;
    String message;
    String input;

    public Result(boolean isCorrect, String message, String input) {
        this.isCorrect = isCorrect;
        this.message = message;
        this.input = input;
    }
}

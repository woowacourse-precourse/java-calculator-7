package calculator;

public class Application {
    private DelimiterHandler delimiterHandler;
    private InputHandler inputHandler;

    public Application() {
        this.delimiterHandler = new DelimiterHandler();
        this.inputHandler = new InputHandler();
    }

    public int calculateSum(String input) {
        String[] numberStrings = delimiterHandler.splitNumbers(input);
        int sum = 0;

        for (String numberString : numberStrings) {
            if (!numberString.isEmpty()) {
                int number = Integer.parseInt(numberString);
                if (number <= 0) {
                    throw new IllegalArgumentException("양수가 아닙니다: " + number);
                }
                sum += number;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Application app = new Application();

        try {
            String input = app.inputHandler.getInput();
            int result = app.calculateSum(input);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}

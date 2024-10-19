package calculator;

public class Calculator {

    String separator;

    public int run(String input) {
        initial();
        getSeparator(input);
        isInputValid(input);
        return calculate(input);
    }

    public void initial() {
        separator = ",:";
    }

    public void getSeparator(String input) {

    }

    public void isInputValid(String input) {

    }

    public int calculate(String input) {
        return 1;
    }
}

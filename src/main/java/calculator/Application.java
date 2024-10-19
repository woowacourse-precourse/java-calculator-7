package calculator;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Separator separator = new Separator(input.getInput());
        separator.extractSeparatorFromInput();
        if (!separator.isValidFormula()) {
            throw new IllegalArgumentException();
        }
        separator.separate();
        Output output = new Output(separator.calculateSum());
        output.printResult();
    }
}

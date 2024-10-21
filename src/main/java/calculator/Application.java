package calculator;

public class Application {
    public static void main(String[] args) {
        Output output = new Output();
        Input input = new Input();
        Separator separator = new Separator(input.getInput());
        separator.extractSeparatorFromInput();
        if (!separator.isValidFormula()) {
            throw new IllegalArgumentException();
        }
        separator.separate();
        output.printResult(separator.calculateSum());
    }
}

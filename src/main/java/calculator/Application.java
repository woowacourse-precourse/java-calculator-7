package calculator;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        String input = view.inputCalculator();

        SeparatorManager separatorManager = new SeparatorManager();
        Separator separator = separatorManager.getSeparator(input);
        Number number = separatorManager.getNumber(separator, input);

        int result = number.getSum();
        view.outputResult(result);
    }
}

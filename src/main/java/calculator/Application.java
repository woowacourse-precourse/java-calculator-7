package calculator;

public class Application {
    private static String input;

    public static void main(String[] args) {
        Printer.printInputMessage();
        Reader.readString();
        System.out.println("input: " + input);
            Printer.printResultMessage(Calculator.calculate());
    }

    public static void setInput(String newInput) { input = newInput; }

    public static String getInput() { return input; }
}

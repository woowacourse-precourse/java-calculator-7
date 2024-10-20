package calculator;

public class Application {
    private static String input;

    public static void main(String[] args) {
        Printer.printInputMessage();
        Reader.readString();
        System.out.println("input: \"" + input + "\"");
        try {
//            Printer.printResultMessage(Calculator.calculate());
            System.out.println(Calculator.calculate());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void setInput(String newInput) { input = newInput; }

    public static String getInput() { return input; }
}

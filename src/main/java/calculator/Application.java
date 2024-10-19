package calculator;

public class Application {
    public static void main(String[] args) {
        Printer.printInputMessage();
        String input = Reader.readString();
        System.out.println(input);
        try {
            Calculator.calculate(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

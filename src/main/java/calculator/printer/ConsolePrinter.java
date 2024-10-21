package calculator.printer;

public class ConsolePrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printWithFormat(String format, int result) {
        String output = String.format(format, result);
        System.out.println(output);
    }

}

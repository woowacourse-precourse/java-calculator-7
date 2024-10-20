package calculator;

public class Application {
    private static String input;

    public static void main(String[] args) {
        Printer.printInputMessage();
        Reader.readString();
        if (input.length() == 0) {
            Printer.printResultMessage(0);
        } else {
            Printer.printResultMessage(Calculator.calculate());
        }
        return ;
    }

    public static void setInput(String newInput) { input = newInput; }
    public static void setInputWithCharArray(char[] newInput) { input = new String(newInput); }

    public static String getInput() { return input; }
    public static char getCharInInput(int idx) { return input.charAt(idx); }
    public static char[] getInputToCharArray() { return input.toCharArray(); }
    public static String getSubstringOfInput(int start, int end) { return input.substring(start, end); }
    public static int getInputSize() { return input.length(); }
}

package calculator;

public class Application {
    static String inputString = "";
    static int sum=0;

    public static void main(String[] args) {
        IOHandler iohandler = new IOHandler();
        NumberParser numberparser;

        iohandler.printStartMsg();
        inputString = iohandler.getInputString();

        numberparser = new NumberParser(inputString);

        iohandler.printResultMsg(sum);
    }
}

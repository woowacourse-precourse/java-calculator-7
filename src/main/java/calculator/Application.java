package calculator;

public class Application {
    static String inputString = "";
    static int sum=0;

    public static void main(String[] args) {
        IOHandler iohandler = new IOHandler();

        iohandler.printStartMsg();
        inputString = iohandler.getInputString();

        

        iohandler.printResultMsg(sum);
    }
}

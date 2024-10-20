package calculator;

public class Application {
    static String inputString = "";

    public static void main(String[] args) {
        IOHandler iohandler = new IOHandler();
        NumberParser numberparser;
        Adder adder;

        iohandler.printStartMsg();
        inputString = iohandler.getInputString();

        numberparser = new NumberParser(inputString);
        adder=new Adder(numberparser.getExtractedNumList());

        iohandler.printResultMsg(adder.getSum());
    }
}

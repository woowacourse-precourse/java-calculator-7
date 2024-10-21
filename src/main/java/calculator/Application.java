package calculator;

public class Application {
    static String inputString = "";

    public static void main(String[] args) {
        //try {
            IOHandler iohandler = new IOHandler();
            NumberParser numberparser;
            Adder adder;

            iohandler.printStartMsg();
            inputString = iohandler.getInputString();

            numberparser = new NumberParser(inputString);
            adder = new Adder(numberparser.getExtractedNumList());

            iohandler.printResultMsg(adder.getSum());
        //}catch(IllegalArgumentException e){
            //System.err.println("잘못된 입력입니다 : " + e.getMessage());
        //}
    }
}

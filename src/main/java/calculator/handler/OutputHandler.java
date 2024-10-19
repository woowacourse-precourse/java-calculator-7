package calculator.handler;

import static calculator.constants.Constants.OUTPUT_MESSAGE;

public class OutputHandler {
    public static void printResult(Long result){
        System.out.println(OUTPUT_MESSAGE + result);
    }
}

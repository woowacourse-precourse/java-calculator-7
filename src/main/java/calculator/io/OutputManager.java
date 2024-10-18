package calculator.io;

import static calculator.util.Const.RESULT_MESSAGE_FORMAT;

public class OutputManager {

    private OutputManager() { }

    public static void printSum(int numberSum) {
        System.out.printf(RESULT_MESSAGE_FORMAT, numberSum);
    }

}

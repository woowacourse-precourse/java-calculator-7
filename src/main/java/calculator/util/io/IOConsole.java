package calculator.util.io;

import calculator.common.exception.ExceptionFactory;
import camp.nextstep.edu.missionutils.Console;

import static calculator.common.exception.ExceptionType.CAN_NOT_INSTANTIATE;

public final class IOConsole {

    private IOConsole() {
        throw ExceptionFactory.createException(CAN_NOT_INSTANTIATE);
    }

    public static String readLine() {
        return Console.readLine();
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void print(String message) {
        System.out.print(message);
    }
}

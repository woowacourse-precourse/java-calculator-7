package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static String read() {
        return readLine();
    }
}

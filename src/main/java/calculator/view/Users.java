package calculator.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Users {

    public static String input() {
        System.out.println(Message.INPUT_GUIDE);
        return readLine();
    }

    public static void resultOfMatchingOutputFormat(Long result) {
        System.out.println(matchingOutputFormat(result));
    }

    private static String matchingOutputFormat(Long result) {
        return String.format("%s%d", Message.RESULT_FORMAT, result);
    }
}

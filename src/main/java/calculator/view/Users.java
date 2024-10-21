package calculator.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Users {

    public static String input() {
        System.out.println(Message.INPUT_GUIDE);
        return readLine();
    }

}

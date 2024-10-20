package calculator.view;

import calculator.constants.ViewConst;

public class View {
    public static String getInput() {
        System.out.println(ViewConst.START_INPUT);
        return camp.nextstep.edu.missionutils.Console.readLine();
    }


    public static void showResult(int sum) {
        System.out.println(ViewConst.SHOW_RESULT + sum);
    }
}

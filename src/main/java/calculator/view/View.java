package calculator.view;

import calculator.constants.ViewConst;

public class View {
    public static String getInput() {
        System.out.println(ViewConst.START_INPUT);
        return camp.nextstep.edu.missionutils.Console.readLine();
    }


    public static void showResult(long sum) {
        System.out.println(ViewConst.SHOW_RESULT + sum);
    }

    public static boolean showIfInputIsEmptyResult(String input) {

        if (input == null || input.isBlank()) {
            showResult(0);
            return true;
        }
        return false;
    }


}

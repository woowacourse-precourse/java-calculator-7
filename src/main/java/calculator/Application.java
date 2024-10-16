package calculator;
import camp.nextstep.edu.missionutils.Console;
import calculator.Checkdelemeter;
import calculator.InputView;
public class Application {

    public static void main(String[] args) {
        InputView input_view = new InputView();
        Checkdelemeter check_delemeter = new Checkdelemeter();
        String input = input_view.getInput();
        char[] delemeter = new char[3];
        delemeter = check_delemeter.AddDelemeter(input);

    }

}

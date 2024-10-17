package calculator.ui;

import calculator.util.Util;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private final Util util;

    public InputView(Util util) {
        this.util = util;
    }

    public void readText(){
        String text = readLine();
        util.extract(text);
    }
}

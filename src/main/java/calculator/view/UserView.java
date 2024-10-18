package calculator.view;

import calculator.controller.Device;
import camp.nextstep.edu.missionutils.Console;

public class UserView {
    private static final String inputMessage = "덧셈할 문자열을 입력해 주세요.";
    private static final String outputMessage = "결과 : ";

    private final Device device;

    public UserView(Device device) {
        this.device = device;
    }

    public void run() {
        System.out.println(inputMessage);
        String inputString = Console.readLine();
        Integer answer = device.run(inputString);
        System.out.println(outputMessage + answer);
    }
}

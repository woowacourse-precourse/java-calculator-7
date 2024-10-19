package calculator.view;

import calculator.constant.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public String inputEquation() {
		System.out.println(SystemMessage.INPUT_EQUATION);
		return Console.readLine();
	}
}

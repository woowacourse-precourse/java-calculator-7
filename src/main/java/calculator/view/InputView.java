package calculator.view;

import calculator.model.InputModel;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public String getInput() {
		String input = Console.readLine();
		InputModel inputModel = new InputModel(input);
		return inputModel.getInput();
	}
}

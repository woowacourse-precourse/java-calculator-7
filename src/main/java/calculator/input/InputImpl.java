package calculator.input;

import camp.nextstep.edu.missionutils.Console;

public class InputImpl implements Input {
	@Override
	public void input() {
		String str = Console.readLine();
	}
}

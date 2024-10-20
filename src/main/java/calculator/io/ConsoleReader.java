package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader implements Reader {

	public ConsoleReader() {}

	@Override
	public String read() {
		return Console.readLine();
	}
}

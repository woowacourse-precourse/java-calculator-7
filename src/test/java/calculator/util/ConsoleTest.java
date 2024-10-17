package calculator.util;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;

import java.io.InputStream;
import java.io.PrintStream;

public abstract class ConsoleTest {
	
	private static final InputStream originalIn = System.in;
	private static final PrintStream originalOut = System.out;
	
	@AfterEach
	void tearDown() {
		resetInput();
		resetOutput();
	}
	
	private static void resetInput() {
		Console.close();
		System.setIn(originalIn);
	}
	
	private static void resetOutput() {
		System.setOut(originalOut);
	}
	
}

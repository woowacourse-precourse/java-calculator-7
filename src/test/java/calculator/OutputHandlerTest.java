package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class OutputHandlerTest {

	OutputHandler outputHandler = new OutputHandler();

	@Test
	void 올바른_출력일경우() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		outputHandler.printResult(10);
		assertEquals("결과 : 10\n", outputStream.toString());
	}
}
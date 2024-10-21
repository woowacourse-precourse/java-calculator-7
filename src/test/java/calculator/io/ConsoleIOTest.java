package calculator.io;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class ConsoleIOTest {
	private ConsoleIO console;

	@Test
	void 문자열_입력_성공() {
		console = new ConsoleIO(() -> "//;\n1;2", new Writer());

		assertThatNoException().isThrownBy(() -> console.readExpression());
	}

	@ParameterizedTest
	@NullAndEmptySource
	void 문자열_입력_실패_공백_or_null입력(String input) {
		console = new ConsoleIO(() -> input, new Writer());

		assertThatIllegalArgumentException()
				.isThrownBy(() -> console.readExpression());
	}
}

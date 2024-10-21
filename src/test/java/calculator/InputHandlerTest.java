package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InputHandlerTest {

	private final InputHandler inputHandler = new InputHandler();

	@Test
	void 문자열_비어있는경우_예외발생() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			inputHandler.validateIsInputEmpty("");
		});

		assertEquals("올바르지 않은 입력값 입니다.", exception.getMessage());
	}

	@Test
	void 문자열_null일경우_예외발생() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			inputHandler.validateIsInputEmpty(null);
		});

		assertEquals("올바르지 않은 입력값 입니다.", exception.getMessage());
	}

	@Test
	void 올바른_입력일경우_예외발생_X() {
		assertDoesNotThrow(() -> inputHandler.validateIsInputEmpty("1,2"));
	}
}
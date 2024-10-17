package calculator.io;

import calculator.util.ConsoleTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static calculator.util.ConsoleTestUtil.*;

class InputOutputHandlerTest extends ConsoleTest {

	@Test
	void 커스텀구분자가_없는_입력을_읽어서_반환한다() {
		//given
		setInput("1:2:3");
		InputOutputHandler sut = new InputOutputHandler(new InputValidator(), new InputParser());

		//when
		InputParseResult result = sut.handleInput();

		//then
		Assertions.assertThat(result.customSeparatorPart()).isEqualTo("");
		Assertions.assertThat(result.numberPart()).isEqualTo("1:2:3");
	}

	@Test
	void 커스텀구분자가_있는_입력을_읽어서_반환한다() {
		//given
		setInput("//^\\n1:2:3");
		InputOutputHandler sut = new InputOutputHandler(new InputValidator(), new InputParser());
		
		//when
		InputParseResult result = sut.handleInput();

		//then
		Assertions.assertThat(result.customSeparatorPart()).isEqualTo("^");
		Assertions.assertThat(result.numberPart()).isEqualTo("1:2:3");
	}

	@Test
	void 숫자부가_숫자로_끝나지_않으면_예외를_발생시킨다() {
		//given
		setInput("//^\\n1:2:");
		InputOutputHandler sut = new InputOutputHandler(new InputValidator(), new InputParser());
		
		//expected
		Assertions.assertThatThrownBy(sut::handleInput)
				.isExactlyInstanceOf(IllegalArgumentException.class)
				.hasMessage("유효하지 않은 입력입니다.");
	}

	@Test
	void 숫자부가_숫자로_시작하지_않으면_예외를_발생시킨다() {
		//given
		setInput("//^\\n:2:3");
		InputOutputHandler sut = new InputOutputHandler(new InputValidator(), new InputParser());

		//expected
		Assertions.assertThatThrownBy(sut::handleInput)
				.isExactlyInstanceOf(IllegalArgumentException.class)
				.hasMessage("유효하지 않은 입력입니다.");
	}

	@Test
	void 숫자부의_구분자가_연속해서_나오면_예외를_발생시킨다() {
		//given
		setInput("//^\\n1:2::3");
		InputOutputHandler sut = new InputOutputHandler(new InputValidator(), new InputParser());

		//expected
		Assertions.assertThatThrownBy(sut::handleInput)
				.isExactlyInstanceOf(IllegalArgumentException.class)
				.hasMessage("유효하지 않은 입력입니다.");
	}

	@Test
	void 커스텀구분자의_주석표시가_온전하지_않으면_예외를_발생시킨다() {
		//given
		setInput("/^\n1:2::3");
		InputOutputHandler sut = new InputOutputHandler(new InputValidator(), new InputParser());

		//expected
		Assertions.assertThatThrownBy(sut::handleInput)
				.isExactlyInstanceOf(IllegalArgumentException.class)
				.hasMessage("유효하지 않은 입력입니다.");
	}

	@Test
	void handleOutput메서드_호출시_정상적으로_출력된다() {
		//given
		captureOutput();
		InputOutputHandler sut = new InputOutputHandler(new InputValidator(), new InputParser());

		//when
		sut.handleOutput(10);

		//then
		Assertions.assertThat(getOutput()).isEqualTo("\n결과 : 10");
	}

}
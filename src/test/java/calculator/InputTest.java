package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

public class InputTest extends NsTest {

	@Test
	void 두_개의_기본_구분자를_사용할_수_있다() {
		assertSimpleTest(() -> {
			List<Integer> output = Input.extractNumbers("1,2:3");
			assertThat(output).hasSize(3);
		});
	}

	@Test
	void 커스텀_구분자의_접미사가_잘못된_경우_예외가_발생한다() {
		assertSimpleTest(() ->
			assertThatThrownBy(() ->  Input.extractNumbers("//;1;2;3"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 커스텀_구분자의_접두사가_잘못된_경우_예외가_발생한다() {
		assertSimpleTest(() ->
			assertThatThrownBy(() ->  Input.extractNumbers("/;\n1;2;3"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 커스텀_구분자가_숫자인_경우_예외가_발생한다() {
		assertSimpleTest(() ->
			assertThatThrownBy(() ->  Input.extractNumbers("//1\n1;2;3"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 커스텀_구분자가_빈_문자일_경우_예외가_발생한다() {
		assertSimpleTest(() ->
			assertThatThrownBy(() ->  Input.extractNumbers("//\n1;2;3"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 구분자를_제외하고_문자열이_있는_경우_예외가_발생한다() {
		assertSimpleTest(() ->
			assertThatThrownBy(() ->  Input.extractNumbers("//;\n1;2;3,a,b"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[]{});
	}
}

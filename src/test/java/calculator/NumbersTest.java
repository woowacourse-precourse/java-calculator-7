package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import calculator.domain.Numbers;
import camp.nextstep.edu.missionutils.test.NsTest;

public class NumbersTest extends NsTest {
	@Test
	void 숫자목록의_요소들을_더할_수_있다() {
		assertSimpleTest(() -> {
			Numbers numbers = new Numbers(List.of(4, 5, 6, 7, 8));
			assertThat(numbers.sumNumbers()).isEqualTo(30);
		});
	}

	@Test
	void 숫자목록에_음수가_있는_경우_예외가_발생한다() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> {
				new Numbers(List.of(-1, 1, 2, 3));
			})
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	protected void runMain() {

	}
}

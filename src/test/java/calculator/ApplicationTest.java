package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {
	@Test
	void 커스텀_구분자_사용() {
		assertSimpleTest(() -> {
			run("//;\\n1");
			assertThat(output()).contains("결과 : 1");
		});
	}

	@Test
	void 예외_테스트() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("-1,2,3"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 기본_구분자_사용() {
		assertSimpleTest(() -> {
			run("1:2:3");
			assertThat(output()).contains("결과 : 6");
		});
	}

	@Test
	void 잘못된_입력_테스트() {
		assertSimpleTest(() -> {
			assertThatThrownBy(() -> runException("1:a:3"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("입력을 숫자로 변환할 수 없거나, 변환된 값이 long 범위를 초과합니다.");
		});
	}

	@Test
	void long_범위_초과_테스트() {
		assertSimpleTest(() -> {
			assertThatThrownBy(() -> runException("9223372036854775808,1")) // Long.MAX_VALUE + 1
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("입력을 숫자로 변환할 수 없거나, 변환된 값이 long 범위를 초과합니다.");
		});
	}

	@Test
	void 음수_입력_테스트() {
		assertSimpleTest(() -> {
			assertThatThrownBy(() -> runException("-1,2,3"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("입력은 음수일 수 없습니다.");
		});
	}

	@Test
	void 여러_커스텀_구분자_사용() {
		assertSimpleTest(() -> {
			run("//|\\n1;2|3//;\\n");
			assertThat(output()).contains("결과 : 6");
		});
	}

	@Test
	void 공백_제거_후_결과() {
		assertSimpleTest(() -> {
			run("   1: 2: 3   ");
			assertThat(output()).contains("결과 : 6");
		});
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}

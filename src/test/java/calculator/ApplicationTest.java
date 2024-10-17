package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
	@Test
	void 커스텀_구분자_사용() {
		assertSimpleTest(() -> {
			run("//;\\n1");
			assertThat(output()).contains("결과 : 1");
		});
	}

	@Test
	public void longNumberTest() {
		// given
		long num1 = 100_000_000_000L;
		long num2 = 200_000_000_000L;
		long num3 = 200_000_000_000L;

		// when
		assertSimpleTest(() -> {
			run(num1 + ":" + num2 + ":" + num3);

			// then
			assertThat(output()).contains("결과 : " + (num1 + num2 + num3));
		});
	}

	@Test
	public void severalCustomSeparatorTest() {
		// given
		String input = "//;\\n//-\\n1;2-3";

		// when
		assertSimpleTest(() -> {
			run(input);

			// then
			assertThat(output()).contains("결과 : " + 6);
		});
	}

	@Test
	public void blankTest(){
		// given
		String input = "\n";

		// when
		assertSimpleTest(() -> {
			run(input);

			// then
			assertThat(output()).contains("결과 : " + 0);
		});
	}

	@Test
	public void hasNotSeparatorTest(){
		 // given
		String input = "1";

		// when
		assertSimpleTest(() -> {
			run(input);

			//then
			assertThat(output()).contains("결과 : " + 1);
		});
	}

	@Test
	public void hasNotSeparatorAndHasCustomCeparatorTest(){
		// given
		String input = "//;\\n1";

		// when
		assertSimpleTest(() -> {
			run(input);

			//then
			assertThat(output()).contains("결과 : " + 1);
		});
	}

	@Test
	void 예외_테스트() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("-1,2,3"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}

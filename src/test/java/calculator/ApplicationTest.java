package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
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
	@DisplayName("int를 벗어나는 큰 숫자 입력 테스트")
	public void longNumberTest() {
		assertSimpleTest(() -> {
			// given
			long num1 = 100_000_000_000L;
			long num2 = 200_000_000_000L;
			long num3 = 200_000_000_000L;

			// when
			run(num1 + ":" + num2 + ":" + num3);

			// then
			assertThat(output()).contains("결과 : " + (num1 + num2 + num3));
		});
	}

	@Test
	@DisplayName("여러개의 커스텀 구분자 입력 테스트")
	public void severalCustomSeparatorTest() {
		assertSimpleTest(() -> {
			// given
			String input = "//;\\n//-\\n1;2-3";

			// when
			run(input);

			// then
			assertThat(output()).contains("결과 : " + 6);
		});
	}

	@Test
	@DisplayName("공백 입력 테스트")
	public void blankTest(){
		assertSimpleTest(() -> {
			// given
			String input = "\n";

			// when
			run(input);

			// then
			assertThat(output()).contains("결과 : " + 0);
		});
	}

	@Test
	@DisplayName("구분자 없는 숫자 입력 테스트")
	public void hasNotSeparatorTest(){
		assertSimpleTest(() -> {
			// given
			String input = "1";

			// when
			run(input);

			//then
			assertThat(output()).contains("결과 : " + 1);
		});
	}

	@Test
	@DisplayName("구분자가 없으면서 커스텀 구분자가 있는 입력 테스트")
	public void hasNotSeparatorAndHasCustomCeparatorTest(){
		assertSimpleTest(() -> {
			// given
			String input = "//;\\n1";

			// when
			run(input);

			//then
			assertThat(output()).contains("결과 : 1");
		});
	}

	@Test
	@DisplayName("커스텀 문자열에 특수 문자가 포함되는 입력 테스트")
	public void hasSpecialCharTest(){
		assertSimpleTest(()->{
			// given
			String input = "//\\\\n1\\2\\3";

			//when
			run(input);

			// then
			assertThat(output()).contains("결과 : 6");

		});
	}

	@Test
	@DisplayName("커스텀 문자열에 특수 문자 '[', ']'가 포함되며 수식에도 포함되는 입력 테스트")
	public void hasSpecialCharsTest(){
		assertSimpleTest(()->{
			// given
			String input = "//[\\n//]\\n1[2]3";

			//when
			run(input);

			// then
			assertThat(output()).contains("결과 : 6");

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

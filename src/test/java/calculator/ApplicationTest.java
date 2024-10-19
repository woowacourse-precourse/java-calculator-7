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
	void 예외_테스트() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("-1,2,3"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}


	@Test
	void 예외_테스트_공백() {
		assertSimpleTest(() -> {
			run(" ");
			assertThat(output()).contains("결과 : 0");
		});
	}

	@Test
	void 예외_테스트_NULL() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException((String) null))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 예외_테스트_문자테스트() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("a2b3c1 "))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 예외_테스트_문자와구분자() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("a:b:c"))
						.isInstanceOf(IllegalArgumentException.class));
	}

	@Test
	void 예외_테스트_다양한구분자(){
		assertSimpleTest(() ->{
			run("// \\n3:1,2 5");
			assertThat(output()).contains("결과 : 11");
		});
	}

	@Test
	void 예외_테스트_숫자와공백(){
		assertSimpleTest(() ->{
			run(":1,2");
			assertThat(output()).contains("결과 : 3");
		});
	}


	@Override
	public void runMain() {
		Application.main(new String[]{});
	}
}

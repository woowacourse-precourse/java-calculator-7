package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
	@Test
	void 커스텀구분자_사용_1() {
		assertSimpleTest(() -> {
			run("//;\\n1");
			assertThat(output()).contains("결과 : 1");
		});
	}

	@Test
	void 커스텀구분자_사용_2() {
		assertSimpleTest(() -> {
			run("//,;\\n1,;2;3,1");
			assertThat(output()).contains("결과 : 7");
		});
	}

	@Test
	void 기본_구분자_사용_1() {
		assertSimpleTest(() -> {
			run("1,2,3:4:2,1");
			assertThat(output()).contains("결과 : 13");
		});
	}

	@Test
	void 기본_구분자_사용_2() {
		assertSimpleTest(() -> {
			run("1,22,33,44");
			assertThat(output()).contains("결과 : 100");
		});
	}

	@Test
	void 빈_입력() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException())
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 연속된_구분자() {
		assertSimpleTest(() -> {
			run("1,,,,,2");
			assertThat(output()).contains("결과 : 3");
		});
	}

	@Test
	void 음수 () {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("-1,2,3"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 커스텀_구분자_포맷_1() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("////\n1/2/3/44/4//5"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 커스텀_구분자_포맷_2() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("//\\n\\\\n1\\n3\\n\\\\n4"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 빈_숫자_입력() {
		assertSimpleTest(() -> {
			run("//;\\n");
			assertThat(output()).contains("결과 : 0");
		});
	}

	@Test
	void 숫자_커스텀_구분자() {
		assertSimpleTest(() -> {
			run("//1\\n213141516");
			assertThat(output()).contains("결과 : 20");
		});
	}

	@Test
	void 커스텀_기본구분자() {
		assertSimpleTest(() -> {
			run("//,:\\\\n1,:2,3:,4");
			assertThat(output()).contains("결과 : 10");
		});
	}

	@Test
	void 복수_커스텀구분자() {
		assertSimpleTest(() -> {
			run("//123;,'\\\\n51614;5,7'8263");
			assertThat(output()).contains("결과 : 41");
		});
	}

	@Test
	void 이스케이프시퀀스_커스텀구분자() {
		assertSimpleTest(() -> {
			run("//\\t\\n1\\t2\\t3\\t4");
			assertThat(output()).contains("결과 : 10");
		});
	}

	@Test
	void 커스텀구분자만_있는() {
		assertSimpleTest(() -> {
			run("//;\\n;;;;;;;;;;;;;;;;;;;;;;");
			assertThat(output()).contains("결과 : 0");
		});
	}

	@Test
	void 진수가_다른() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("1,1bb"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 오버플로우_확인_1() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("1, 2147483647"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 오버플로우_확인_2() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("2147483648"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[]{});
	}
}

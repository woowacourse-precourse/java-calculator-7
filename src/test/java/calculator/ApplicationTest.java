package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {
	// 기본 테스트 케이스
	@Test
	void 커스텀_구분자_사용() {
		assertSimpleTest(() -> {
			run("//;\\n1;1");
			assertThat(output()).contains("결과 : 2");
		});
	}

	@Test
	void 예외_테스트() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("-1,2,3"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	// 커스텀 테스트 케이스
	@Test
	void 문자열_덧셈() {
		assertSimpleTest(() -> {
			run(",12:3");
			assertThat(output()).contains("결과 : 15");
		});
	}

	@Test
	void 잘못된_구분자_입력() { // 잘못된 구분자 형식 처리 시
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("12s3"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 커스텀_구분자_등록_형식() { // 커스텀 구분자가 '//'으로 시작되지 않을 시
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("asd\\n12:12"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 복수의_커스텀_구분자() { // 커스텀 구분자를 둘 이상의 연속된 문자로 지정할 시
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("//ss\\n1s2,3"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 커스텀_구분자가_숫자() { // 커스텀 구분자에 숫자가 포함될 시
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("//1\\n212"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}

package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@DisplayName("여러 숫자 리스트를 받아 덧셈 결과를 반환한다.")
	@Test
	void sumNumbers() {
		//given
		Calculator calculator = Calculator.create();
		List<Integer> testInput = List.of(1, 2, 3);
		int expectedNumber = 6;

		//when
		int result = calculator.sumNumbers(testInput);

		//then
		assertThat(result).isEqualTo(expectedNumber);
	}

	@DisplayName("단일 숫자 리스트를 받아 덧셈 결과를 반환한다.")
	@Test
	void sumNumbers_singleElement() {
		//given
		Calculator calculator = Calculator.create();
		List<Integer> testInput = List.of(1);
		int expectedNumber = 1;

		//when
		int result = calculator.sumNumbers(testInput);

		//then
		assertThat(result).isEqualTo(expectedNumber);
	}

	@DisplayName("0이 하나인 숫자 리스트를 받아 덧셈 결과를 반환한다.")
	@Test
	void sumNumbers_singleZero() {
		//given
		Calculator calculator = Calculator.create();
		List<Integer> testInput = List.of(0);
		int expectedNumber = 0;

		//when
		int result = calculator.sumNumbers(testInput);

		//then
		assertThat(result).isEqualTo(expectedNumber);
	}

	@DisplayName("빈 리스트일시 0을 반환한다.")
	@Test
	void sumNumbers_emptyList() {
		//given
		Calculator calculator = Calculator.create();
		List<Integer> testInput = List.of();
		int expectedNumber = 0;

		//when
		int result = calculator.sumNumbers(testInput);

		//then
		assertThat(result).isEqualTo(expectedNumber);
	}

	@DisplayName("음수가 포함된 숫자 리스트에 대해 IllegalArgumentException을 발생시킨다.")
	@Test
	void sumNumbers_throwsExceptionForNegativeNumbers() {
		//given
		Calculator calculator = Calculator.create();
		List<Integer> testInput = List.of(-1, -2, 3);

		//when & then
		assertThatThrownBy(() -> calculator.sumNumbers(testInput))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("합계가 int의 최댓값을 초과하면 IllegalArgumentException을 발생시킨다.")
	@Test
	void sumNumbers_throwsExceptionForOverflow() {
		//given
		Calculator calculator = Calculator.create();
		List<Integer> testInput = List.of(Integer.MAX_VALUE, 1);

		//when & then
		assertThatThrownBy(() -> calculator.sumNumbers(testInput))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
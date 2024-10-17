package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CalculatorTest {
	
	@Test
	void 주어진_숫자리스트를_더한다() {
		//given
		Calculator sut = new Calculator();
		
		//when
		int result = sut.add(List.of(1, 2, 3));
		
		//then
		Assertions.assertThat(result).isEqualTo(6);
	}
	
	@Test
	void 빈_숫자리스트가_전달되면_0을_반환한다() {
		//given
		Calculator sut = new Calculator();
		
		//when
		int result = sut.add(List.of());
		
		//then
		Assertions.assertThat(result).isEqualTo(0);
	}
}
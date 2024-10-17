package calculator.numberExtractor;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class NumberExtractorTest {

	@Test
	void 문자열에서_숫자를_추출한다() {
		//given
		NumberExtractorImpl sut = new NumberExtractorImpl();
		
		//when
		List<Integer> result = sut.extract("1:2:3", List.of(':', ','));
		
		//then
		Assertions.assertThat(result).containsExactly(1, 2, 3);
	}
	
	@Test
	void 문자열에서_두자리_이상의_숫자를_추출한다() {
		//given
		NumberExtractorImpl sut = new NumberExtractorImpl();
		
		//when
		List<Integer> result = sut.extract("1:12:123:1234", List.of(':', ','));
		
		//then
		Assertions.assertThat(result).containsExactly(1, 12, 123, 1234);
	}
	
	@Test
	void 구분자로_지정되지_않은_기호가_있으면_예외가_발생한다() {
		//given
		NumberExtractorImpl sut = new NumberExtractorImpl();
		
		//expected
		Assertions.assertThatThrownBy(() ->
						sut.extract("1:2^3", List.of(':', ',')))
				.isExactlyInstanceOf(IllegalArgumentException.class)
				.hasMessage("입력된 문자열에 구분자와 숫자가 아닌 문자가 포함되어 있습니다.");
	}
	
	@Test
	void 숫자도_구분자로_활용될_수_있다() {
		//given
		NumberExtractorImpl sut = new NumberExtractorImpl();
		
		//when
		List<Integer> result = sut.extract("10203", List.of('0'));
		
		//then
		Assertions.assertThat(result).containsExactly(1, 2, 3);
	}
}
package calculator.customSeparatorExtractor;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CustomSeparatorExtractorTest {
	
	@Test
	void 추출할_커스텀구분자가_없다면_빈_리스트를_반환한다() {
		//given
		CustomSeparatorExtractorImpl sut = new CustomSeparatorExtractorImpl();
		
		//when
		List<Character> result = sut.extract("");
		
		//then
		Assertions.assertThat(result).isEmpty();
	}
	
	@Test
	void 추출할_커스텀구분자가_있다면_추출한다() {
		//given
		CustomSeparatorExtractorImpl sut = new CustomSeparatorExtractorImpl();
		
		//when
		List<Character> result = sut.extract(";");
		
		//then
		Assertions.assertThat(result).containsExactly(';');
	}
	
	@Test
	void 추출할_커스텀구분자가_여러개_있다면_모두_추출한다() {
		//given
		CustomSeparatorExtractorImpl sut = new CustomSeparatorExtractorImpl();
		
		//when
		List<Character> result = sut.extract(";^&");
		
		//then
		Assertions.assertThat(result).containsExactly(';', '^', '&');
	}
}
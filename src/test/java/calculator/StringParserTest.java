package calculator;

import calculator.customSeparatorExtractor.CustomSeparatorExtractorImpl;
import calculator.numberExtractor.NumberExtractorImpl;
import calculator.testdouble.CustomSeparatorExtractorStub;
import calculator.testdouble.NumberExtractorStub;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class StringParserTest {
	
	@Test
	void StringParser클래스를_생성하면_기본구분자가_저장된다() {
		//when
		CustomSeparatorExtractorStub separatorExtractor = new CustomSeparatorExtractorStub();
		NumberExtractorStub numberExtractor = new NumberExtractorStub();
		
		StringParser sut = new StringParser(separatorExtractor, numberExtractor);
		
		//then
		List<Character> separators = sut.getSeparators();
		Assertions.assertThat(separators).containsExactly(',', ':');
	}
	
	@Test
	void parse메서드를_호출하면_커스텀구분자가_저장된다() {
		//given
		CustomSeparatorExtractorImpl separatorExtractor = new CustomSeparatorExtractorImpl();
		NumberExtractorStub numberExtractor = new NumberExtractorStub();
		
		StringParser sut = new StringParser(separatorExtractor, numberExtractor);
		
		//when
		sut.parse("(", "1:2:3");
		
		//then
		List<Character> separators = sut.getSeparators();
		Assertions.assertThat(separators).containsExactly(',', ':', '(');
	}
	
	@Test
	void 커스텀구분자가_없는_문자열로_parse메서드를_호출하면_기본구분자만_저장된다() {
		//given
		CustomSeparatorExtractorImpl separatorExtractor = new CustomSeparatorExtractorImpl();
		NumberExtractorStub numberExtractor = new NumberExtractorStub();
		
		StringParser sut = new StringParser(separatorExtractor, numberExtractor);
		
		//when
		sut.parse("", "1:2:3");
		
		//then
		List<Character> separators = sut.getSeparators();
		Assertions.assertThat(separators).containsExactly(',', ':');
	}
	
	@Test
	void 커스텀구분자를_지정하지_않고_parse한다() {
		//given
		CustomSeparatorExtractorImpl separatorExtractor = new CustomSeparatorExtractorImpl();
		NumberExtractorImpl numberExtractor = new NumberExtractorImpl();
		
		StringParser sut = new StringParser(separatorExtractor, numberExtractor);
		
		//when
		List<Integer> result = sut.parse("", "1:2:3,4");
		
		//then
		Assertions.assertThat(result).containsExactly(1, 2, 3, 4);
	}
	
	@Test
	void 커스텀구분자를_지정하고_parse한다() {
		//given
		CustomSeparatorExtractorImpl separatorExtractor = new CustomSeparatorExtractorImpl();
		NumberExtractorImpl numberExtractor = new NumberExtractorImpl();
		
		StringParser sut = new StringParser(separatorExtractor, numberExtractor);
		
		//when
		List<Integer> result = sut.parse(";", "1:2;3,4");
		
		//then
		Assertions.assertThat(result).containsExactly(1, 2, 3, 4);
	}
}
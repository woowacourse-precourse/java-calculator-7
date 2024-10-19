package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ParserTest {
	@Test
	public void 커스텀_구분자_존재_O() {
		//given
		Parser parser = new Parser();

		//when
		boolean trueResult = parser.isPersonalSeparatorExist("//;\\n1");

		//then
		assertThat(trueResult).isEqualTo(true);
	}

	@Test
	public void 커스텀_구분자_존재_X() {
		//given
		Parser parser = new Parser();

		//when
		boolean falseResult = parser.isPersonalSeparatorExist("1");

		//then
		assertThat(falseResult).isEqualTo(false);
	}

	@Test
	public void 커스텀_구분자_위치_에러() {
		//given
		Parser parser = new Parser();

		//when, then
		assertThatThrownBy(() -> parser.isPersonalSeparatorExist("1//:\n2,3"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 커스텀_구분자_2개_이상_에러() {
		//given
		Parser parser = new Parser();

		//when, then
		assertThatThrownBy(() -> parser.isPersonalSeparatorExist("1//:.\n"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 커스텀_구분자가_숫자면_에러() {
		//given
		Parser parser = new Parser();

		//when, then
		assertThatThrownBy(() -> parser.isPersonalSeparatorExist("1//6\n2,3"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 커스텀_구분자_저장() {
		//given
		Parser parser = new Parser();

		//when
		parser.savePersonalSeparator(";");

		//then
		assertThat(parser.getSeparators().size()).isEqualTo(3);
		assertThat(parser.getSeparators().contains(";")).isEqualTo(true);

	}

	@Test
	public void 구분자_기준_문자열_파싱() {
		//given
		Parser parser = new Parser();
		String[] expected = new String[]{"1", "2", "3"};

		//when
		String[] result = parser.parseBySeparator("1,2,3");

		//then
		assertThat(result).isEqualTo(expected);
	}

	@Test
	public void 문자열_숫자_변환() {
		//given
		Parser parser = new Parser();
		String[] splitStr = new String[]{"1", "2", "3"};
		List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3));

		//when
		List<Integer> result = parser.stringToNums(splitStr);

		//then
		assertThat(result).isEqualTo(expected);
	}
}
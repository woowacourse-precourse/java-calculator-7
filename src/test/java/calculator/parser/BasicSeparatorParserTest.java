package calculator.parser;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;

public class BasicSeparatorParserTest extends NsTest {

	private Set<String> separators;
	private List<String> defaultSeparators;
	private BasicSeparatorParser basicSeparatorParser;

	public BasicSeparatorParserTest() {
		defaultSeparators = Arrays.asList(new String[] {",", ":"});
		basicSeparatorParser = new BasicSeparatorParser();
	}

	@BeforeEach
	public void initSeparators() {
		separators = new HashSet<>(defaultSeparators);
	}

	@Test
	@DisplayName("중복된 커스텀 구분자가 입력되는 테스트")
	public void hasDuplicationCustomSeparatorTest() {
		String input = "//;\\n//;\\n1,2,3";
		assertSimpleTest(() -> {
			assertThatThrownBy(() -> basicSeparatorParser.parse(input, separators))
				.isInstanceOf(IllegalArgumentException.class);
		});
	}

	@Test
	@DisplayName("'//' 문자와 커스텀 구분자가 없는 값이 입력되는 테스트")
	public void hasNotSlashAndCustomSeparatorTest() {
		String input = "\\n1,2,3";
		assertSimpleTest(() ->
			assertThatThrownBy(() -> basicSeparatorParser.parse(input, separators))
				.isInstanceOf(IllegalArgumentException.class));
	}

	@Test
	@DisplayName("커스텀 구분자 형식의 가장 앞의 '//'가 존재하지 않는 입력이 들어오는 테스트")
	public void hasNotDoubleSlashIntoCustomSeparatorTest() {
		String input = ";\\n1,2,3";
		assertSimpleTest(() ->
			assertThatThrownBy(() -> basicSeparatorParser.parse(input, separators))
				.isInstanceOf(IllegalArgumentException.class));
	}

	@Test
	@DisplayName("커스텀 구분자 형식의 가장 앞의 '/'가 존재하지 않는 입력이 들어오는 테스트")
	public void hasNotFirstSlashIntoCustomSeparatorTest() {
		String input = "/;\\n1,2,3";
		assertSimpleTest(() ->
			assertThatThrownBy(() -> basicSeparatorParser.parse(input, separators))
				.isInstanceOf(IllegalArgumentException.class));
	}

	@Test
	@DisplayName("입력값의 가장 앞에 '\\n\\n'이 있는 입력이 들어오는 테스트")
	public void hasFirstDoubleLineBreakerTest() {
		String input = "\\n\\n1,2,3";

		assertSimpleTest(() ->
			assertThatThrownBy(() -> basicSeparatorParser.parse(input, separators))
				.isInstanceOf(IllegalArgumentException.class));
	}

	@Test
	@DisplayName("커스텀 구분자로 '/', '//'가 입력되는 테스트")
	public void hasSlashCustomSeparatorTest() {
		String input = "///\\n////\\n1/2//3/4";
		String result = basicSeparatorParser.parse(input, separators);

		assertSimpleTest(() -> {
				assertThat(result).isEqualTo("1/2//3/4");
				assertThat(separators)
					.contains("/")
					.contains("//");
			}
		);
	}

	@Test
	@DisplayName("올바른 정규식 테스트")
	public void generateRegexTest() {
		String result = basicSeparatorParser.generateRegex(separators);
		String separator1 = defaultSeparators.get(0);
		String separator2 = defaultSeparators.get(1);
		assertSimpleTest(() ->
			assertThat(result)
				.contains(separator1)
				.contains(separator2));
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}

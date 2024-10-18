package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1:2,3 | 결과 : 6",
            "::: | 결과 : 0",
            "1   : 2 ,   3 | 결과 : 6",
            "'\n'| 결과 : 0",
            ",,: | 결과 : 0",
            "100,100: | 결과 : 200",
            "1,3,2 | 결과 : 6"},
            delimiter = '|'
    )
    @DisplayName("기본 구분자 사용 성공")
    void normalDelimiterCase(String input, String expected) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(expected);
        });
    }
    @ParameterizedTest
    @CsvSource(value = {
            "//a\\n10a3a2 | 결과 : 15",
            "//abc\\n1abc3 | 결과 : 4",
            "//a\\n1a2a3 | 결과 : 6",
            "// \\n1 2 3 | 결과 : 6",
            "//a\\na10a20a30a | 결과 : 60",
            "// \\n  1  3 2 | 결과 : 6",
            "//ab\\nab100ab10ab1ab | 결과 : 111",
            "//a-\\na-100a- | 결과 : 100"},
            delimiter = '|'
    )
    @DisplayName("커스텀 구분자 사용 성공")
    void customDelimiterCase(String input, String expected) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(expected);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

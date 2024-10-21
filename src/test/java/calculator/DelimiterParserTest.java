package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DelimiterParserTest {

    @Test
    void parse_커스텀_구분자를_정상적으로_추출() {
        // 준비
        DelimiterParser delimiterParser = new DelimiterParser();
        String input = "//;\\n1;2;3";

        // 실행
        int parseIndex = delimiterParser.parse(input);

        // 검증
        assertThat(delimiterParser.getDelimiters()).contains(";");  // 커스텀 구분자가 세미콜론인지 확인
        assertThat(parseIndex).isEqualTo(5);  // 구분자 파싱 이후 시작 인덱스가 4인지 확인
    }

    @Test
    void parse_잘못된_구분자일_경우_예외_발생() {
        // 준비
        DelimiterParser delimiterParser = new DelimiterParser();
        String input = "//\\n1,2";

        // 실행 및 검증
        assertThatThrownBy(() -> delimiterParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자가 비어 있습니다.");
    }

}

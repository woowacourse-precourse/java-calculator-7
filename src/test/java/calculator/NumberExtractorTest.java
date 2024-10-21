package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.ArrayList;

class NumberExtractorTest {

    @Test
    void extractNumbers_숫자를_정상적으로_추출() {
        // 준비
        DelimiterParser delimiterParser = new DelimiterParser();
        delimiterParser.parse("//;\\n1;2;3");  // 커스텀 구분자 ; 설정
        NumberExtractor extractor = new NumberExtractor(delimiterParser);

        // 실행
        ArrayList<Integer> numbers = extractor.extractNumbers("//;\\n1;2;3");

        // 검증
        assertThat(numbers).containsExactly(1, 2, 3);  // 1, 2, 3이 추출되는지 확인
    }

    @Test
    void extractNumbers_잘못된_구분자가_있을_때_예외_발생() {
        // 준비
        DelimiterParser delimiterParser = new DelimiterParser();
        delimiterParser.parse("//;\\n1;2a;3");  // 커스텀 구분자 ; 설정
        NumberExtractor extractor = new NumberExtractor(delimiterParser);

        // 실행 및 검증
        assertThatThrownBy(() -> extractor.extractNumbers("//;\\n1;2a;3"))
                .isInstanceOf(IllegalArgumentException.class); // 잘못된 구분자가 포함되었을 때 예외 발생
    }
}

package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SplitTest {

    private Split split;

    @BeforeEach
    void 테스트_전_세팅() {
        this.split = Split.of();
    }

    @Test
    void 기본_엔터_분리_확인_구분자_있을때() {
        String userInput = "//;\n123\n";
        List<String> expect = List.of("", "", ";", "123");
        List<String> result = split.splitInputOfEnter(userInput);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 기본_엔터_분리_확인_구분자_없을때() {
        String userInput = "12:45,24\n";
        List<String> expect = List.of("12:45,24");
        List<String> result = split.splitInputOfEnter(userInput);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 구분자_분리_확인() {
        CalculatorParamDomain domain = CalculatorParamDomain.of();
        List<String> splitEnter = List.of("12:45,36");
        List<String> expect = List.of("12", "45", "36");

        domain.splitStringNumbers(splitEnter);
        split.splitNumberOfDelimiter(domain);
        assertThat(domain.getStringNumbers()).isEqualTo(expect);
    }
}
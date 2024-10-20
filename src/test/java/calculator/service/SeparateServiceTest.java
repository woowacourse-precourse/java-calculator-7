package calculator.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SeparateServiceTest {
    private static final String COMMA = ",";

    private static SeparateService separateService;


    @BeforeAll
    static void setUp() {
        separateService = new SeparateService();
    }

    @Test
    @DisplayName("구분자를 기준으로 토큰을 분리하는 데 성공한다.")
    void separate() {
        // given
        String input = "1,2,3";
        String[] expected = input.split(COMMA);

        // when
        String[] real = separateService.separate(input);

        // then
        assertThat(real).isEqualTo(expected);
    }
}
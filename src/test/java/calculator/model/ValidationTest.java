package calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    private Validation validation;

    @BeforeEach
    public void setUp() {
        this.validation = new Validation();
    }

    @Test
    @DisplayName("빈 문자열 양식 입력 검증")
    public void isZeroFromTest() {
        // given
        String inputString = "";
        // when, then
        assertThat(validation.isZeroFrom(inputString)).isTrue();
    }

    @Test
    @DisplayName("허용된 문자열 양식 검증")
    public void isAllowedFromTest() {
        // given
        String inputString1 = "1";
        String inputString2 = "1:2";
        String inputString3 = "1,2";
        String inputString4 = "1:2,3";
        String inputString5 = "10:200,3";
        String inputString6 = "10:200,3:40,58";
        // when, then
        assertThat(validation.isAllowedFrom(inputString1)).isTrue();
        assertThat(validation.isAllowedFrom(inputString2)).isTrue();
        assertThat(validation.isAllowedFrom(inputString3)).isTrue();
        assertThat(validation.isAllowedFrom(inputString4)).isTrue();
        assertThat(validation.isAllowedFrom(inputString5)).isTrue();
        assertThat(validation.isAllowedFrom(inputString6)).isTrue();
    }

    @Test
    @DisplayName("커스텀 구분자 문자열 양식 검증")
    public void isCustomFromTest() {
        // given
        String inputString1 = "//;\\n1;2";
        String inputString2 = "//;\\n1;2;3";
        String inputString3 = "//;\\n1;2;3;4";
        String inputString4 = "//;\\n10;200;37;434";
        String inputString5 = "//?\\n1?2?3";
        String inputString6 = "//?\\n1?2?300";

        // when, then
        assertThat(validation.isCustomFrom(inputString1)).isTrue();
        assertThat(validation.isCustomFrom(inputString2)).isTrue();
        assertThat(validation.isCustomFrom(inputString3)).isTrue();
        assertThat(validation.isCustomFrom(inputString4)).isTrue();
        assertThat(validation.isCustomFrom(inputString5)).isTrue();
        assertThat(validation.isCustomFrom(inputString6)).isTrue();
    }

    @Test
    @DisplayName("잘못된 양식의 문자열 검증 테스트")
    public void notAllowedFromTest() {
        // given
        String inputString = "1.2:3";

        // when, then
        assertThatThrownBy(() -> validation.validate(inputString))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

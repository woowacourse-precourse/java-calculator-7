package calculator.service;

import calculator.model.CustomSeparators;
import calculator.model.DefaultSeparators;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("SeparatorsService 테스트")
class SeparatorsServiceTest {
    private SeparatorsService separatorsService;

    @BeforeEach
    void setUp() {
        separatorsService = new SeparatorsService();
    } // setUp

    @ParameterizedTest(name = "{index} : {2}")
    @DisplayName("구분자에 따라 Separators 객체 생성 확인")
    @MethodSource("generateSeparatorsData")
    void testCreateSeparators(String input, Class output, String message) {
        assertThat(separatorsService.createSeparator(input)).isInstanceOf(output);
    } // testCreateSeparators

    static Stream<Arguments> generateSeparatorsData() {
        return Stream.of(
                Arguments.of("//!@\\n1!2@3", CustomSeparators.class, "커스텀 구분자 포함"),
                Arguments.of("1,2:3", DefaultSeparators.class, "기본 구분자 포함")
        );
    } // generateSeparatorsData

    @Test
    @DisplayName("커스텀 구분자를 포함한 입력값을 구분자 부분으로 잘 나누는지 확인")
    void testGetSeparatePart() {
        assertThat(separatorsService.getSeparatePart("//!@\\n1!2@3")).isEqualTo("!@");
    } // testGetSeparatePart

    @Test
    @DisplayName("커스텀 구분자를 포함한 입력값을 계산 부분으로 잘 나누는지 확인")
    void testGetCalculatePart() {
        assertThat(separatorsService.getCalculatePart("//!@\\n1!2@3")).isEqualTo("1!2@3");
    } // testGetCalculatePart
} // class
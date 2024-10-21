package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.model.CalculatorService;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void testEmptyStringReturnsZero() {
        assertSimpleTest(() -> {
            // Given
            CalculatorService calculator = new CalculatorService();
            String input = "";

            // When
            int result = calculator.add(input);

            // Then
            assertEquals(0, result);
        });
    }

    @Test
    void testNullStringReturnsZero() {
        assertSimpleTest(() -> {
            // Given
            CalculatorService calculator = new CalculatorService();
            String input = null;

            // When
            int result = calculator.add(input);

            // Then
            assertEquals(0, result);
        });
    }

    @Test
    void testSingleNumberReturnsValue() {
        assertSimpleTest(() -> {
            // Given
            CalculatorService calculator = new CalculatorService();
            String input = "1";

            // When
            int result = calculator.add(input);

            // Then
            assertEquals(1, result);
        });
    }

    @Test
    void testNumbersSeparatedByComma() {
        assertSimpleTest(() -> {
            // Given
            CalculatorService calculator = new CalculatorService();
            String input = "1,2";

            // When
            int result = calculator.add(input);

            // Then
            assertEquals(3, result);
        });
    }

    @Test
    void testNumbersSeparatedByColon() {
        assertSimpleTest(() -> {
            // Given
            CalculatorService calculator = new CalculatorService();
            String input = "1:2";

            // When
            int result = calculator.add(input);

            // Then
            assertEquals(3, result);
        });
    }

    @Test
    void testNumbersSeparatedByCommaAndColon() {
        assertSimpleTest(() -> {
            // Given
            CalculatorService calculator = new CalculatorService();
            String input = "1,2:3";

            // When
            int result = calculator.add(input);

            // Then
            assertEquals(6, result);
        });
    }

    @Test
    void testCustomSeparator() {
        assertSimpleTest(() -> {
            // Given
            CalculatorService calculator = new CalculatorService();
            String input = "//;\n1;2;3";

            // When
            int result = calculator.add(input);

            // Then
            assertEquals(6, result);
        });
    }

    @Test
    void testCustomAndDefaultSeparators() {
        assertSimpleTest(() -> {
            // Given
            CalculatorService calculator = new CalculatorService();
            String input = "//;\n1;2,3:4";

            // When
            int result = calculator.add(input);

            // Then
            assertEquals(10, result);
        });
    }

    @Test
    void testNegativeNumberThrowsException() {
        assertSimpleTest(() -> {
            // Given
            CalculatorService calculator = new CalculatorService();
            String input = "-1,-2,3";

            // When & Then
            assertThatThrownBy(() -> calculator.add(input))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void testMultiCharacterCustomSeparatorThrowsException() {
        assertSimpleTest(() -> {
            // Given
            CalculatorService calculator = new CalculatorService();
            String input = "//;;\n1;2;3";

            // When & Then
            assertThatThrownBy(() -> calculator.add(input))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void testCustomSeparatorWithMetaCharacter() {
        assertSimpleTest(() -> {
            // Given
            CalculatorService calculator = new CalculatorService();
            String input = "//+\n1+2";

            // When
            int result = calculator.add(input);

            // Then
            assertEquals(3, result);
        });
    }

    @Test
    void testInputMustEndWithNumber() {
        assertSimpleTest(() -> {
            // Given
            CalculatorService calculator = new CalculatorService();
            String input = "1,2,3,";

            // When & Then
            assertThatThrownBy(() -> calculator.add(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력은 반드시 숫자로 끝나야합니다.");
        });
    }

    @Test
    void testInvalidCustomSeparatorFormatThrowsException() {
        assertSimpleTest(() -> {
            // Given
            CalculatorService calculator = new CalculatorService();
            String input = "//;1;2;3";

            // When & Then
            assertThatThrownBy(() -> calculator.add(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("커스텀 구분자 지정이 잘못되었습니다. '//구분자\\n숫자' 형식으로 입력해야 합니다.");
        });
    }

    @Test
    void testCustomSeparatorWithEmptyStringReturnsZero() {
        assertSimpleTest(() -> {
            // Given
            CalculatorService calculator = new CalculatorService();
            String input = "//;\n";

            // When
            int result = calculator.add(input);

            // Then
            assertEquals(0, result);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

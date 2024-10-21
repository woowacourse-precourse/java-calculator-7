package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
//    @Test
//    void 커스텀_구분자_사용() {
//        assertSimpleTest(() -> {
//            run("//;\\n1");
//            assertThat(output()).contains("결과 : 1");
//        });
//    }

    @Test
    void testEmptyStringReturnsZero() {
        assertSimpleTest(() -> {
            // Given
            StringCalculator calculator = new StringCalculator();
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
            StringCalculator calculator = new StringCalculator();
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
            StringCalculator calculator = new StringCalculator();
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
            StringCalculator calculator = new StringCalculator();
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
            StringCalculator calculator = new StringCalculator();
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
            StringCalculator calculator = new StringCalculator();
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
            StringCalculator calculator = new StringCalculator();
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
            StringCalculator calculator = new StringCalculator();
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
            StringCalculator calculator = new StringCalculator();
            String input = "-1,-2,3";

            // When & Then
            assertThatThrownBy(() -> calculator.add(input))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

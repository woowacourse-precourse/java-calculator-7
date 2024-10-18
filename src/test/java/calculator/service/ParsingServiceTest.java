package calculator.service;

import calculator.domain.Calculator;
import calculator.service.fixture.CalculatorFixture;
import calculator.service.fixture.ExpressionFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParsingServiceTest {

    @Test
    @DisplayName("parsing Operands and Identifiers Without custom identifier")
    void parseOperandsAndIdentifiersWithoutCustomIdentifier() {
        // given
        ParsingService parsingService = new ParsingService(CalculatorFixture.createCalculator());

        //when
        Calculator calculator = parsingService.parsing(ExpressionFixture.EXPRESSION_WITHOUT_CUSTOM_IDENTIFIER);

        // then
        assertThat(calculator.getOperands().size()).isEqualTo(3);
        assertThat(calculator.getIdentifiers().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("parsing Operands and Identifiers With custom identifier")
    void parseOperandsAndIdentifiersWithCustomIdentifier() {
        // given
        ParsingService parsingService = new ParsingService(CalculatorFixture.createCalculator());

        // when
        Calculator calculator = parsingService.parsing(ExpressionFixture.EXPRESSION_WITH_CUSTOM_IDENTIFIER);

        // then
        assertThat(calculator.getOperands().size()).isEqualTo(3);
        assertThat(calculator.getIdentifiers().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Invalid input Stars with one slash")
    void invalidInputStarsWithOneSlash() {
        // given
        ParsingService parsingService = new ParsingService(CalculatorFixture.createCalculator());

        // when
        // then
        assertThatThrownBy(() -> {parsingService.parsing(ExpressionFixture.EXPRESSION_STARTS_WITH_ONE_SLASH);})
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Invalid input Stars without number")
    void invalidInputStarsWithoutNumber() {
        // given
        ParsingService parsingService = new ParsingService(CalculatorFixture.createCalculator());

        // when
        // then
        assertThatThrownBy(() -> {parsingService.parsing(ExpressionFixture.EXPRESSION_STARTS_WITHOUT_NUMBER);})
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Invalid input with double custom identifier")
    void invalidInputDoubleCustomIdentifier() {
        // given
        ParsingService parsingService = new ParsingService(CalculatorFixture.createCalculator());

        // when
        // then
        assertThatThrownBy(() -> {parsingService.parsing(ExpressionFixture.EXPRESSION_DOUBLE_CUSTOM_IDENTIFIER);})
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Invalid input without \\n")
    void invalidInputCustomWithoutSlashN() {
        // given
        ParsingService parsingService = new ParsingService(CalculatorFixture.createCalculator());

        // when
        // then
        assertThatThrownBy(() -> {parsingService.parsing(ExpressionFixture.EXPRESSION_CUSTOM_WITHOUT_SLASH_N);})
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Invalid input blank custom identifier")
    void invalidInputBlankCustomIdentifier() {
        // given
        ParsingService parsingService = new ParsingService(CalculatorFixture.createCalculator());

        // when
        // then
        assertThatThrownBy(() -> {parsingService.parsing(ExpressionFixture.EXPRESSION_BLANK_CUSTOM_IDENTIFIER);})
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Invalid input invalid identifier")
    void invalidInputInvalidIdentifier() {
        // given
        ParsingService parsingService = new ParsingService(CalculatorFixture.createCalculator());

        // when
        // then
        assertThatThrownBy(() -> {parsingService.parsing(ExpressionFixture.EXPRESSION_INVALID_IDENTIFIER);})
                .isInstanceOf(IllegalArgumentException.class);
    }
}
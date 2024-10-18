package calculator.service;

import calculator.domain.Calculator;
import calculator.service.fixture.CalculatorFixture;
import calculator.service.fixture.ExpressionFixture;
import calculator.util.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParserTest {

    private final Calculator calculator = CalculatorFixture.createCalculator();
    private final Parser parser = new Parser();

    @Test
    @DisplayName("parsing Operands and Identifiers Without custom identifier")
    void parseOperandsAndIdentifiersWithoutCustomIdentifier() {

        //when
        parser.parsing(calculator, ExpressionFixture.EXPRESSION_WITHOUT_CUSTOM_IDENTIFIER);

        // then
        assertThat(calculator.getOperands().size()).isEqualTo(3);
        assertThat(calculator.getIdentifiers().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("parsing Operands and Identifiers With custom identifier")
    void parseOperandsAndIdentifiersWithCustomIdentifier() {

        // when
        parser.parsing(calculator, ExpressionFixture.EXPRESSION_WITH_CUSTOM_IDENTIFIER);

        // then
        assertThat(calculator.getOperands().size()).isEqualTo(3);
        assertThat(calculator.getIdentifiers().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Invalid input Stars with one slash")
    void invalidInputStarsWithOneSlash() {
        // when
        // then
        assertThatThrownBy(() -> {
            parser.parsing(calculator, ExpressionFixture.EXPRESSION_STARTS_WITH_ONE_SLASH);})
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Invalid input Stars without number")
    void invalidInputStarsWithoutNumber() {
        // when
        // then
        assertThatThrownBy(() -> {
            parser.parsing(calculator, ExpressionFixture.EXPRESSION_STARTS_WITHOUT_NUMBER);})
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Invalid input with double custom identifier")
    void invalidInputDoubleCustomIdentifier() {
        // when
        // then
        assertThatThrownBy(() -> {
            parser.parsing(calculator, ExpressionFixture.EXPRESSION_DOUBLE_CUSTOM_IDENTIFIER);})
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Invalid input without \\n")
    void invalidInputCustomWithoutSlashN() {
        // when
        // then
        assertThatThrownBy(() -> {
            parser.parsing(calculator, ExpressionFixture.EXPRESSION_CUSTOM_WITHOUT_SLASH_N);})
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Invalid input blank custom identifier")
    void invalidInputBlankCustomIdentifier() {
        // when
        // then
        assertThatThrownBy(() -> {
            parser.parsing(calculator, ExpressionFixture.EXPRESSION_BLANK_CUSTOM_IDENTIFIER);})
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Invalid input invalid identifier")
    void invalidInputInvalidIdentifier() {
        // when
        // then
        assertThatThrownBy(() -> {
            parser.parsing(calculator, ExpressionFixture.EXPRESSION_INVALID_IDENTIFIER);})
                .isInstanceOf(IllegalArgumentException.class);
    }
}

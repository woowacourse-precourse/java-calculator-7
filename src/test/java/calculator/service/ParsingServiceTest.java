package calculator.service;

import calculator.domain.Calculator;
import calculator.service.fixture.CalculatorFixture;
import calculator.service.fixture.ExpressinFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParsingServiceTest {

    @Test
    @DisplayName("parsing Operands and Identifiers Without custom identifier")
    void parseOperandsAndIdentifiersWithoutCustomIdentifier() {
        // given
        ParsingService parsingService = new ParsingService(CalculatorFixture.createCalculator());

        //when
        Calculator calculator = parsingService.parsing(ExpressinFixture.EXPRESSION_WITHOUT_CUSTOM_IDENTIFIER);

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
        Calculator calculator = parsingService.parsing(ExpressinFixture.EXPRESSION_WITH_CUSTOM_IDENTIFIER);

        // then
        assertThat(calculator.getOperands().size()).isEqualTo(3);
        assertThat(calculator.getIdentifiers().size()).isEqualTo(3);
    }
}
package calculator.calculate.service;

import calculator.calculate.dto.request.CalculateRequestDTO;
import calculator.calculate.dto.response.CalculateResponseDTO;
import calculator.global.config.BeanConfig;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculateServiceTest {

    CalculateService calculateService = BeanConfig.getBean(CalculateService.class);

    @ParameterizedTest
    @MethodSource("validParameters")
    void validCalculate(List<Integer> numbers, Integer expectedResult) {
        //given
        CalculateRequestDTO calculateRequestDTO = new CalculateRequestDTO(numbers);

        //when
        CalculateResponseDTO calculateResponseDTO = calculateService.calculate(calculateRequestDTO);

        //then
        Assertions.assertThat(calculateResponseDTO.result()).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> validParameters() {
        return Stream.of(
                Arguments.of(List.of(), 0),
                Arguments.of(List.of(1,2,3), 6),
                Arguments.of(List.of(1), 1)
        );
    }

    @Test
    void inValidCalculate() {
        //given
        CalculateRequestDTO calculateRequestDTO = new CalculateRequestDTO(List.of(-1,2,3));

        //when
        Assertions.assertThatThrownBy(() -> calculateService.calculate(calculateRequestDTO))
                //then
                .isInstanceOf(IllegalArgumentException.class);
    }


}
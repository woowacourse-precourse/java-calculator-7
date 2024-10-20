package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.controller.CalculatorController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SingletonObjectProviderTest {

    @DisplayName("싱글톤 객체 동일성 확인")
    @Test
    void getSingletonObject() {
        //given
        CalculatorController singletonObject = SingletonObjectProvider.getSingletonObject(CalculatorController.class);

        //when
        CalculatorController object = SingletonObjectProvider.getSingletonObject(CalculatorController.class);

        //then
        assertThat(singletonObject).isEqualTo(object);
    }
}
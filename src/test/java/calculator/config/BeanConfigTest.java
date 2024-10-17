package calculator.config;

import static org.assertj.core.api.Assertions.*;

import calculator.config.exception.BeanErrorMessage;
import calculator.config.exception.BeanSearchException;
import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BeanConfigTest {
    @Test
    @DisplayName("CalculatorService 빈이 올바르게 생성되었는지 확인")
    void testGetBean_CalculatorService() {
        CalculatorService service = BeanConfig.getBean(CalculatorService.class);

        assertThat(service)
                .isNotNull()
                .isInstanceOf(CalculatorServiceImpl.class)
                .isInstanceOf(CalculatorService.class);
    }

    @Test
    @DisplayName("등록되지 않은 빈을 요청하면 BeanSearchException이 발생해야 한다.")
    void testGetBean_NotFound() {
        class NonExistentBean {}

        assertThatThrownBy(() -> BeanConfig.getBean(NonExistentBean.class))
                .isInstanceOf(BeanSearchException.class)
                .hasMessageContaining(BeanErrorMessage.BEAN_NOT_FOUND.getMessage());
    }
}
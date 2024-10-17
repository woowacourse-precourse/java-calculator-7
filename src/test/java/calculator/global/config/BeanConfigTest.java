package calculator.global.config;

import calculator.calculate.controller.CalculateController;
import calculator.calculate.service.CalculateService;
import calculator.global.frontController.FrontController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BeanConfigTest {

    @ParameterizedTest
    @ValueSource(classes = {FrontController.class, CalculateController.class, CalculateService.class})
    void 빈_생성_테스트(Class<?> beanClass) {
        // given
        Object bean = BeanConfig.getBean(beanClass);
        //when

        //then
        Assertions.assertThat(bean)
                .isNotNull()
                .isInstanceOf(beanClass);
    }
}
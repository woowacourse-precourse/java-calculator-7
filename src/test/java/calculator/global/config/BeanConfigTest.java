package calculator.global.config;

import calculator.calculate.service.CalculateService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BeanConfigTest {

    @ParameterizedTest
    @ValueSource(classes = {CalculateService.class})
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
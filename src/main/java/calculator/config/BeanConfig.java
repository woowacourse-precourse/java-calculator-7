package calculator.config;

import calculator.FrontController;
import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BeanConfig {
    // 컴파일 타임에 모든 의존성이 정리되며, 런타임에 의존성이 변경되는 일은 없다.
    // -> 동시성을 고려하여 설계하지 않아도 된다.
    private static final Map<Class<?>, Class<?>> abstractToConcreteClassMap = new HashMap<>();
    private static final Map<Class<?>, Object> registeredBeans = new HashMap<>();

    // 순환 참조 방지를 위한 현재 등록 중인 클래스 추적
    private static final Set<Class<?>> beansInCreation = new HashSet<>();

    static {
        abstractToConcreteClassMap.put(CalculatorController.class, CalculatorController.class);
        abstractToConcreteClassMap.put(CalculatorService.class, CalculatorServiceImpl.class);
        abstractToConcreteClassMap.put(FrontController.class, FrontController.class);
    }
}

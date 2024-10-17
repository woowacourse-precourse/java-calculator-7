package calculator.config;

import calculator.FrontController;
import calculator.config.exception.BeanCreationException;
import calculator.config.exception.BeanErrorMessage;
import calculator.config.exception.BeanSearchException;
import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BeanConfig {
    // 스태틱 초기화 블록은 클래스 로딩 시 단일 스레드에 의해 실행, 그 이후 실행 과정에서 빈이 등록되는 일은 없다.
    // -> 동시성을 고려하여 설계하지 않아도 된다고 생각됨
    private static final Map<Class<?>, Class<?>> abstractToConcreteClassMap = new HashMap<>();
    private static final Map<Class<?>, Object> registeredBeans = new HashMap<>();

    // 순환 참조 방지를 위한 현재 등록 중인 클래스 추적
    private static final Set<Class<?>> beansInCreation = new HashSet<>();

    static {
        abstractToConcreteClassMap.put(CalculatorController.class, CalculatorController.class);
        abstractToConcreteClassMap.put(CalculatorService.class, CalculatorServiceImpl.class);
        abstractToConcreteClassMap.put(FrontController.class, FrontController.class);

        abstractToConcreteClassMap.keySet()
                .forEach(abstractClass -> {
                    try {
                        registerBean(abstractClass);
                    } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                        throw BeanCreationException.from(BeanErrorMessage.BEAN_CREATION_ERROR, e);
                    }
                });
    }

    private static void registerBean(Class<?> clazz)
            throws InvocationTargetException, InstantiationException, IllegalAccessException {
        // 이미 등록된 빈은 다시 등록하지 않음
        if (registeredBeans.containsKey(clazz)) {
            return;
        }
        //빈이 아닌 클래스가 들어오면 예외 처리
        if (!abstractToConcreteClassMap.containsKey(clazz)) {
            throw BeanCreationException.from(BeanErrorMessage.INVALID_BEAN_ERROR);
        }
        // 순환 참조에 대한 예외 처리
        if (beansInCreation.contains(clazz)) {
            throw BeanCreationException.from(BeanErrorMessage.CIRCULAR_REFERENCE_DETECTED);
        }

        beansInCreation.add(clazz); // 클래스 등록 과정 시작

        // abstractToConcreteClassMap에서 주어진 clazz의 구체적인 구현 클래스를 가져오기
        Class<?> specificClass = abstractToConcreteClassMap.get(clazz);
        // specificClass의 모든 생성자를 배열로 반환한 후, 첫 번째 생성자([0])를 가져오기
        // -> 사실 이 부분은 생성자가 여러 개일 수도 있는 상황에 대응하지 못하기 때문에 한계가 존재함
        Constructor<?> constructor = specificClass.getConstructors()[0];

        Class<?>[] parameterTypes = constructor.getParameterTypes();

        Object[] dependencies = resolveDependencies(parameterTypes);

        Object beanInstance = constructor.newInstance(dependencies);
        registeredBeans.put(clazz, beanInstance);

        beansInCreation.remove(clazz); // 클래스 등록 완료
    }

    // 선택한 생성자의 파라미터 타입들을 가져오기
    private static Object[] resolveDependencies(Class<?>[] parameterTypes)
            throws InvocationTargetException, InstantiationException, IllegalAccessException {
        return Arrays.stream(parameterTypes)
                .map(dependency -> {
                    if (!registeredBeans.containsKey(dependency)) {
                        try {
                            registerBean(dependency);
                        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                            throw BeanCreationException.from(BeanErrorMessage.BEAN_CREATION_ERROR, e);
                        }
                    }
                    return registeredBeans.get(dependency);
                }).toArray();
    }

    public static <T> T getBean(Class<T> clazz) {
        Object bean = registeredBeans.get(clazz);
        if (bean == null) {
            throw BeanSearchException.from(BeanErrorMessage.BEAN_NOT_FOUND);
        }
        return clazz.cast(bean); // 타입 안전한 캐스팅
    }
}

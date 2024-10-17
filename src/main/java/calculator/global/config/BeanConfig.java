package calculator.global.config;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BeanConfig {

    private static final Map<Class<?>, Class<?>> interfaceImplementationMap = new HashMap<>();

    private static final Map<Class<?>, Object> beanContainer = new HashMap<>();

    private static final Set<Class<?>> currentRegisterLog = new HashSet<>(); // 순환 참조 검사를 위한 Set 객체


    static {
        registerInterfaceImplementation();
        registerTotalBeans();
    }


    // bean에 추가할 객체가 생길 때마다 작성 필요
    private static void registerInterfaceImplementation() {
    }

    // bean 생성 후보에 등록된 클래스들을 순회하면서 생성
    private static void registerTotalBeans() {
        interfaceImplementationMap.keySet()
                .forEach(abstractClass -> {
                    try {
                        registerBean(abstractClass);
                    } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    // bean을 생성하고 등록
    private static void registerBean(Class<?> abstractClass)
            throws InvocationTargetException, InstantiationException, IllegalAccessException {
        if (beanContainer.containsKey(abstractClass)) {
            return;
        }

        if (currentRegisterLog.contains(abstractClass)) {
            throw new IllegalStateException("순환 참조가 발생했습니다.");
        }
        currentRegisterLog.add(abstractClass);

        if (!interfaceImplementationMap.containsKey(abstractClass)) {
            throw new IllegalStateException(String.format("%s에 해당하는 bean 설정이 존재하지 않습니다.", abstractClass));
        }
        Class<?> specificClass = interfaceImplementationMap.get(abstractClass);

        // 현재는 하나의 생성자만 허용
        Constructor<?> constructor = specificClass.getConstructors()[0];
        Class<?>[] parameterTypes = constructor.getParameterTypes();

        Object[] dependencies = Arrays.stream(parameterTypes).map(dependency -> {
            // beanContainer에 이 bean이 의존하고 있는 다른 bean이 생성되지 않았을 때
            if (!beanContainer.containsKey(dependency)) {
                try {
                    registerBean(dependency); // 그 bean을 생성하고 등록
                } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

            return beanContainer.get(dependency);
        }).toArray(Object[]::new);

        Object beanInstance = constructor.newInstance(dependencies); // 생성자 기반으로 생성하고
        beanContainer.put(abstractClass, beanInstance); // beanContainer에 등록

        currentRegisterLog.remove(abstractClass);
    }


    public static <T> T getBean(Class<T> clazz) {
        Object beanObject = beanContainer.get(clazz);
        if (beanObject != null) {
            return clazz.cast(beanObject);
        }

        throw new IllegalArgumentException(String.format("%s의 bean이 존재하지 않습니다.", clazz.getName()));
    }
}

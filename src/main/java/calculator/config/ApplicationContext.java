package calculator.config;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Application Context 관리 (DI, IoC 구현 클래스)
 */
public class ApplicationContext {

    private final List<Class<?>> classes;
    private final Map<Class<?>, Object> beans = new HashMap<>();

    private ApplicationContext(Class<?> cls) {
        classes = ComponentScanner.scan(cls);
        classes.forEach(this::createBean);
    }

    public static ApplicationContext fromEntry(Class<?> cls) {
        return new ApplicationContext(cls);
    }

    /**
     * 등록된 빈을 찾아 반환한다.
     *
     * @param cls 클래스
     * @param <T> 클래스 타입
     * @return 등록된 빈
     */
    public <T> T getBean(Class<T> cls) {
        Object bean = beans.get(cls);
        if (bean == null) {
            throw new RuntimeException("No bean found for class: " + cls.getName());
        }

        return cls.cast(bean);
    }

    /**
     * 클래스 인스턴스를 생성하여 빈에 등록한다.
     *
     * @param cls 클래스
     */
    private void createBean(Class<?> cls) {
        if (beans.containsKey(cls)) {
            return;
        }

        try {
            Constructor<?> constructor = findConstructor(cls);
            Object[] parameters = Arrays.stream(constructor.getParameterTypes())
                    .map(this::resolveDependency)
                    .toArray();

            registerBean(cls, constructor.newInstance(parameters));
        } catch (Exception e) {
            throw new RuntimeException("Failed to create bean for class: " + cls.getName());
        }
    }

    /**
     * 클래스의 생성자를 찾는다.
     *
     * @param cls 클래스
     * @return 클래스의 생성자
     * @throws NoSuchMethodException 메서드를 찾을 수 없다.
     */
    private Constructor<?> findConstructor(Class<?> cls) throws NoSuchMethodException {
        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        if (constructors.length == 0) {
            return cls.getDeclaredConstructor();
        }

        return constructors[0];
    }

    /**
     * 클래스의 구현체를 찾아 반환한다.
     * - 빈으로 등록되어 있다면, 빈을 반환한다.
     * - 인터페이스라면, 인터페이스의 구현체를 등록하고 반환한다.
     * - 빈으로 등록되어 있지 않다면, 등록하고 반환한다.
     *
     * @param cls 클래스
     * @return 등록된 빈(인스턴스)
     */
    private Object resolveDependency(Class<?> cls) {
        if (beans.containsKey(cls)) {
            return beans.get(cls);
        }

        if (cls.isInterface()) {
            Optional<Class<?>> implementation = findImplementation(cls);
            if (implementation.isPresent()) {
                createBean(implementation.get());
                return beans.get(implementation.get());
            }
        }

        Optional<Class<?>> component = findComponent(cls);
        if (component.isPresent()) {
            createBean(component.get());
            return beans.get(component.get());
        }

        throw new RuntimeException("No bean or implementation found for dependency: " + cls.getName());
    }

    /**
     * 인터페이스에 대한 구현체를 찾는다.
     *
     * @param interfaceType 인터페이스
     * @return 구현체
     */
    private Optional<Class<?>> findImplementation(Class<?> interfaceType) {
        return classes.stream()
                .filter(interfaceType::isAssignableFrom)
                .findFirst();
    }

    /**
     * 컴포넌트에서 클래스를 찾는다.
     *
     * @param cls 클래스
     * @return 컴포넌트
     */
    private Optional<Class<?>> findComponent(Class<?> cls) {
        return classes.stream()
                .filter(component -> component.equals(cls))
                .findFirst();
    }

    /**
     * 빈을 등록한다.
     * - 클래스를 키로 인스턴스를 등록한다.
     * - 클래스의 인터페이스를 키로 인스턴스를 등록한다.
     *
     * @param cls      클래스
     * @param instance 인스턴스
     */
    private void registerBean(Class<?> cls, Object instance) {
        beans.put(cls, instance);

        Arrays.stream(cls.getInterfaces())
                .filter(it -> !beans.containsKey(it))
                .forEach(it -> beans.put(it, instance));
    }
}
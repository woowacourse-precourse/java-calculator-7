package calculator.util;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Container {
    private static final Map<String, Object> CONTAINER = new ConcurrentHashMap<>();

    public static <T> T getInstance(Class<T> clazz) {
        String className = clazz.getName();

        if (!CONTAINER.containsKey(className)) {
            T instance = createInstance(clazz);
            CONTAINER.put(className, instance);
            injectDependencies(instance);
        }
        return (T) CONTAINER.get(className);
    }

    private static <T> T createInstance(Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("인스턴스를 생성할 수 없습니다 : " + clazz.getName(), e);
        }
    }

    private static void injectDependencies(Object instance) {
        Class<?> clazz = instance.getClass();
        for (Method method : clazz.getMethods()) {
            if (method.getName().startsWith("set") && method.getParameterCount() == 1) {
                Class<?> paramType = method.getParameterTypes()[0];
                try {
                    Object dependency = getInstance(paramType);
                    method.invoke(instance, dependency);
                } catch (Exception e) {
                    throw new RuntimeException("의존성 주입 실패: " + clazz.getName() + "." + method.getName(), e);
                }
            }
        }
    }
}
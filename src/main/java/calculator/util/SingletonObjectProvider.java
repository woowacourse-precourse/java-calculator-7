package calculator.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class SingletonObjectProvider {
    public static final Map<Class<?>, Object> SINGLETON_OBJECT_MAP = new ConcurrentHashMap<>();

    // 주어진 클래스의 싱글톤 객체를 반환
    public static <T> T getSingletonObject(Class<T> clazz) {
        if (SINGLETON_OBJECT_MAP.containsKey(clazz)) {
            return (T) SINGLETON_OBJECT_MAP.get(clazz);
        } else {
            T instance = createInstance(clazz);
            SINGLETON_OBJECT_MAP.put(clazz, instance);
            return instance;
        }
    }

    // 클래스의 인스턴스를 생성하는 메소드
    private static <T> T createInstance(Class<T> clazz) {
        try {
            // 기본 생성자를 사용하여 객체 생성
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("객체 생성에 실패했습니다: " + clazz.getName(), e);
        }
    }
}

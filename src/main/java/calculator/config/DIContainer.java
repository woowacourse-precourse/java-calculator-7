package calculator.config;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class DIContainer {

	private final Set<Object> beans;

	public DIContainer(final Set<Class<?>> classes) {
		this.beans = createBeans(classes);
		this.beans.forEach(this::setFields);
	}

	private Set<Object> createBeans(final Set<Class<?>> classes) {
		Set<Object> beans = new HashSet<>();
		for (Class<?> aClass : classes) {
			beans.add(createInstance(aClass));
		}
		return beans;
	}

	private static Object createInstance(final Class<?> aClass) {
		try {
			final Constructor<?> constructor = aClass.getDeclaredConstructor();
			constructor.setAccessible(true);
			return constructor.newInstance();
		} catch(InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new RuntimeException();
		}
	}

	private void setFields(final Object bean) {
		final Field[] fields = bean.getClass().getDeclaredFields();

		for (Field field : fields) {
			setBeanField(bean, field);
		}
	}

	private void setBeanField(final Object bean, final Field field) {
		try {
			injectField(bean, field);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	private void injectField(final Object bean, final Field field) throws IllegalAccessException {
		field.setAccessible(true);
		final Class<?> fieldType = field.getType();
		for (Object o : beans) {
			if (fieldType.isAssignableFrom(o.getClass())) {
				field.set(bean, o);
			}
		}
	}

	public <T> T getBean(final Class<T> aClass) {
		return (T) beans.stream()
			.filter(bean -> aClass.isAssignableFrom(bean.getClass()))
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}
}

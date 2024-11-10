package calculator.controller.converter;

public interface Converter<S, T> {  // 변화가 많을 것으로 예상하여 Converter 사용

    T convert(final S source);
}

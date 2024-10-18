package calculator.converter;

import java.util.List;

public interface NumberConvertible<T> {

    List<T> convertStringToNumber(final String[] splitedByRegex);

}

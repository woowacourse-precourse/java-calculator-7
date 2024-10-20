package calculator.util.convertor;

import java.util.List;

public interface StringConvertor<T> {

    List<T> convertToListWithDelimiter(final String str, final String delimiter);

}

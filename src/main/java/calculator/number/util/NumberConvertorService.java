package calculator.number.util;

import java.util.List;

public interface NumberConvertorService {
    Number stringToNumberBlankIsZero(String input);

    List<Number> stringListToNumberList(List<String> numberInfo);
}
